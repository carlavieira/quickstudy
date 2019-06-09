package service;

import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

import com.google.gson.JsonObject;

import classes.*;
import dao.*;

public class UsuarioService {

	UsuarioDAO usuariosDao = new UsuarioDAO();
	
	public JsonObject criaUsuario(Request request, Usuario usuario) {
		Query query = request.getQuery();
		JsonObject obj = new JsonObject();
		
		try {
			usuario.setUsuario(query.get("usuario"));
			usuario.setSenha(query.get("senha"));
			usuario.setNome(query.get("nome"));
			usuario.setEmail(query.get("email"));
			usuario.setCpf(query.getInteger("cpf"));
			usuario.setFormacao(query.get("formacao"));
			usuariosDao.add(usuario);
			obj.addProperty("message", "Usuario adicionado com sucesso");
			
		}catch(Exception e) {
			obj.addProperty("message", e.getMessage());
			obj.addProperty("stackTrace", e.getStackTrace().toString());
			obj.addProperty("type", e.getClass().toGenericString());
		}
		
		return obj;
	}
	
	  public JsonObject validaUsuario(Request request, Usuario usuario) {
		    Query query = request.getQuery();
		    JsonObject obj = new JsonObject();

		    try {
		      usuario = usuariosDao.get(query.getInteger("user"));
		      if (usuario != null) {
		        if (usuario.getSenha().equals(query.get("senha"))) {
		          obj.addProperty("status", 1);
		        } else {
		          obj.addProperty("status", 2);
		          obj.addProperty("message", "Senha incorreta");
		        }
		      } else {
		        obj.addProperty("status", 3);
		        obj.addProperty("message", "Essa conta não consta nos nossos dados.");
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		      obj.addProperty("status", 0);
		      obj.addProperty("message", e.getMessage());
		      obj.addProperty("stackTrace", e.getStackTrace().toString());
		      obj.addProperty("type", e.getClass().toGenericString());
		    }

		    return obj;
		  }
	  
	  public JsonObject mostrarDados(Request request, Usuario usuario) {
		    JsonObject obj = new JsonObject();

		    try {

		        JsonObject dados = new JsonObject();
		        dados.addProperty("usuario", usuario.getUsuario());
		        dados.addProperty("senha", usuario.getSenha());
		        dados.addProperty("nome", usuario.getNome());
		        dados.addProperty("email", usuario.getEmail());
		        dados.addProperty("cpf", usuario.getCpf());
		        dados.addProperty("formacao", usuario.getFormacao());
	

		      obj.add("dados", dados);
		      obj.addProperty("status", 1);
		      obj.addProperty("message", "Produtos impressos com sucesso!");

		    } catch (Exception e) {
		      e.printStackTrace();
		      obj.addProperty("status", 0);
		      obj.addProperty("message", e.getMessage());
		      obj.addProperty("stacktrace", e.getStackTrace().toString());
		    }

		    return obj;
		  }
	
}
