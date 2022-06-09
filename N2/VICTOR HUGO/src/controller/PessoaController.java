package controller;

import java.util.ArrayList;
import model.Pessoa;


public class PessoaController extends ApplicacaoController {
	
	public String cadastrar(Pessoa pessoa) {
		 
		if (pessoaService.ler(pessoa)) {
			return "Usuario j� cadastrado";
					
		} else {
		
		if (pessoaService.escrever(pessoa)) {
			return "Usuario cadastrado com sucesso!";
		} else {
			return"Tente novamente!";
		}
		}
	}


	public ArrayList<Pessoa> listar() {
		return pessoaService.ler();
	}
	
	public Boolean atualizar(Pessoa pessoa) {
		return pessoaService.atualizar(pessoa); 
	}
	
	public Boolean deletar(Pessoa pessoa) {
		return pessoaService.excluir(pessoa);
		 
	}
}

