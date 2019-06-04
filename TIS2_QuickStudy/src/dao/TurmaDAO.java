package dao;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import classes.Turma;

public class TurmaDAO implements DAO<Turma, Integer> {

	private String arquivoNome = "turmas.dat";

	public TurmaDAO() {

	}

	@Override
	public Turma get(Integer chave) {

		Turma atual = null;
		Turma retorno = null;
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				atual = new Turma();
				atual.setIdTurma(chaveAtual);
				atual.setData_inicio(entrada.readUTF());
				atual.setData_fim(entrada.readUTF());
				atual.setDuracao(entrada.readInt());
				atual.setPreco(entrada.readDouble());
				atual.setQtdMinAlunos(entrada.readInt());
				atual.setQtdMaxAlunos(entrada.readInt());

				if (chave.equals(atual.getIdTurma())) {
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
	public void add(Turma item) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))) {
			saida.writeInt(item.getIdTurma());
			saida.writeUTF(item.getData_inicio());
			saida.writeUTF(item.getData_fim());
			saida.writeInt(item.getDuracao());
			saida.writeDouble(item.getPreco());
			saida.writeInt(item.getQtdMinAlunos());
			saida.writeInt(item.getQtdMaxAlunos());


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Turma item) {

		List<Turma> lista = this.getAll();
		
		int index = lista.indexOf(item);
		System.out.println(index);
		if (index != -1)
			lista.set(index, item);

		this.saveToFile(lista);

	}

	@Override
	public void delete(Turma item) {

		List<Turma> lista = this.getAll();

		int index = lista.indexOf(item);

		if (index != -1)
			lista.remove(index);

		this.saveToFile(lista);

	}

	@Override
	public List<Turma> getAll() {

		List<Turma> retorno = new ArrayList<Turma>();
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				
				Turma atual = new Turma();
				
				atual.setIdTurma(chaveAtual);
				atual.setData_inicio(entrada.readUTF());
				atual.setData_fim(entrada.readUTF());
				atual.setDuracao(entrada.readInt());
				atual.setPreco(entrada.readDouble());
				atual.setQtdMinAlunos(entrada.readInt());
				atual.setQtdMaxAlunos(entrada.readInt());
				
				retorno.add(atual);
			}

		} catch (FileNotFoundException e) {
	    } catch (EOFException e) {
	    } catch (Exception e) { 
			e.printStackTrace();
		}

		return retorno;
	}

	private void saveToFile(List<Turma> turmas) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))) {

			for (Turma item : turmas) {
				saida.writeInt(item.getIdTurma());
				saida.writeUTF(item.getData_inicio());
				saida.writeUTF(item.getData_fim());
				saida.writeInt(item.getDuracao());
				saida.writeDouble(item.getPreco());
				saida.writeInt(item.getQtdMinAlunos());
				saida.writeInt(item.getQtdMaxAlunos());

				saida.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
