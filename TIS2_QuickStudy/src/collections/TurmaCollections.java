package collections;

import java.util.ArrayList;
import java.util.List;

import classes.*;
import dao.*;

public class TurmaCollections {
	
	static TurmaDAO turmaDAO = new TurmaDAO();
	
	public List<Turma> turmasDoCurso(int idCurso){
		List<Turma> turmasDoCurso = new ArrayList<Turma>();
		List<Turma> allTurma = turmaDAO.getAll();
		allTurma.stream().filter(turma -> turma.getIdCurso()==idCurso).forEach(turma ->turmasDoCurso.add(turma));
		return turmasDoCurso;
	}
	
}
	
