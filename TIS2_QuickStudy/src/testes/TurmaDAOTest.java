package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.*;
import dao.*;

class TurmaDAOTest {

	@Test
	void testAddEGet() {
		Turma turma1 = new Turma(123455, "04/06/2019", "05/06/2019", 3, 50.00, 2, 6);
		TurmaDAO testeDAO = new TurmaDAO();

		testeDAO.add(turma1);

		Integer id = turma1.getIdTurma();

		turma1 = testeDAO.get(id);
	
		assertEquals("04/06/2019", turma1.getData_inicio(), "O get não retornou a data de inicio correta.");
		assertEquals("05/06/2019", turma1.getData_fim(), "O get não retornou a data de fim correta.");
		assertEquals(3, turma1.getDuracao(), "O get não retornou a duração correta.");
		assertEquals(50.00, turma1.getPreco(), "O get não retornou o preço correto.");
		assertEquals(2, turma1.getQtdMinAlunos(), "O get não retornou a quantidade mínima correta.");
		assertEquals(6, turma1.getQtdMaxAlunos(), "O get não retornou a quantidade máxima correta.");
	}

	@Test
	void testUpdate() {

		Turma turma1 = new Turma(123456, "04/06/2019", "05/06/2019", 3, 50.00, 2, 6);
		TurmaDAO testeDAO = new TurmaDAO();
		testeDAO.add(turma1);
		turma1.setDuracao(4);
		testeDAO.update(turma1);
		Integer chave = turma1.getIdTurma();
		turma1 = null;
		turma1 = testeDAO.get(chave);

		assertEquals(4, turma1.getDuracao(), "O update não mudou a duração da forma correta.");
		assertEquals(50.00, turma1.getPreco(), "O update não manteve o preço da forma correta.");

	}

	@Test
	void testDeleteEGetAll() {

		Turma turma1 = new Turma(123457, "04/06/2019", "05/06/2019", 3, 50.00, 2, 6);
		Turma turma2 = new Turma(123458, "10/06/2019", "16/06/2019", 7, 100.00, 2, 6);
		TurmaDAO testeDAO = new TurmaDAO();

		testeDAO.add(turma1);

		testeDAO.add(turma2);

		int tamanhoAntes = testeDAO.getAll().size();
		testeDAO.delete(turma2);
		int tamanhoDepois = testeDAO.getAll().size();

		assertEquals(1, tamanhoAntes - tamanhoDepois, "O delete não deletou a turma da forma correta.");

	}

}
