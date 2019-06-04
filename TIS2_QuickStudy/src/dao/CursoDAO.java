package dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import classes.Curso;

public class CursoDAO implements DAO<Curso, Integer> {

	private String arquivoNome = "cursos.dat";

	public CursoDAO() {

	}

	@Override
	public Curso get(Integer chave) {

		Curso retorno = null;
		Curso atual = null;
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				atual = new Curso();
				atual.setIdCurso(chaveAtual);
				atual.setNome(entrada.readUTF());
				atual.setCategoria(entrada.readUTF());
				atual.setDescricao(entrada.readUTF());

				if (chave.equals(atual.getIdCurso())) {
					retorno = atual;
					break;
				}

			}

		} catch (FileNotFoundException e) {
	    } catch (EOFException e) {
	    } catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	@Override
	public void add(Curso atual) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))) {
			saida.writeInt(atual.getIdCurso());
			saida.writeUTF(atual.getNome());
			saida.writeUTF(atual.getCategoria());
			saida.writeUTF(atual.getDescricao());

		} catch (FileNotFoundException e) {
	    } catch (EOFException e) {
	    } catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Curso atual) {

		List<Curso> cursos = this.getAll();

		int indexAtual = cursos.indexOf(atual);

		if (indexAtual != -1)
			cursos.set(indexAtual, atual);

		this.saveToFile(cursos);

	}

	@Override
	public void delete(Curso atual) {

		List<Curso> cursos = this.getAll();

		int indexAtual = cursos.indexOf(atual);

		if (indexAtual != -1)
			cursos.remove(indexAtual);
		this.saveToFile(cursos);

	}

	@Override
	public List<Curso> getAll() {

		List<Curso> retorno = new ArrayList<Curso>();
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				Curso atual = new Curso();

				atual.setIdCurso(chaveAtual);
				atual.setNome(entrada.readUTF());
				atual.setCategoria(entrada.readUTF());
				atual.setDescricao(entrada.readUTF());

				
				retorno.add(atual);

			}

		} catch (FileNotFoundException e) {
	    } catch (EOFException e) {
	    } catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	private void saveToFile(List<Curso> cursos) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))) {

			for (Curso atual : cursos) {
				saida.writeInt(atual.getIdCurso());
				saida.writeUTF(atual.getNome());
				saida.writeUTF(atual.getCategoria());
				saida.writeUTF(atual.getDescricao());
				saida.flush();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
