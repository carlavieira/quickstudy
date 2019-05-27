
package service;

import org.simpleframework.http.Query;

import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

import classes.*;
import DAO.*;

public class CursoService {

	CursoDAO cursosDao = new CursoDAO();
	
	public JsonObject adiciona(Request request, Curso curso) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			curso.setNome(query.get("nome"));
			curso.setCategoria(query.get("categoria"));
			curso.setDescrição(query.get("descrição"));
			cursosDao.add(curso);
			obj.addProperty("message", "Curso adicionado com sucesso");
			
		}catch(Exception e) {
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
}
