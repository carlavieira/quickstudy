public class Conta {
	
	public static final byte PERMISSAO_ALUNO = 1;
	public static final byte PERMISSAO_PROFESSOR = 2;
	
	private String user;
	private String senha;
	private int permissao;
	
	public Conta() {
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setPermissao(int permissao) {
		if(permissao > 0 && permissao < 3)
			this.permissao = permissao;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public int getPermissao() {
		return this.permissao;
	}

}
