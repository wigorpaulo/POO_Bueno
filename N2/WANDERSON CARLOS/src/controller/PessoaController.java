package controller;

import model.Pessoa;

import java.util.ArrayList;

public class PessoaController extends ApplicationController{
    public String cadastrar(Pessoa pessoa) {

        if (pesService.ler(pessoa)) {
            return "Pessoa já está cadastrada";
        } else {
            if (pesService.escreve(pessoa)) {
                return "Pessoa cadastrada com sucesso";
            } else {
                return "Favor tente novamente";
            }
        }
    }

    public ArrayList<Pessoa> listar() {
        return pesService.ler();
    }

    public Boolean atualizar(Pessoa usuario) {
        return pesService.atualizar(usuario);
    }

    public Boolean deletar(Pessoa usuario) {
        return pesService.excluir(usuario);
    }
}