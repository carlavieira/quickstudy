public class Curso {
	private int idCurso;
	private String nome;
	private String categoria;
	private String descrição;
	private Professor profresponsavel;
	
	public Curso(String nome, String categoria, String descrição, Professor profresponsavel) {
		this.setIdCurso(4);
		this.setNome(nome);
		this.setCategoria(categoria);
		this.setDescrição(descrição);
		this.setProfresponsavel(profresponsavel);
	}
	
	//Gera um ID para o curso.
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

	public Professor getProfresponsavel() {
		return profresponsavel;
	}

	public void setProfresponsavel(Professor profresponsavel) {
		this.profresponsavel = profresponsavel;
	}

	public int getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(int digitosId) {
		this.idCurso = Integer.parseInt(gerarIdCurso(digitosId));
	}
	
	
	
	
}
