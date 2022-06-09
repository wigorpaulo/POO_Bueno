package controller;

import model.Pessoa;

import service.PessoaService;

import java.util.ArrayList;

public class PessoaController {
    public String cadastrar(Pessoa pessoa) {

        PessoaService pessoaService = new PessoaService();
        if (pessoaService.ler(pessoa)){
            return "Pessoa já cadastrado!";
        } else {
            if (pessoaService.escrever(pessoa)) {
                return "Pessoa cadastrado com sucesso!";
            } else {
                return "tente novamente";
            }
        }
    }

    public ArrayList<Pessoa> listar() {

        PessoaService pessoaService = new PessoaService();
        return pessoaService.ler();


    }
    public boolean atualizar(Pessoa pessoa) {

        PessoaController pessoaService = new PessoaController();
        return pessoaService.atualizar(pessoa);

    }
    public boolean deletar(Pessoa pessoa) {

        PessoaService pessoaService = new PessoaService();
        return pessoaService.excluir(pessoa);

    }
}


