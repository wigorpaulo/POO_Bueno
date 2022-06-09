package controller;

import java.util.ArrayList;
import model.Veiculo;
import service.VeiculoService;


public class VeiculoController extends ApplicacaoController{
		
		public String cadastrar(Veiculo veiculo) {
			 
			if (veiculoService.ler(veiculo)) {
				return "Usuario j� cadastrado";
						
			} else {
			
			if (veiculoService.escrever(veiculo)) {
				return "Usuario cadastrado com sucesso!";
			} else {
				return"Tente novamente!";
			}
			}
		}


		public ArrayList<Veiculo> listar() {
			return veiculoService.ler();
		}
		
		public Boolean atualizar(Veiculo veiculo) {
			return veiculoService.atualizar(veiculo); 
		}
		
		public Boolean deletar(Veiculo veiculo) {
			return veiculoService.excluir(veiculo);
			 
		}
	}

