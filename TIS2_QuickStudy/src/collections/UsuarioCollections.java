package collections;

import java.util.ArrayList;
import java.util.List;

import classes.*;
import dao.*;

public class UsuarioCollections {
	
	static UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public List<Usuario> usuariosFormacao(String formacao){
		List<Usuario> usuariosFiltrados = new ArrayList<Usuario>();
		List<Usuario> cursos = usuarioDAO.getAll();
		cursos.stream().filter(usuario -> usuario.getFormacao().equals(formacao)).forEach(usuario ->usuariosFiltrados.add(usuario));
		return usuariosFiltrados;
	}

	}