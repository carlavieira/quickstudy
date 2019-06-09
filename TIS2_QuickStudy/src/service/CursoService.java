
package service;

import org.simpleframework.http.Query;

import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

import classes.*;
import dao.*;

public class CursoService {

	CursoDAO cursosDao = new CursoDAO();
	
	public JsonObject adicionaCurso(Request request, Curso curso) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			curso.setNome(query.get("nome"));
			curso.setCategoria(query.get("categoria"));
			curso.setDescricao(query.get("descrição"));
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
