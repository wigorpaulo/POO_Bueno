package model;

public class Usuario {

	private int id; // n�o foi requisitado mas est� presente
	private String login;
	private String senha;

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;

	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

}
