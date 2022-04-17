package model;

public class Veiculo {
	
	private int id, ano, tipoVeiculoId;
	private String placa, marca;
		
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setTipoVeiculoId(int tipoVeiculoId) {
		this.tipoVeiculoId = tipoVeiculoId;
	}
	
	public int getTipoVeiculoId() {
		return tipoVeiculoId;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}
	
}