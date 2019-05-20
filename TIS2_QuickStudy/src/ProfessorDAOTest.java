import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ProfessorDAOTest {
	
	ProfessorDAO testeDAO;
	Professor prof1;
	Professor prof2;
	

	@Test
	void testAddEGet() {
		prof1 = new Professor("carlaamvieira@gmai.com", "1234", "123456789", "Carla Vieira", "Engenharia de Software" );
		testeDAO = new ProfessorDAO();
		
		testeDAO.add(prof1);
		
		Integer chave = prof1.getIdProfessor();
		prof1 = null;
		
		prof1 = testeDAO.get(chave);
		
		assertEquals("carlaamvieira@gmai.com", prof1.getEmail(), "O get não retornou o email correto.");
		assertEquals("1234", prof1.getSenha(), "O get não retornou a senha correta.");
		assertEquals("123456789", prof1.getCpf(), "O get não retornou o CPF correto.");
		assertEquals("Carla Vieira", prof1.getNome(), "O get não retornou o nome correto.");
		assertEquals("Engenharia de Software", prof1.getFormacao(), "O get não retornou a formação correta.");
	}
	
	@Test
	void testUpdate() {
		
		prof1 = new Professor("carlaamvieira@gmai.com", "1234", "123456789", "Carla Vieira", "Engenharia de Software" );
		testeDAO.add(prof1);
		
		prof1.setSenha("4321");
		
		testeDAO.update(prof1);
		Integer chave = prof1.getIdProfessor();
		
		prof1 = null;
		prof1 = testeDAO.get(chave);
		
		assertEquals("4321", prof1.getSenha(), "O update não mudou a senha da forma correta.");
		assertEquals("Carla Vieira", prof1.getNome(), "O update não mantede o nome da forma correta.");
		
	}


}
