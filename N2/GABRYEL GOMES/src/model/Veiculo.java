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
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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
	
	@Override
	public String toString() {

		return "ID: " + Integer.toString(getId()) + " | Ano: " + getAno() + " | Tipo: " + (getTipoVeiculoId() + " | Placa: " + getPlaca() +" | Marca: " + getMarca());
                                                                                                                        
	}

}