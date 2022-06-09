package Controller;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaController extends ApplicationController {

	public String cadastrar(Pessoa pessoa) {
		// INSTANCIAR UsuarioService

		if (pessService.ler(pessoa)) {
			return ("Pessoa já está cadastrado.");
		} else {
			// escreve no arquivo
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