import java.util.ArrayList;

/**
 * A classe Curso contém os dados dos cursos que um professor do QuickStudy disponibilizou na plataforma
 * 
 * @author carlavieira
 * @version 1.0
 *
 */
public class Curso {
	private int idCurso;
	private int numDeTurmas;
	private String nome;
	private String categoria;
	private String descrição;
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	private int idProfessor;
	
	/**
	 * Construtor para curso com atributos
	 * @param nome
	 * @param categoria
	 * @param descrição
	 */
	public Curso(String nome, String categoria, String descrição) {
		this.setIdCurso(6);
		this.setNome(nome);
		this.setCategoria(categoria);
		this.setDescrição(descrição);
		this.turmas.clear();
		this.numDeTurmas = 0;
	}
	
	/**
	 * Gera ID para o curso com tamanho dado.
	 * @param len
	 * @return ID (em String)
	 */
	private String gerarIdCurso(int len) {
	    String[] caracteres ={"0","1","2","3","4","5","6","7","8","9"};
	    String id="";

	    for (int x=0; x<len; x++){
	        int j = (int) (Math.random()*caracteres.length);
	        id += caracteres[j];
	    }
	    return id;
	}
	
	public Curso() {
		this.turmas.clear();
		this.numDeTurmas = 0;
		
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

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}

	public int getIdCurso() {
		return idCurso;
	}
	/**
	 * Para criar um novo ID do Curso, é utilizado o método de gerador de ID com o tamanho indicado.
	 * @param digitosId
	 */
	public void setIdCurso(int digitosId) {
		this.idCurso = Integer.parseInt(gerarIdCurso(digitosId));
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public int getNumDeTurmas() {
		return numDeTurmas;
	}

	public void setNumDeTurmas(int numDeTurmas) {
		this.numDeTurmas = numDeTurmas;
	}
	
	
	
	
}
