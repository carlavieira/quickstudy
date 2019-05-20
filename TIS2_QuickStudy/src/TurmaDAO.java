import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class TurmaDAO implements DAO<Turma, Integer> {

	private String arquivoNome = NomeDosArquivos.ARQUIVO_TURMAS;

	public TurmaDAO() {

	}

	@Override
	public Turma get(Integer chave) {

		Turma atual = null;
		Turma retorno = null;
		Integer chaveAtual = null;

		try(DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))){

			while((chaveAtual = entrada.readInt()) != null) {
				atual = new Turma();
				atual.setIdTurma(chaveAtual);
				atual.setQtdAlunos(entrada.readInt());
				atual.setData_fim(entrada.readUTF());
				atual.setData_inicio(entrada.readUTF());
				atual.setDuracao(entrada.readInt());
				atual.setIdCurso(entrada.readInt());
				atual.setPreco(entrada.readDouble());
				atual.setQtdAlunos(entrada.read());
				
				if(chave.equals(atual.getIdTurma())) {
					retorno = atual;
					break;
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}

	@Override
	public void add(Turma item) {
		
		try(DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))){
			saida.writeInt(item.getIdTurma());
			saida.writeInt(item.getQtdAlunos());
			saida.writeUTF(item.getData_fim());
			saida.writeUTF(item.getData_inicio());
			saida.writeInt(item.getDuracao());
			saida.writeInt(item.getIdCurso());
			saida.writeDouble(item.getPreco());
			saida.writeInt(item.getQtdAlunos());
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void update(Turma item) {
		
		List<Turma> lista = this.getAll();
		
		int index = lista.indexOf(item);
		
		if(index != -1)
			lista.set(index, item);
		
		this.saveToFile(lista);
		
	}

	@Override
	public void delete(Turma item) {
		
		List<Turma> lista = this.getAll();
		
		int index = lista.indexOf(item);
		
		if(index != -1)
			lista.remove(index);
		
			this.saveToFile(lista);

	}

	@Override
	public List<Turma> getAll() {
		
		List<Turma> retorno = new ArrayList<Turma>();
		Integer chaveAtual = null;
		Turma atual = new Turma();
		
		try(DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))){
			
			while((chaveAtual = entrada.readInt()) != null) {
				atual.setIdTurma(chaveAtual);
				atual.setQtdAlunos(entrada.readInt());
				atual.setData_fim(entrada.readUTF());
				atual.setData_inicio(entrada.readUTF());
				atual.setDuracao(entrada.readInt());
				atual.setIdCurso(entrada.readInt());
				atual.setPreco(entrada.readDouble());
				atual.setQtdAlunos(entrada.read());
				retorno.add(atual);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	private void saveToFile(List <Turma> turmas) {

		try(DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))){

			for(Turma atual : turmas) {
				saida.writeInt(atual.getIdTurma());
				saida.writeInt(atual.getQtdAlunos());
				saida.writeUTF(atual.getData_fim());
				saida.writeUTF(atual.getData_inicio());
				saida.writeInt(atual.getDuracao());
				saida.writeInt(atual.getIdCurso());
				saida.writeDouble(atual.getPreco());
				saida.writeInt(atual.getQtdAlunos());
				saida.flush();

			}

		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
