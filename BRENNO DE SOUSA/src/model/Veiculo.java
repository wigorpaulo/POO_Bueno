package model;

public class Veiculo {

	private int id;
	private int ano;
	private String placa;
	private int tipoveiculo;
	private String marca;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getTipoveiculo() {
		return tipoveiculo;
	}

	public void setTipoveiculo(int tipoveiculo) {
		this.tipoveiculo = tipoveiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
