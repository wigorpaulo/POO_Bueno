package model;

public class TipoEstacionamento {
	
	int id;
	String descricao;
	
	public void setAno (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public String getdescricao() {
		return descricao;
	}

}
