package testes;

import java.io.IOException;

import classes.Usuario;
import dao.UsuarioDAO;

public class Teste {
	
	public static void main(String[] args) throws IOException  {
			
			UsuarioDAO testeDAO;
			Usuario prof1;
			Usuario prof2;
			

				prof1 = new Usuario("carlavieira", "1234", "Carla Vieira", "carlaamvieira@gmail.com", 12345678, "Engenharia de Software");
				prof2 = new Usuario("carlavieira2", "1234", "Carla Vieira", "carlaamvieira@gmail.com", 12345678, "Engenharia de Software");
				System.out.println(prof1.getIdUsuario());
				System.out.println(prof2.getIdUsuario());
				System.out.println(prof1.getNome());
				
				testeDAO = new UsuarioDAO();
				System.out.println("prof1 = "+prof1);
				testeDAO.add(prof1);
				System.out.println("prof1 = "+prof1);
				Integer chave = prof1.getIdUsuario();
				System.out.println(prof1.getEmail());
				prof1 = null;
				System.out.println(testeDAO.getAll());
				System.out.println(testeDAO.get(chave)+" aqui");
				System.out.println("prof1 = "+prof1);
				prof1 = testeDAO.get(chave);
				
				System.out.println(prof1.getEmail());
				
				
				prof1.setSenha("4321");
				
				System.out.println("prof1 = "+prof1);
				
				System.out.println(prof1.getSenha());
				System.out.println(prof1);
				testeDAO.update(prof1);
				chave = prof1.getIdUsuario();
				
				prof1 = null;
				prof1 = testeDAO.get(chave);
				
				System.out.println(prof1.getSenha());

		}

	}
