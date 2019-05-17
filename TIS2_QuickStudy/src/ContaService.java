
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

public class ContaService {

	ContaDAO contasDao = new ContaDAO();
	
	public JsonObject validaConta(Request request, Conta conta) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			conta = contasDao.get(query.get("user"));
			if(conta.getSenha().equals(query.get("senha"))) {
				obj.addProperty("status", 1);
				obj.addProperty("permissao", conta.getPermissao());
			}
			else {
				obj.addProperty("status", 2);
				obj.addProperty("message", "Senha incorreta");
			}
			
		}catch(Exception e) {
			obj.addProperty("status", 0);
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
}
