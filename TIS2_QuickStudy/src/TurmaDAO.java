
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO implements DAO<Turma, String> {

	private String arquivoNome = NomeDosArquivos.ARQUIVO_TURMAS;

	public TurmaDAO() {

	}

	@Override
	public Turma get(String chave) {

		Turma atual = null;
		Turma retorno = null;
		String chaveAtual = null;

		try(DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))){

			while((chaveAtual = entrada.readUTF()) != null) {
				atual = new Turma();
				atual.setNome(chaveAtual);
				atual.setDescricao(entrada.readUTF());
				atual.setDisponivel(entrada.readBoolean());
				
				if(chave == chaveAtual) {
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
			saida.writeUTF(item.getNome());
			saida.writeUTF(item.getDescricao());
			saida.writeBoolean(item.isDisponivel());
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
		String chaveAtual = null;
		Turma atual = new Turma();
		
		try(DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))){
			
			while((chaveAtual = entrada.readUTF()) != null) {
				
				atual.setNome(chaveAtual);
				atual.setDescricao(entrada.readUTF());
				atual.setDisponivel(entrada.readBoolean());
				
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
				saida.writeUTF(atual.getNome());
				saida.writeUTF(atual.getDescricao());
				saida.writeBoolean(atual.isDisponivel());
				saida.flush();

			}

		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
