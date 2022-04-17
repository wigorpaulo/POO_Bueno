package model;

public class Pessoa {
	
	private int id;
	private int telefone;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getTelefone() {
		return telefone;
	}

}
