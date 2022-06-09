package Controller;

import java.util.ArrayList;

import model.Veiculo;

public class VeiculoController extends ApplicationController {
	
	public String cadastrar(Veiculo veiculo) {

		if (veicService.ler(veiculo)) {
		
			return ("Ve�culo j� est� cadastrado!");

		} else {

			if (veicService.escrever(veiculo)) {
			
				return "Ve�culo cadastrado com sucesso!";
			
			} else {
			
				return "Tente novamente!";
			
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