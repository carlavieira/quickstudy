package dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import classes.Usuario;

public class UsuarioDAO implements DAO<Usuario, Integer> {

	private String arquivoNome = "usuarios.dat";

	public UsuarioDAO() {
		
	}

	@Override
	public Usuario get(Integer id) {

		Usuario retorno = null;
		Usuario atual = null;
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				atual = new Usuario();
				
				atual.setIdUsuario(chaveAtual);
				atual.setUsuario(entrada.readUTF());
				atual.setSenha(entrada.readUTF());
				atual.setNome(entrada.readUTF());
				atual.setEmail(entrada.readUTF());
				atual.setCpf(entrada.readInt());
				atual.setFormacao(entrada.readUTF());

				if (id.equals(atual.getIdUsuario())) {
					retorno = atual;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	@Override
	public void add(Usuario usuario) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))) {
			
			saida.writeInt((Integer)usuario.getIdUsuario());
			saida.writeUTF(usuario.getUsuario());
			saida.writeUTF(usuario.getSenha());
			saida.writeUTF(usuario.getNome());
			saida.writeUTF(usuario.getEmail());
			saida.writeInt((Integer)usuario.getCpf());
			saida.writeUTF(usuario.getFormacao());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Usuario item) {

		List<Usuario> lista = this.getAll();
		
		int index = lista.indexOf(item);
		if (index != -1) {
			lista.set(index, item);
		}
		this.saveToFile(lista);

	}

	@Override
	public void delete(Usuario item) {

		List<Usuario> lista = this.getAll();

		int index = lista.indexOf(item);

		if (index != -1)
			lista.remove(index);

		this.saveToFile(lista);

	}

	@Override
	public List<Usuario> getAll() {

		List<Usuario> retorno = new ArrayList<Usuario>();
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {
			while ((chaveAtual = entrada.readInt()) != null ) {
				Usuario atual = new Usuario();

				atual.setIdUsuario(chaveAtual);
				atual.setUsuario(entrada.readUTF());
				atual.setSenha(entrada.readUTF());
				atual.setNome(entrada.readUTF());
				atual.setEmail(entrada.readUTF());
				atual.setCpf(entrada.readInt());
				atual.setFormacao(entrada.readUTF());

				retorno.add(atual);

			}

		} catch (FileNotFoundException e) {
	    } catch (EOFException e) {
	    } catch (Exception e) {
	      e.printStackTrace();
		}

		return retorno;
	}

	private void saveToFile(List<Usuario> usuarios) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))) {

			for (Usuario usuario : usuarios) {
				saida.writeInt(usuario.getIdUsuario());
				saida.writeUTF(usuario.getUsuario());
				saida.writeUTF(usuario.getSenha());
				saida.writeUTF(usuario.getNome());
				saida.writeUTF(usuario.getEmail());
				saida.writeInt(usuario.getCpf());
				saida.writeUTF(usuario.getFormacao());

				saida.flush();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
