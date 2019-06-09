package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import classes.*;
import collections.*;
import dao.*;

class TurmaCollectionsTest {

	@Test
	void testTurmasCurso() {
		TurmaCollections turmaCol = new TurmaCollections();
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> turmasCurso1 = new ArrayList<Turma>();
		List<Turma> turmasCurso2 = new ArrayList<Turma>();
		Curso curso1 = new Curso(12345, "ABC", "Tecnologia", "Descrição Modular");
		Curso curso2 = new Curso(43212, "DEF", "Culinária", "Descrição Modular");
		Turma turma1 = new Turma(curso1.getIdCurso(), "04/06/2019", "05/06/2019", 3, 50.00, 2, 6);
		Turma turma2 = new Turma(curso1.getIdCurso(), "10/06/2019", "16/06/2019", 7, 100.00, 2, 6);
		Turma turma3 = new Turma(curso2.getIdCurso(), "15/06/2019", "23/06/2019", 3, 250.00, 2, 6);


		turmaDAO.add(turma1);
		turmaDAO.add(turma2);
		turmaDAO.add(turma3);
		

		turmasCurso1 = turmaCol.turmasDoCurso(curso1.getIdCurso());
		turmasCurso2 = turmaCol.turmasDoCurso(curso2.getIdCurso());

		
		assertEquals(2, turmasCurso1.size(), "Não retornou tamanho da lista do usuario 1 certo.");
		assertEquals(1, turmasCurso2.size(), "Não retornou tamanho da lista do usuario 2 certo.");
		assertEquals(true, turmasCurso1.contains(turma1), "A turma 1 não está na lista do curso 1.");
		assertEquals(true, turmasCurso1.contains(turma2), "A turma 2 não está na lista do curso 1.");
		assertEquals(false, turmasCurso1.contains(turma3), "A turma 3 está na lista do curso 1.");
		assertEquals(false, turmasCurso2.contains(turma1), "A turma 1 está na lista do curso 2.");
		assertEquals(false, turmasCurso2.contains(turma2), "A turma 2 está na lista do curso 2.");
		assertEquals(true, turmasCurso2.contains(turma3), "A turma 1 não está na lista do curso 2.");
	}


}
