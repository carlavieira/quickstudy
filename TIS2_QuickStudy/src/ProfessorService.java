
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

import com.google.gson.JsonObject;


public class ProfessorService {

	ProfessorDAO professoresDao = new ProfessorDAO();
	
	public JsonObject adiciona(Request request, Professor professor) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			professor.setEmail(query.get("email"));
			professor.setSenha(query.get("senha"));
			professor.setCpf(query.get("cpf"));
			professor.setNome(query.get("nome"));
			professor.setFormacao(query.get("formacao"));
			professoresDao.add(professor);
			obj.addProperty("status", 1);
			obj.addProperty("message", "Professor cadastrado com sucesso");
			
		}catch(Exception e) {
			obj.addProperty("status", 0);
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
}
