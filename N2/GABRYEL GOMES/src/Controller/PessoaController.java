package Controller;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaController extends ApplicationController {

	public String cadastrar(Pessoa pessoa) {

		if (pessService.ler(pessoa)) {

			return ("Pessoa j� est� cadastrada!");
			
		} else {

			if (pessService.escrever(pessoa)) {
				
				return "Pessoa cadastrada com sucesso!";
				
			} else {
				
				return "Teste novamente!";
			
			}
		}

	}

	public ArrayList<Pessoa> listar() {

		return pessService.ler();

	}

	public Boolean atualizar(Pessoa pessoa) {

		return pessService.atualizar(pessoa);
		
	}

	public Boolean deletar(Pessoa pessoa) {

		return pessService.excluir(pessoa);
		
	}

}