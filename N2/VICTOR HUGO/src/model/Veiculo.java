package model;

public class Veiculo {
	
	private int id;
	private String descricao;
	private String placa;
	private String marca;
	private String ano;
	private String tipoveiculo;
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
	
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAno() {
		return ano;
	}
	
	
	public void setTipoveiculo(String tipoveiculo) {
		this.tipoveiculo = tipoveiculo;
	}
	public String getTipoveiculo() {
		return tipoveiculo;
	}
	
	@Override
	public String toString() {

	return "ID: "+ Integer.toString(getId()) +"| Ano:" + getAno() + "| Descrição:"+getDescricao() + "| Marca:" + getMarca() + "| Placa:"+ getPlaca() +"| Tipo de veiculo:"+ getTipoveiculo();
	
	}

}
