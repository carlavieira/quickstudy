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

	private static Usuario usuario = new Usuario();
	private static Curso curso = new Curso();
	private static Turma turma = new Turma();
	private static TurmaService turmaServ = new TurmaService();
	private static UsuarioService usuarioServ = new UsuarioService();
	private static CursoService cursoServ = new CursoService();

	@Override
	public void handle(Request request, Response response) {
		try {

			String path = request.getPath().getPath();

			if (path.startsWith("/validaUsuario")) {
				JsonObject obj = usuarioServ.validaUsuario(request, usuario);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}

			if (path.startsWith("/cadastraUsuario")) {
				JsonObject obj = usuarioServ.criaUsuario(request, usuario);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}
			if (path.startsWith("/adicionaCurso")) {
				JsonObject obj = cursoServ.adicionaCurso(request, curso);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}
			if (path.startsWith("/mostraDados")) {
				JsonObject obj = usuarioServ.mostrarDados(request, usuario);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}
			if (path.startsWith("/adicionaTurma")) {
				JsonObject obj = turmaServ.adicionaTurma(request, turma);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}

		} catch (Exception e) {
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
