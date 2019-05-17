
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements DAO<Curso, String> {

	private String arquivoNome = NomeDosArquivos.ARQUIVO_CURSOS;

	public CursoDAO() {

	}

	@Override
	public Curso get(String chave) {

		Curso atual = null;
		Curso retorno = null;
		String chaveAtual = null;

		try(DataInputStream entrada = new DataInputStream(new FileInputStream(arquivoNome))){

			while((chaveAtual = entrada.readUTF()) != null) {
				atual = new Curso();
				atual.setNome(chaveAtual);
				atual.setCategoria(entrada.readUTF());
				atual.setDescrição(entrada.readUTF());
				atual.setProfresponsavel(entrada.readUTF());
				
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
	public void add(Curso item) {
		
		try(DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, true))){
			saida.writeUTF(item.getNome());
			saida.writeUTF(item.getCategoria());
			saida.writeUTF(item.getDescrição());
			saida.writeUTF(item.getProfresponsavel().getLogin());
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void update(Curso item) {
		
		List<Curso> lista = this.getAll();
		
		int index = lista.indexOf(item);
		
		if(index != -1)
			lista.set(index, item);
		
		this.saveToFile(lista);
		
	}

	@Override
	public void delete(Curso item) {
		
		List<Curso> lista = this.getAll();
		
		int index = lista.indexOf(item);
		
		if(index != -1)
			lista.remove(index);
		
			this.saveToFile(lista);

	}

	@Override
	public List<Curso> getAll() {
		
		List<Curso> retorno = new ArrayList<Curso>();
		String chaveAtual = null;
		Curso atual = new Curso();
		
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

	private void saveToFile(List <Curso> cursos) {

		try(DataOutputStream saida = new DataOutputStream(new FileOutputStream(arquivoNome, false))){

			for(Curso atual : cursos) {
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
