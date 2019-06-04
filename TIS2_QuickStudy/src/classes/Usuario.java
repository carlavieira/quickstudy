package classes;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int idUsuario;
	private String usuario;
	private String senha;
	private String nome;
	private String email;
	private int cpf;
	private String formacao;
	private List<Curso> cursosProfessor;
	private List<Turma> turmasAluno;
	

	public Usuario(String usuario, String senha, String nome, String email, int cpf, String formacao) {
		this.geraIdUsuario(6);
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.formacao = formacao;
		this.cursosProfessor = new ArrayList<Curso>();
		this.turmasAluno = new ArrayList<Turma>();
	}

	public Usuario() {
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public List<Curso> getCursosProfessor() {
		return cursosProfessor;
	}

	public void setCursosProfessor(List<Curso> cursosProfessor) {
		this.cursosProfessor = cursosProfessor;
	}

	public List<Turma> getTurmasAluno() {
		return turmasAluno;
	}

	public void setTurmasAluno(List<Turma> turmasAluno) {
		this.turmasAluno = turmasAluno;
	}

	
	public void adicionaTurma(Turma novaTurma) {
		this.turmasAluno.add(novaTurma);
	}
	
	public void removeTurma(Turma turmaRemover) {
		this.turmasAluno.remove(turmaRemover);
	}
	
	public void adicionaCurso(Curso novoCurso) {
		this.cursosProfessor.add(novoCurso);
	}
	
	public void removeCurso(Curso cursoRemover) {
		this.cursosProfessor.add(cursoRemover);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Para criar um novo ID de Professor, é utilizado o método de gerador de ID com
	 * o tamanho indicado.
	 * 
	 * @param tamanho
	 */
	public void geraIdUsuario(int tamanho) {
		this.idUsuario = Integer.parseInt(gerarId(tamanho));
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "[ID: "+this.idUsuario+", usuario: "+this.usuario+", senha: "+this.senha+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
		return (this.idUsuario ==  usuario.idUsuario);
	}
	
}
