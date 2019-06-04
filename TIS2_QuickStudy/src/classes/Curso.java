package classes;

import java.util.ArrayList;
import java.util.List;


/**
 * A classe Curso contém os dados dos cursos que um professor do QuickStudy
 * disponibilizou na plataforma
 * 
 * @author carlavieira
 * @version 1.0
 *
 */
public class Curso {
	
	private int idCurso;
	private String nome;
	private String categoria;
	private String descricao;
	private List<Turma> turmasDoCurso;

	/**
	 * Construtor para curso com atributos
	 * 
	 * @param nome
	 * @param categoria
	 * @param descrição
	 */
	public Curso(String nome, String categoria, String descricao) {
		this.gerarIdCurso(6);
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.turmasDoCurso = new ArrayList<Turma>();
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

	public Curso() {
	}

	public int getIdCurso() {
		return idCurso;
	}

	/**
	 * Para criar um novo ID de Professor, é utilizado o método de gerador de ID com
	 * o tamanho indicado.
	 * 
	 * @param tamanho
	 */
	public void gerarIdCurso(int tamanho) {
		this.idCurso = Integer.parseInt(gerarId(tamanho));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Turma> getTurmas() {
		return turmasDoCurso;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmasDoCurso = turmas;
	}
	
	public void adicionaTurmaAoCurso(Turma novaTurma) {
		this.turmasDoCurso.add(novaTurma);
	}
	
	public void removeTurma(Turma turmaRemover) {
		this.turmasDoCurso.remove(turmaRemover);
	}
	
	
	
	public List<Turma> getTurmasDoCurso() {
		return turmasDoCurso;
	}

	public void setTurmasDoCurso(List<Turma> turmasDoCurso) {
		this.turmasDoCurso = turmasDoCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "[ ID: "+this.idCurso+", Curso: "+this.nome+", Categoria: "+this.categoria+", Descrição: "+this.descricao+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Curso curso = (Curso) obj;
		return (this.idCurso == curso.idCurso);
	}
}
