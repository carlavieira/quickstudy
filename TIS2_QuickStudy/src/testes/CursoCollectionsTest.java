package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import classes.*;
import classes.Usuario;
import collections.*;
import dao.*;

class CursoCollectionsTest {

	@Test
	void testCursosUsurario() {
		CursoCollections cursoCol = new CursoCollections();
		CursoDAO testeDAO = new CursoDAO();
		List<Curso> cursosUsuario1 = new ArrayList<Curso>();
		List<Curso> cursosUsuario2 = new ArrayList<Curso>();
		Usuario usuario1 = new Usuario("carlavieira", "1234", "Carla Vieira", "carlaamvieira@gmail.com", 12345678, "Engenharia de Software");
		Usuario usuario2 = new Usuario("joaodasilva", "4321", "João da Silva", "joaodasilva@gmail.com", 87654321, "Engenharia de Sistemas");
		Curso curso1 = new Curso(usuario1.getIdUsuario(), "ABC", "Tecnologia", "Descrição Modular");
		Curso curso2 = new Curso(usuario1.getIdUsuario(), "DEF", "Culinária", "Descrição Modular");
		Curso curso3 = new Curso(usuario2.getIdUsuario(), "GHI", "Tecnologia", "Descrição Modular");

		testeDAO.add(curso1);
		testeDAO.add(curso2);
		testeDAO.add(curso3);
		

		cursosUsuario1 = cursoCol.cursosDoUsuario(usuario1.getIdUsuario());
		cursosUsuario2 = cursoCol.cursosDoUsuario(usuario2.getIdUsuario());
		
		assertEquals(2, cursosUsuario1.size(), "Não retornou tamanho da lista do usuario 1 certo.");
		assertEquals(1, cursosUsuario2.size(), "Não retornou tamanho da lista do usuario 2 certo.");
		assertEquals(true, cursosUsuario1.contains(curso1), "O curso 1 não está na lista do usuário 1.");
		assertEquals(true, cursosUsuario1.contains(curso2), "O curso 2 não está na lista do usuário 1.");
		assertEquals(false, cursosUsuario1.contains(curso3), "O curso 3 está na lista do usuário 1.");
		assertEquals(false, cursosUsuario2.contains(curso1), "O curso 1 está na lista do usuário 2.");
		assertEquals(false, cursosUsuario2.contains(curso2), "O curso 2 está na lista do usuário 2.");
		assertEquals(true, cursosUsuario2.contains(curso3), "O curso 1 não está na lista do usuário 2.");
	}
	
	@Test
	void testCursosCategoria() {
		CursoCollections cursoCol = new CursoCollections();
		CursoDAO testeDAO = new CursoDAO();
		List<Curso> cursosCategoria1 = new ArrayList<Curso>();
		List<Curso> cursosCategoria2 = new ArrayList<Curso>();
		Curso curso1 = new Curso(12345, "ABC", "Tecnologia", "Descrição");
		Curso curso2 = new Curso(54321, "DEF", "Culinária", "Descrição");
		Curso curso3 = new Curso(12345, "GHI", "Tecnologia", "Descrição");

		testeDAO.add(curso1);
		testeDAO.add(curso2);
		testeDAO.add(curso3);
		
		cursosCategoria1 = cursoCol.cursosCategoria("Tecnologia");
		cursosCategoria2 = cursoCol.cursosCategoria("Culinária");

		assertEquals(true, cursosCategoria1.contains(curso1), "O curso 1 não está na lista da categoria 1.");
		assertEquals(false, cursosCategoria1.contains(curso2), "O curso 2 está na lista do categoria 1.");
		assertEquals(true, cursosCategoria1.contains(curso3), "O curso 3 não está na lista do categoria 1.");
		assertEquals(false, cursosCategoria2.contains(curso1), "O curso 1 está na lista do categoria 2.");
		assertEquals(true, cursosCategoria2.contains(curso2), "O curso 2 não está na lista do categoria 2.");
		assertEquals(false, cursosCategoria2.contains(curso3), "O curso 1 está na lista do categoria 2.");
	}
	
	@Test
	void testCursoNome() {
		CursoCollections cursoCol = new CursoCollections();
		CursoDAO testeDAO = new CursoDAO();
		List<Curso> cursos1 = new ArrayList<Curso>();
		List<Curso> cursos2 = new ArrayList<Curso>();
		Curso curso1 = new Curso(12345, "ABC", "Tecnologia", "Descrição");
		Curso curso2 = new Curso(54321, "DEF", "Culinária", "Descrição");
		Curso curso3 = new Curso(12345, "ABC", "Tecnologia", "Descrição");

		testeDAO.add(curso1);
		testeDAO.add(curso2);
		testeDAO.add(curso3);
		
		cursos1 = cursoCol.cursosNome("ABC");
		cursos2 = cursoCol.cursosNome("DEF");

		assertEquals(true, cursos1.contains(curso1), "O curso 1 não está na lista de ACB.");
		assertEquals(false, cursos1.contains(curso2), "O curso 2 está na lista do de ACB.");
		assertEquals(true, cursos1.contains(curso3), "O curso 3 não está na lista de ACB.");
		assertEquals(false, cursos2.contains(curso1), "O curso 1 está na lista de DEF.");
		assertEquals(true, cursos2.contains(curso2), "O curso 2 não está na lista de DEF.");
		assertEquals(false, cursos2.contains(curso3), "O curso 1 está na lista do de DEF.");
	}

}
