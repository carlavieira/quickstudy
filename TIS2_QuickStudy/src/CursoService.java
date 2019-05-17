import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

public class CursoService {

	CursoDAO cursosDao = new CursoDAO();
	
	public JsonObject adiciona(Request request, Curso curso) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			curso.setNome(query.get("nome"));
			curso.setDescrição(query.get("descricao"));
			curso.setDisponivel(query.getBoolean("disponivel"));
			cursosDao.add(curso);
			obj.addProperty("status", 1);
			obj.addProperty("message", "Curso adicionado com sucesso");
			
		}catch(Exception e) {
			obj.addProperty("status", 0);
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
}