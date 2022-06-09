package view;

import controller.UsuarioController;
import model.Usuario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UsuarioView implements IView{

    public void menuUsuario() {
        Scanner ler = new Scanner(System.in);

        System.out.println("**** Menu Usuario ****");
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
                menuUsuario();
                break;
            case 9:
                MenuView menu = new MenuView();
                menu.menu();
                break;
            default:
                System.out.println("Opção invalida, escolha novamente!");
                menuUsuario();
                break;
        }
    }

    public void menuCadastrar() {
        Scanner ler = new Scanner(System.in);

        Usuario user = new Usuario();

        System.out.println("**** Cadastro Usuario ****");
        System.out.println("-");
        System.out.println(" Informe o usarname: ");
        user.setUsername(ler.next());
        System.out.println("Informe o password: ");
        user.setPassword(ler.next());
        System.out.println("-");
        System.out.println("* Cadastro Realizado! *");
        System.out.println("******************");

        UsuarioController userControl = new UsuarioController();
        System.out.println(userControl.cadastrar(user));

        menuUsuario();
    }

    public void menuListar() {

        UsuarioController userControl = new UsuarioController();
        ArrayList<Usuario> userlist = userControl.listar();

        if (userlist.isEmpty()) {
            System.out.println("Não possui usuario cadastrado!");
        } else {

            System.out.println("**** LISTA DE USUARIO ****");
            System.out.println("-");
            for (int cont = 0; cont < userlist.size(); cont++) {
                System.out.println(userlist.get(cont).toString());
            }
            System.out.println("-");
            System.out.println("*************");
        }

        menuUsuario();

    }

    public void menuAtualizar() {
        Scanner ler = new Scanner(System.in);

        Usuario user = new Usuario();

        System.out.println("**** ATUALIZAÇÃO DE USUARIO ****");
        System.out.println("-");
        System.out.println(" Informe o usarname: ");
        user.setUsername(ler.next());
        System.out.println("Informe o password: ");
        user.setPassword(ler.next());
        System.out.println("-");

        UsuarioController userControl = new UsuarioController();

        if (!userControl.atualizar(user)) {
            System.out.println("Usuario não encontrado!");
        } else {
            System.out.println("Cadastro de usuario atualizado!");
        }

        menuUsuario();

    }

    public void menuDeletar() {
        Scanner ler = new Scanner(System.in);

        Usuario user = new Usuario();

        System.out.println("**** EXCLUIR USUARIO ****");
        System.out.println("-");
        System.out.println(" Informe o usarname: ");
        user.setUsername(ler.next());
        System.out.println("-");

        UsuarioController userControl = new UsuarioController();

        if (!userControl.deletar(user)) {
            System.out.println("Usuario não encontrado!");
        } else {
            System.out.println("Usuario excluido!");

        }
        menuUsuario();

    }
}
