import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

public class TurmaService {

	TurmaDAO turmasDao = new TurmaDAO();
	
	public JsonObject adiciona(Request request, Turma produto) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			produto.setNome(query.get("nome"));
			produto.setDescricao(query.get("descricao"));
			produto.setDisponivel(query.getBoolean("disponivel"));
			produtosDao.add(produto);
			obj.addProperty("status", 1);
			obj.addProperty("message", "Produto adicionado com sucesso");
			
		}catch(Exception e) {
			obj.addProperty("status", 0);
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
}