package Controller;

import java.util.ArrayList;

import model.Veiculo;

public class VeiculoController extends ApplicationController {
	
	public String cadastrar(Veiculo veiculo) {

		if (veicService.ler(veiculo)) {
			return ("Veículo já está cadastrado.");
		} else {
			// escreve no arquivo
			if (veicService.escrever(veiculo)) {
				return "Veículo cadastrado com sucesso!";
			} else {
				return "Teste novamente!";
			}
		}

	}

	public ArrayList<Veiculo> listar() {

		return veicService.ler();

	}

	public Boolean atualizar(Veiculo veiculo) {

		return veicService.atualizar(veiculo);
	}

	public boolean deletar(Veiculo veiculo) {
	
		return veicService.excluir(veiculo);
}
}