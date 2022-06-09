package view;

import controller.PessoaController;

import model.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class PessoaView {
    public void menuPessoa() {
        Scanner ler = new Scanner(System.in);

        System.out.println("**** Menu Pessoa ****");
        System.out.println("-");
        System.out.println(" 1° Cadastrar ");
        System.out.println(" 2° Listar");
        System.out.println(" 3° Atualizar");
        System.out.println(" 4° Deletar");
        System.out.println(" 9° Voltar para o menu");
        System.out.println("-");
        System.out.println("***************");

        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                menuCadastrar();
                break;
            case 2:
                menuListar();
                break;
            case 3:

                break;
            case 4:
                break;
            case 9:
                MenuView menu = new MenuView();
                menu.menu();
                break;
            default:
                System.out.println("Opção invalida, escolha novamente!");
                menuPessoa();
                break;
        }
    }

    public void menuCadastrar() {
        Scanner ler = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.println("**** Cadastro Pessoa ****");
        System.out.println("-");
        System.out.println(" Informe o Nome: ");
        pessoa.setNome(ler.next());
        System.out.println("Informe o Email: ");
        pessoa.setEmail(ler.next());
        System.out.println("Informe o Telefone: ");
        pessoa.setTelefone(ler.next());
        System.out.println("-");
        System.out.println("* Cadastro Realizado! *");
        System.out.println("******************");

        PessoaController pessoaController = new PessoaController();
        System.out.println(pessoaController.cadastrar(pessoa));

        menuPessoa();
    }

    public void menuListar() {

        PessoaController pessoaController = new PessoaController();
        ArrayList<Pessoa> pessoalist = pessoaController.listar();

        if (pessoalist.isEmpty()) {
            System.out.println("Não possui pessoa cadastrado!");
        } else {

            System.out.println("**** LISTA DE Pessoas ****");
            System.out.println("-");

            for (int cont = 0; cont < pessoalist.size(); cont++) {
                System.out.println(pessoalist.get(cont).toString());
            }
            System.out.println("-");
            System.out.println("*************");
        }

        menuPessoa();

    }

    public void menuAtualizar() {
        Scanner ler = new Scanner(System.in);

        Pessoa pessoa= new Pessoa();

        System.out.println("**** ATUALIZAÇÃO DE PESSOA ****");
        System.out.println("-");
        System.out.println(" Informe o nome: ");
        pessoa.setNome(ler.next());
        System.out.println("Informe o telefone: ");
        pessoa.setTelefone(ler.next());
        System.out.println("Informe o email: ");
        pessoa.setEmail(ler.next());
        System.out.println("-");

        PessoaController pessoaController = new PessoaController();

        if (!pessoaController.atualizar(pessoa)) {
            System.out.println("Pessoa não encontrado!");
        } else {
            System.out.println("Cadastro de pessoa atualizado!");
        }

        menuPessoa();

    }

    public void menuDeletar() {
        Scanner ler = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.println("**** EXCLUIR Pessoa ****");
        System.out.println("-");
        System.out.println(" Informe o Nome: ");
        pessoa.setNome(ler.next());
        System.out.println("-");

        PessoaController pessoaController = new PessoaController();

        if (!pessoaController.deletar(pessoa)) {
            System.out.println("Pessoa não encontrado!");
        } else {
            System.out.println("Pessoa excluido!");

        }
        menuPessoa();

    }
}
