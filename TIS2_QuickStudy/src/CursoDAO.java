import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements DAO<Curso, Integer> {

	private String arquivoNome = NomeDosArquivos.ARQUIVO_CURSOS;
	private TurmaDAO turmaDAO = new TurmaDAO();

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

				int numeroDeTurmas = entrada.readInt();
				ArrayList<Turma> turmas = new ArrayList<Turma>();

				for (int indice = 0; indice < numeroDeTurmas; indice++) {
					int turma = entrada.readInt();
					turmas.add(turmaDAO.get(turma));
				}
				atual.setTurmas(turmas);
				
				atual.setNome(entrada.readUTF());
				atual.setCategoria(entrada.readUTF());
				atual.setDescrição(entrada.readUTF());
				atual.setIdProfessor(entrada.readInt());

				if (chaveAtual.equals(atual.getIdCurso())) {
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
	public void add(Curso atual) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))) {

			saida.writeInt(atual.getIdCurso());
			saida.writeInt(atual.getTurmas().size());
			for (Turma p : atual.getTurmas()) {
				saida.writeInt(p.getIdTurma());
			}
			saida.writeUTF(atual.getNome());
			saida.writeUTF(atual.getCategoria());
			saida.writeUTF(atual.getDescrição());
			saida.writeInt(atual.getIdProfessor());
			

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
		Curso atual = new Curso();

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				atual = new Curso();
				atual.setIdCurso(chaveAtual);

				int numeroDeTurmas = entrada.readInt();
				ArrayList<Turma> turmas = new ArrayList<Turma>();

				for (int indice = 0; indice < numeroDeTurmas; indice++) {
					int turma = entrada.readInt();
					turmas.add(turmaDAO.get(turma));
				}
				atual.setTurmas(turmas);
				
				atual.setNome(entrada.readUTF());
				atual.setCategoria(entrada.readUTF());
				atual.setDescrição(entrada.readUTF());
				atual.setIdProfessor(entrada.readInt());

				retorno.add(atual);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	private void saveToFile(List<Curso> cursos) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))) {

			for (Curso atual : cursos) {
				saida.writeInt(atual.getIdCurso());
				saida.writeInt(atual.getTurmas().size());
				for (Turma p : atual.getTurmas()) {
					saida.writeInt(p.getIdTurma());
				}
				saida.writeUTF(atual.getNome());
				saida.writeUTF(atual.getCategoria());
				saida.writeUTF(atual.getDescrição());
				saida.writeInt(atual.getIdProfessor());
				
				
				saida.flush();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
