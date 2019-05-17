import java.util.HashMap;

public class Turma {
	private int idTurma;
	private String data_inicio;
	private String data_fim;
	private int duracao; //horas
	private double preco;
	private int qtdAlunos;
	private HashMap<String,String> listaAlunos = new HashMap<String,String>(); //Lista de Alunos c/ cpf e nome dos alunos;
	private int idCurso;//Curso ao qual a turma pertence
	
	//Cria uma Turma com nenhum aluno, in�cio, fim, dura��o, idCurso, pre�o e lista de alunos vazia.
	public Turma(String inicio,String fim,int duracao,int idCurso){
		this.listaAlunos.clear();
		this.setQtdAlunos(0);
		this.setData_inicio(inicio);
		this.setData_fim(fim);
		this.setDuracao(duracao);
		this.definePreco(duracao);
		this.setIdTurma(2);
		this.setIdCurso(idCurso);
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
	
	//Define o Pre�o da Turma baseado na dura��o.
	public void definePreco(int duracao){
		if (this.getDuracao() == 0)
			this.preco = 0;
		else if(this.getDuracao()<=20)
			this.preco = 150;
		else if(this.getDuracao()<=40)
			this.preco=300;
		else
			this.preco = 500;
	}
	
	/*Adiciona alunos � turma.
	 *Recebe o cpf e o nome do aluno e adiciona � lista de alunos.
	 *Atualiza a quantidade de alunos da turma
	 */
	public void adicionaAluno(String cpf, String nome) {
			listaAlunos.put(cpf, nome);
			this.setQtdAlunos(this.getQtdAlunos() + 1);	
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
}
