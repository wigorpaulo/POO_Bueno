package model;

public class Pessoa {
	
		private String nome;
		private String telefone;
		private String email;
		private int id; 
		
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome(String nome) {
		return nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone(String telefone) {
		return telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail(String email) {
		return email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId(int id) {
		return id;
	}
}

