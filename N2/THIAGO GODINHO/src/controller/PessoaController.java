package controller;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaController extends ApplicationController{
	public String cadastrar(Pessoa pessoa) {

		if (peService.ler(pessoa)) {
			return "Usuario já cadastrado";
		} else {
			if (peService.escrever(pessoa)) {
				return "Usuario cadastrado com sucesso";
			} else {
				return "Tente novamente";
			}
		}
	}

	public ArrayList<Pessoa> listar() {
		return peService.ler();

	}

	public Boolean atualizar(Pessoa usuario) {
		return peService.atualizar(usuario);
	}

	public Boolean deletar(Pessoa usuario) {
		return peService.excluir(usuario);
	}

}

