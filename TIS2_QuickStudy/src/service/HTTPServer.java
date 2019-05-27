package service;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.simpleframework.http.Status;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import com.google.gson.JsonObject;
import classes.*;

public class HTTPServer implements Container {

	private static Professor prof = new Professor();
	private static Curso curso = new Curso();
	private static ProfessorService profServ = new ProfessorService();
	private static CursoService cursoServ = new CursoService();


	@Override
	public void handle(Request request, Response response) {
		try {
			// Recupera a URL e o método utilizado.

			String path = request.getPath().getPath();

			if(path.startsWith("/cadastraProfessor")) {
				JsonObject obj = profServ.adiciona(request, prof);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}
			else if(path.startsWith("/adicionaCurso")) {
				JsonObject obj = cursoServ.adiciona(request, curso);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}


		}catch(Exception e){
			e.printStackTrace();
		}

	}

	private void enviaResposta(Status status, Response response, String str) throws Exception {


		PrintStream body = response.getPrintStream();
		long time = System.currentTimeMillis();

		response.setValue("Content-Type", "application/json");
		response.setValue("Server", "EComandads (1.0)");
		response.setValue("Access-Control-Allow-Origin", "null");
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
		response.setStatus(status);

		if (str != null)
			body.println(str);
		body.close();
	}

	public static void main(String[] args) throws IOException {

		int porta = 7200;

		// Configura uma conexão soquete para o servidor HTTP.
		Container container = new HTTPServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();

	}

}
