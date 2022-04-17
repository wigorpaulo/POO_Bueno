package model;

public class Veiculo {
	
	private int id;
	private String descricao;
	private String placa;
	private String marca;
	private int ano;
	private int tipoveiculo;
	//Fim da declaração de variavel
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
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
	
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAno() {
		return ano;
	}
	
	
	public void setTipoveiculo(int tipoveiculo) {
		this.tipoveiculo = tipoveiculo;
	}
	public int getTipoveiculo() {
		return tipoveiculo;
	}

}
