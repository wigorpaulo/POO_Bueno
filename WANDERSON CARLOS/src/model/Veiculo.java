package model;

public class Veiculo {
	
	private int id, ano, tipoVeiculoID;
	private String placa, marca;
		
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setTipoVeiculoID(int tipoVeiculoID) {
		this.tipoVeiculoID = tipoVeiculoID;
	}
	
	public int getTipoVeiculoID() {
		return tipoVeiculoID;
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