package view;

import java.util.Scanner;

import model.Pessoa;

public class PessoaView {
    public void pessoaView(Pessoa pessoa) {
        Scanner leia = new Scanner(System.in);

        System.out.println("***MENU USUARIO***");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("9 - Voltar para o menu");
        int option = leia.nextInt();
        System.out.println("");

        switch (option) {
            case 1:
                register();
                break;
            case 2:
                listar(pessoa);
                break;
            case 9:
                MenuView menuView = new MenuView();
                menuView.menuView();
                break;
        }
    }

    public void register() {
        Scanner leia = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.println("Nome:");
        pessoa.setNome(leia.next());
        System.out.println("Telefone:");
        pessoa.setTelefone(leia.next());
        System.out.println("Email:");
        pessoa.setEmail(leia.next());
        System.out.println("Cadastro realizado!");
        System.out.println("");

        pessoaView(pessoa);

    }

    public void listar(Pessoa pessoa) {
        System.out.println("***LISTA DE PESSOAS***");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Phone: " + pessoa.getTelefone());
        System.out.println("Email: " + pessoa.getEmail());
        System.out.println("");
        pessoaView(null);
    }
}
