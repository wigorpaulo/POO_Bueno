package model;

public class Veiculo {

    private int id;
    private String descricao;
    private int ano;
    private String placa;
    private String marca;
    private int tipoVeiculos;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getTipoVeiculos() {
        return tipoVeiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoVeiculos(int tipoVeiculos) {
        this.tipoVeiculos = tipoVeiculos;
    }
}
