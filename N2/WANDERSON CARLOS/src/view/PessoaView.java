package view;

import model.Pessoa;

import java.util.ArrayList;

public class PessoaView extends ApplicationView implements IApplicationView {

    public void menuPessoa() {

        System.out.println("*** MENU PESSOA ***");
        System.out.println("-1 Cadastrar");
        System.out.println("-2 Listar");
        System.out.println("-3 Atualizar");
        System.out.println("-4 Deletar");
        System.out.println("-9 Voltar para o menu inicial");

        int opcao = leia.nextInt();
        switch (opcao) {
            case 1:
                menuCadastro();
                break;
            case 2:
                menuListar();
                break;
            case 3:
                menuAtualizar();
                break;
            case 4:
                menuDeletar();
                break;
            case 9:
                MenuView menuView = new MenuView();
                menuView.menu();
                break;
            default:
                System.out.println("Opcao invalida");
                menuPessoa();
                break;
        }

    }

    public void menuCadastro() {
        Pessoa pessoa = new Pessoa();

        System.out.println("*** Cadastro de Pessoa ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe o Username");
        pessoa.setNome(leia.next());
        System.out.println("Informe o Telefone");
        pessoa.setTelefone(leia.next());
        System.out.println("Informe o E-mail");
        pessoa.setEmail(leia.next());
        System.out.println("-");
        System.out.println("-");
        System.out.println(pesControl.cadastrar(pessoa));
        menuPessoa();
    }

    public void menuListar() {
        ArrayList<Pessoa> pessoaListar = pesControl.listar();

        if (pessoaListar.isEmpty()) {
            System.out.println("Nao contem pessoas cadastradas");
        } else {
            System.out.println("*** Lista de Pessoas***");
            System.out.println("-");

            for (int cont = 0; cont < pessoaListar.size(); cont++) {
                System.out.println(pessoaListar.get(cont).toString());
            }

            System.out.println("-");
            System.out.println("*************");
        }
        menuPessoa();

    }
    public void menuAtualizar() {
        Pessoa pessoa = new Pessoa();
        System.out.println("*** Atualizacao de Pessoa ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe o Username");
        pessoa.setNome(leia.next());
        System.out.println("Informe o Telefone");
        pessoa.setTelefone(leia.next());
        System.out.println("Informe o E-mail");
        pessoa.setEmail(leia.next());
        System.out.println("-");
        System.out.println("-");

        if (!pesControl.atualizar(pessoa)) {
            System.out.println("Pessoa nao foi encontrada");
        } else {
            System.out.println("Pessoa atualizada com sucesso");
        }
        menuPessoa();
    }

    public void menuDeletar() {
        Pessoa pessoa = new Pessoa();

        System.out.println("*** Exclusao de Pessoa ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe o Username");
        pessoa.setNome(leia.next());
        System.out.println("-");
        System.out.println("-");

        if (!pesControl.deletar(pessoa)) {
            System.out.println("Pessoa nao encontrada!!!");
        } else {
            System.out.println("Pessoa excluida com sucesso");
        }
        menuPessoa();
    }
}
