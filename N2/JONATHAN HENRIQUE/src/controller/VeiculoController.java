package controller;


import model.Veiculo;
import service.VeiculoService;

import java.util.ArrayList;

public class VeiculoController {
    public String cadastrar(Veiculo veiculo) {

        VeiculoService veiculoService = new VeiculoService();
        if (veiculoService.ler(veiculo)){
            return "Veiculo já cadastrado!";
        } else {
            if (veiculoService.escrever(veiculo)) {
                return "Veiculo cadastrado com sucesso!";
            } else {
                return "tente novamente";
            }
        }
    }

    public ArrayList<Veiculo> Veiculo () {

        VeiculoService veiculoService = new VeiculoService();
        return veiculoService.ler();


    }
    public boolean atualizar(Veiculo user) {

        VeiculoController veiculoService = new VeiculoController();
        return veiculoService.atualizar(user);

    }
    public boolean deletar(Veiculo user) {

        VeiculoService veiculoService = new VeiculoService();
        return veiculoService.excluir(user);

    }

    public ArrayList<Veiculo> listar() {
        return null;
    }
}
