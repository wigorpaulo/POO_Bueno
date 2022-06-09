package controller;

import java.util.ArrayList;

import model.Veiculo;

public class VeiculoController extends ApplicationController {

	public String cadastrar(Veiculo veiculo) {

		if (veService.ler(veiculo)) {
			return "Veiculo já cadastrado";
		} else {
			if (veService.escrever(veiculo)) {
				return "Veiculo cadastrado com sucesso";
			} else {
				return "Tente novamente";
			}
		}
	}

	public ArrayList<Veiculo> listar() {
		return veService.ler();

	}

	public Boolean atualizar(Veiculo veiculo) {
		return veService.atualizar(veiculo);
	}

	public Boolean deletar(Veiculo veiculo) {
		return veService.excluir(veiculo);
	}

}

