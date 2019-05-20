import java.util.ArrayList;

/**
 *  A classe Turma contém os dados das turmas de cursos que um professor do QuickStudy disponibilizou na plataforma
 * 
 * @author carlavieira
 * @version 1.0
 *
 */
public class Turma {
	private int idTurma;
	private String data_inicio;
	private String data_fim;
	private int duracao;
	private double preco;
	private int qtdAlunos;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>(); //Lista de Alunos c/ cpf e nome dos alunos;
	private int idCurso;//Curso ao qual a turma pertence
	
	//Cria uma Turma com nenhum aluno, in�cio, fim, dura��o, idCurso, pre�o e lista de alunos vazia.
	public Turma(String inicio,String fim,int duracao,int idCurso, double preco){
		this.alunos.clear();
		this.setQtdAlunos(0);
		this.setData_inicio(inicio);
		this.setData_fim(fim);
		this.setDuracao(duracao);
		this.setPreco(preco);
		this.setIdTurma(6);
		this.setIdCurso(idCurso);
	}

	public Turma() {
		// TODO Auto-generated constructor stub
	}

	private String gerarIdTurma(int len) {
	    String[] caracteres ={"0","1","2","3","4","5","6","7","8","9"};
	    String id="";

	    for (int x=0; x<len; x++){
	        int j = (int) (Math.random()*caracteres.length);
	        id += caracteres[j];
	    }
	    return id;
	}
	
	public double getPreco() {
		return this.preco;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma= Integer.parseInt(gerarIdTurma(idTurma));
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
