package collections;

import java.util.ArrayList;
import java.util.List;

import classes.*;
import dao.*;

public class CursoCollections {
	
	static CursoDAO cursoDAO = new CursoDAO();
	
	public List<Curso> cursosDoUsuario(int idUsuario){
		List<Curso> meusCursos = new ArrayList<Curso>();
		List<Curso> cursos = cursoDAO.getAll();
		cursos.stream().filter(curso -> curso.getIdDono()==idUsuario).forEach(curso ->meusCursos.add(curso));
		return meusCursos;
	}
	
	public List<Curso> cursosCategoria(String categoria){
		List<Curso> filtradoCursos = new ArrayList<Curso>();
		List<Curso> cursos = cursoDAO.getAll();
		cursos.stream().filter(curso -> curso.getCategoria().equals(categoria)).forEach(curso ->filtradoCursos.add(curso));
		return filtradoCursos;
	}
	
	public List<Curso> cursosNome(String nome){
		List<Curso> filtradoCursos = new ArrayList<Curso>();
		List<Curso> cursos = cursoDAO.getAll();
		cursos.stream().filter(curso -> curso.getNome().equals(nome)).forEach(curso ->filtradoCursos.add(curso));
		return filtradoCursos;
	}
	
	public List<Curso> cursosCategoriaUsuario(int idUsuario, String categoria){
	List<Curso> filtradoCursos = new ArrayList<Curso>();
	List<Curso> cursos = cursoDAO.getAll();
	cursos.stream().filter(curso -> curso.getCategoria().equals(categoria) && curso.getIdDono()==idUsuario).forEach(curso ->filtradoCursos.add(curso));
	return filtradoCursos;
	}
	
}
