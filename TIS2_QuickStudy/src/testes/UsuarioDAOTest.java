package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import classes.Usuario;
import dao.UsuarioDAO;;

class UsuarioDAOTest {
	
	UsuarioDAO testeDAO;
	Usuario prof1;
	Usuario prof2;
	

	@Test
	void testAddEGet() {
		prof1 = new Usuario("carlavieira", "1234", "Carla Vieira", "carlaamvieira@gmail.com", 12345678, "Engenharia de Software");
		testeDAO = new UsuarioDAO();
		
		testeDAO.add(prof1);
		
		Integer id = prof1.getIdUsuario();

		prof1 = testeDAO.get(id);
		
		assertEquals("carlaamvieira@gmail.com", prof1.getEmail(), "O get não retornou o email correto.");
		assertEquals("1234", prof1.getSenha(), "O get não retornou a senha correta.");
		assertEquals(12345678, prof1.getCpf(), "O get não retornou o CPF correto.");
		assertEquals("Carla Vieira", prof1.getNome(), "O get não retornou o nome correto.");
		assertEquals("Engenharia de Software", prof1.getFormacao(), "O get não retornou a formação correta.");
	}
	
	@Test
	void testUpdate() {
		
		prof1 = new Usuario("carlavieira", "1234", "Carla Vieira", "carlaamvieira@gmail.com", 12345678, "Engenharia de Software");
		testeDAO = new UsuarioDAO();
		testeDAO.add(prof1);
		
		prof1.setSenha("4321");
		testeDAO.update(prof1);
		Integer chave = prof1.getIdUsuario();
		prof1 = null;
		prof1 = testeDAO.get(chave);
		
		assertEquals("4321", prof1.getSenha(), "O update não mudou a senha da forma correta.");
		assertEquals("Carla Vieira", prof1.getNome(), "O update não manteve o nome da forma correta.");
		
	}
	
	@Test
	void testDeleteEGetAll() {
		
		prof1 = new Usuario("carlavieira", "1234", "Carla Vieira", "carlaamvieira@gmail.com", 12345678, "Engenharia de Software");
		prof2 = new Usuario("carlamartins", "1234", "Carla Martins", "carlaamvieira@gmail.com", 5431234, "Engenharia de Software");
		testeDAO = new UsuarioDAO();
		
		testeDAO.add(prof1);
		
		testeDAO.add(prof2);
		
		int tamanhoAntes = testeDAO.getAll().size();
		testeDAO.delete(prof2);
		int tamanhoDepois = testeDAO.getAll().size();
		
		assertEquals(1, tamanhoAntes-tamanhoDepois, "O delete não deletou a conta da forma correta.");

	}

}
