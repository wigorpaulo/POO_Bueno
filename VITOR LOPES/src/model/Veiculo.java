package model;

public class Veiculo {
	
	int id, ano, tipoVeiculoId;
	String descricao, placa, marca;
	
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
