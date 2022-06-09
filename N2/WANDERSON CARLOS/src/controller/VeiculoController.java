package controller;

import model.Veiculo;

import java.util.ArrayList;

public class VeiculoController extends ApplicationController {

    public String cadastrar(Veiculo veiculo) {

        if (veiService.ler(veiculo)) {
            return "Veiculo já cadastrado";
        } else {
            if (veiService.escrever(veiculo)) {
                return "Veiculo cadastrado com sucesso";
            } else {
                return "Favor tente novamente";
            }
        }
    }

    public ArrayList<Veiculo> listar() {
        return veiService.ler();

    }

    public Boolean atualizar(Veiculo veiculo) {
        return veiService.atualizar(veiculo);
    }

    public Boolean deletar(Veiculo veiculo) {
        return veiService.excluir(veiculo);
    }

}
