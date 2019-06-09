package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.*;
import dao.*;

class CursoDAOTest {

	@Test
	void testAddEGet() {
		Curso curso1 = new Curso(12454, "Programação Modular", "Tecnologia", "Descrição Modular");
		CursoDAO testeDAO = new CursoDAO();

		testeDAO.add(curso1);

		Integer id = curso1.getIdCurso();

		curso1 = testeDAO.get(id);
		
		assertEquals(12454, curso1.getIdDono(), "O get não retornou o id do dono correto.");
		assertEquals("Programação Modular", curso1.getNome(), "O get não retornou o nome correto.");
		assertEquals("Tecnologia", curso1.getCategoria(), "O get não retornou a categoria correta.");
		assertEquals("Descrição Modular", curso1.getDescricao(), "O get não retornou a descrição correta.");
	}

	@Test
	void testUpdate() {

		Curso curso1 = new Curso(32123, "Programação Modular", "Tecnologia", "Descrição Modular");
		CursoDAO testeDAO = new CursoDAO();

		testeDAO.add(curso1);;
		
		curso1.setDescricao("Outra descrição");
		testeDAO.update(curso1);
		Integer chave = curso1.getIdCurso();

		curso1 = null;
		curso1 = testeDAO.get(chave);

		assertEquals("Outra descrição", curso1.getDescricao(), "O update não mudou a descrição da forma correta.");
		assertEquals("Programação Modular", curso1.getNome(), "O update não manteve o nome da forma correta.");

	}

	@Test
	void testDeleteEGetAll() {

		Curso curso1 = new Curso(2455, "Programação Modular", "Tecnologia", "Descrição Modular");
		Curso curso2 = new Curso(3253, "Arquitetura de Comptadores", "Tecnologia", "Descrição Arquitetura");
		CursoDAO testeDAO = new CursoDAO();

		testeDAO.add(curso1);

		testeDAO.add(curso2);

		int tamanhoAntes = testeDAO.getAll().size();
		testeDAO.delete(curso2);
		int tamanhoDepois = testeDAO.getAll().size();

		assertEquals(1, tamanhoAntes - tamanhoDepois, "O delete não deletou o curso da forma correta.");

	}

}
