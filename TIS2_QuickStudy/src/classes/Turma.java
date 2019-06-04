package classes;

import java.util.ArrayList;
import java.util.List;



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
	private int qtdMinAlunos;
	private int qtdMaxAlunos;
	private List<Usuario> alunos;
	
	
	public Turma(String inicio,String fim,int duracao, double preco, int qtdMinAlunos, int qtdMaxAlunos){
		this.geraIdTurma(6);
		this.data_inicio = inicio;
		this.data_fim = fim;
		this.duracao = duracao;
		this.preco = preco;
		this.qtdMinAlunos = qtdMinAlunos;
		this.qtdMaxAlunos = qtdMaxAlunos;
		this.alunos = new ArrayList<Usuario>();
	}

	public Turma() {
	}
	
	/**
	 * Gera uma ID com o tamanho desejado.
	 * 
	 * @param len (número de dígitos desejados)
	 * @return id
	 */
	private String gerarId(int len) {
		String[] caracteres = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String id = "";

		for (int x = 0; x < len; x++) {
			int j = (int) (Math.random() * caracteres.length);
			id += caracteres[j];
		}
		return id;
	}

	public int getIdTurma() {
		return idTurma;
	}

	/**
	 * Para criar um novo ID de Professor, é utilizado o método de gerador de ID com
	 * o tamanho indicado.
	 * 
	 * @param tamanho
	 */
	public void geraIdTurma(int tamanho) {
		this.idTurma = Integer.parseInt(gerarId(tamanho));
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtdMinAlunos() {
		return qtdMinAlunos;
	}

	public void setQtdMinAlunos(int qtdMinAlunos) {
		this.qtdMinAlunos = qtdMinAlunos;
	}

	public int getQtdMaxAlunos() {
		return qtdMaxAlunos;
	}

	public void setQtdMaxAlunos(int qtdMaxAlunos) {
		this.qtdMaxAlunos = qtdMaxAlunos;
	}

	public List<Usuario> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Usuario> alunos) {
		this.alunos = alunos;
	}
	
	public void matriculaAluno(Usuario novoAluno) {
		this.alunos.add(novoAluno);
	}
	
	public void retiraMatricula(Usuario alunoRemover) {
		this.alunos.add(alunoRemover);
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	@Override
	public String toString() {
		return "[ ID: "+this.idTurma+", duração: "+this.duracao+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Turma turma = (Turma)obj;
		return (this.getIdTurma() == turma.getIdTurma());
	}
	
}