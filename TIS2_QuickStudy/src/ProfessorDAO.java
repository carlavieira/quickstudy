
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements DAO<Professor, Integer> {

	private String arquivoNome = NomeDosArquivos.ARQUIVO_PROFESSORES;
	private CursoDAO cursoDAO = new CursoDAO();

	public ProfessorDAO() {

	}

	@Override
	public Professor get(Integer chave) {

		Professor retorno = null;
		Professor atual = null;
		Integer chaveAtual = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {
				atual = new Professor();
				atual.setIdProfessor(chaveAtual);
				atual.setEmail(entrada.readUTF());
				atual.setSenha(entrada.readUTF());
				atual.setCpf(entrada.readUTF());
				atual.setNome(entrada.readUTF());
				atual.setFormacao(entrada.readUTF());
				atual.setNumDeCursos(entrada.readInt());
				ArrayList<Curso> cursos = new ArrayList<Curso>();

				for (int indice = 0; indice < atual.getNumDeCursos(); indice++) {
					int curso = entrada.readInt();
					cursos.add(cursoDAO.get(curso));
				}
				atual.setCursos(cursos);

				if (chaveAtual.equals(atual.getIdProfessor())) {
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
	public void add(Professor item) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))) {
			saida.writeInt(item.getIdProfessor());
			saida.writeUTF(item.getEmail());
			saida.writeUTF(item.getSenha());
			saida.writeUTF(item.getCpf());
			saida.writeUTF(item.getNome());
			saida.writeUTF(item.getFormacao());
			saida.writeInt(item.getCursos().size());
			for (Curso p : item.getCursos()) {
				saida.writeInt(p.getIdCurso());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Professor item) {

		List<Professor> lista = this.getAll();

		int index = lista.indexOf(item);

		if (index != -1)
			lista.set(index, item);

		this.saveToFile(lista);

	}

	@Override
	public void delete(Professor item) {

		List<Professor> lista = this.getAll();

		int index = lista.indexOf(item);

		if (index != -1)
			lista.remove(index);

		this.saveToFile(lista);

	}

	@Override
	public List<Professor> getAll() {

		List<Professor> retorno = new ArrayList<Professor>();
		Integer chaveAtual = null;
		Professor atual = new Professor();

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))) {

			while ((chaveAtual = entrada.readInt()) != null) {

				atual.setIdProfessor(chaveAtual);
				atual.setEmail(entrada.readUTF());
				atual.setSenha(entrada.readUTF());
				atual.setCpf(entrada.readUTF());
				atual.setNome(entrada.readUTF());
				atual.setFormacao(entrada.readUTF());
				atual.setNumDeCursos(entrada.readInt());
				ArrayList<Curso> cursos = new ArrayList<Curso>();

				for (int indice = 0; indice < atual.getNumDeCursos(); indice++) {
					int curso = entrada.readInt();
					cursos.add(cursoDAO.get(curso));
				}
				atual.setCursos(cursos);

				retorno.add(atual);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	private void saveToFile(List<Professor> professores) {

		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))) {

			for (Professor atual : professores) {

				saida.writeInt(atual.getIdProfessor());
				saida.writeUTF(atual.getEmail());
				saida.writeUTF(atual.getSenha());
				saida.writeUTF(atual.getCpf());
				saida.writeUTF(atual.getNome());
				saida.writeUTF(atual.getFormacao());
				saida.writeInt(atual.getCursos().size());
				for (Curso p : atual.getCursos()) {
					saida.writeInt(p.getIdCurso());
				}
				saida.flush();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
