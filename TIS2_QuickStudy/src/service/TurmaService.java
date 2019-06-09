package service;

import org.simpleframework.http.Query;

import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

import classes.*;
import dao.*;

public class TurmaService {

	TurmaDAO turmasDao = new TurmaDAO();
	
	public JsonObject adicionaTurma(Request request, Turma turma) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			turma.setData_inicio(query.get("data_inicio"));
			turma.setData_fim(query.get("data_fim"));
			turma.setDuracao(query.getInteger("duracao"));
			turma.setPreco(query.getFloat("preco"));
			turma.setQtdMinAlunos(query.getInteger("qtd_min"));
			turma.setQtdMaxAlunos(query.getInteger("qtd_max"));
			turmasDao.add(turma);
			obj.addProperty("message", "Turma adicionada com sucesso");
			
		}catch(Exception e) {
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
}
