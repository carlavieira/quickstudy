
/**
 * A Classe Professor contém os dados necessários para os professores que disponibilizam cursos no QuickStudy
 * 
 * @author carlavieira
 * @version 1.0
 *
 */
public class Professor {
	private int idProfessor;
	private Conta conta;
	private String cpf;
	private String nome;
	private String email;
	private String formacao;
	
	//Constr�i um professor com senha, cpf e e-mail aleat�rios.
	public Professor(){
		this.cpf = geradorCpf(11);
		this.setNome("Novo Professor");
		//Gera um e-mail baseado no CPF gerado.
		this.email = this.cpf+"@email.com";
		//Gera um login baseado no e-mail gerado
		this.login = this.email;
		//Gera uma senha de 6 caracteres alfa-num�ricos
		this.senha = geradorSenha(6);
		this.titulacao = "Bacharel";
	}
	
	//Constr�i um professor utilizando os par�metros informados
	public Professor(String cpf, String nome, String email, String senha, String titulacao) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setLogin(email);
		this.setSenha(senha);
		this.setTitulacao(titulacao);
	}
	
	//Recebe como argumento um tamanho e utiliza-o para gerar montar uma string(cpf) utilizando um conjunto de caracteres (num�ricos).
	//Retorna o cpf com o tamanho passado como argumento.
	private String geradorCpf(int len) {
	    String[] caracteres ={"0","1","2","3","4","5","6","7","8","9"};
	    String cpf="";

	    for (int x=0; x<len; x++){
	        int j = (int) (Math.random()*caracteres.length);
	        cpf += caracteres[j];
	    }
	    return cpf;
	}
	
	//Disponibiliza o curso e retorna o ID do Curso diposnibilizado
	public int disponibilizarCurso(String nome, String categoria, String cpf){
		Curso c = new Curso(nome,categoria,this.getCpf());
		int cursoId = c.getIdCurso();
		return cursoId;
	}
	
	//Cria uma Turma
	public void criarTurma(String inicio, String fim, int duracao, int cursoId) {
		@SuppressWarnings("unused")
		Turma t = new Turma(inicio,fim,duracao,cursoId);
	}
	
	//Adiciona um Aluno na Turma.
	//Passa como par�metro o cpf e o nome do aluno.
	public void adicionaAlunoTurma(String aluno_cpf,String aluno_nome) {
		//t.adicionaAluno(aluno_cpf,aluno_nome);
	}
	//Recebe como argumento um tamanho e utiliza-o para gerar montar uma string(senha) utilizando um conjunto de caracteres (alfa-num�ricos).
	//Retorna a senha com o tamanho passado como argumento.
	private String geradorSenha(int len) {
	    String[] caracteres ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	    String senha="";

	    for (int x=0; x<len; x++){
	        int j = (int) (Math.random()*caracteres.length);
	        senha += caracteres[j];
	    }
	    return senha;
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

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
}
