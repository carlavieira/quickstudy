import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import com.google.gson.JsonObject;


public class HTTPServer implements Container {

	private static Conta conta = new Conta();
	private static ContaService contaServ = new ContaService();
	private static CursoService proServ = new CursoService();
	private static TurmaService proServ1 = new TurmaService();
	
	public void handle(Request request, Response response) {
		
		try {
			PrintStream body = response.getPrintStream();
			
			String path = request.getPath().getPath();

			if(path.startsWith("/verificarConta")) {
				JsonObject obj = contaServ.validaConta(request, conta);
				this.enviaResposta(Status.CREATED, response, obj.toString());
			}
			else if(path.startsWith("/adicionaProduto")) {
				JsonObject obj = proServ.adiciona(request, new Curso());
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

	public static void main(String[] list) throws Exception {
		
		int porta = 880;

		// Configura uma conexão soquete para o servidor HTTP.
		Container container = new HTTPServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);
		
		//Testa a conexão abrindo o navegador padrão.
		Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + porta));

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();

	}
}