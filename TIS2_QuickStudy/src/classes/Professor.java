package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Professor contém os dados necessários para os professores que
 * disponibilizam cursos no QuickStudy
 * 
 * @author carlavieira
 * @version 1.0
 *
 */
public class Professor {
	private int idProfessor;
	private String email;
	private String senha;
	private String cpf;
	private String nome;
	private String formacao;
	private int numDeCursos;
	private List<Curso> cursos = new ArrayList<Curso>();

	/**
	 * Construtor padrão da classe Professor
	 *
	 */
	public Professor() {
	}

	/**
	 * Construtor da classe Professos com atributos dados (sem cursos). Gera ID com
	 * 6 dígitos.
	 * 
	 * @param senha
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param formacao
	 */
	public Professor(String email, String senha, String cpf, String nome, String formacao) {
		this.setIdProfessor(6);
		this.setSenha(senha);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setFormacao(formacao);
		this.numDeCursos = 0;
		this.cursos.clear();
	}

	/**
	 * Gera uma ID para o professor com o tamanho desejado.
	 * 
	 * @param len (número de dígitos desejados)
	 * @return id
	 */
	private String gerarIdProfessor(int len) {
		String[] caracteres = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String id = "";

		for (int x = 0; x < len; x++) {
			int j = (int) (Math.random() * caracteres.length);
			id += caracteres[j];
		}
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	/**
	 * Para criar um novo ID de Professor, é utilizado o método de gerador de ID com
	 * o tamanho indicado.
	 * 
	 * @param tamanho
	 */
	public void setIdProfessor(int tamanho) {
		this.idProfessor = Integer.parseInt(gerarIdProfessor(tamanho));
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNumDeCursos() {
		return numDeCursos;
	}

	public void setNumDeCursos(int numDeCursos) {
		this.numDeCursos = numDeCursos;
	}

}
