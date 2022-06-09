package model;

public class Veiculo {

    private int id;
    private String ano;
    private String placa;
    private String marca;

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAno() {
        return ano;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
        return "ID: " + Integer.toString(getId()) + "| Placa Veiculo: " + getPlaca() + " | Marca: " + getMarca() + " | Ano: "
                + getAno();
    }
}
