package view;

import model.Usuario;

import java.util.ArrayList;

public class UsuarioView extends ApplicationView implements IApplicationView {

    public void menuUsuario() {
        System.out.println("*** MENU USUARIO ***");
        System.out.println("-1 Cadastrar");
        System.out.println("-2 Listar");
        System.out.println("-3 Atualizar");
        System.out.println("-4 Deletar");
        System.out.println("-9 Voltar para o menu");
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
                menuUsuario();
                break;
        }
    }

    public void menuCadastro() {
        Usuario usuario = new Usuario(); // instancia

        System.out.println("*** Cadastro de Usuarios ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe o Username");
        usuario.setLogin(leia.next());
        System.out.println("Informe a Senha");
        usuario.setSenha(leia.next());
        System.out.println("-");
        System.out.println("-");
        System.out.println(usuaControl.cadastrar(usuario));
        menuUsuario();

    }

    public void menuListar() {
        ArrayList<Usuario> userList = usuaControl.listar();

        if (userList.isEmpty()) {
            System.out.println("Nao possui usuario cadastrado");
        } else {
            System.out.println("**Lista de Usuario***");
            System.out.println("-");

            for (int cont = 0; cont < userList.size(); cont++) {
                System.out.println(userList.get(cont).toString());
            }

            System.out.println("-");
            System.out.println("************");
        }
        menuUsuario();
    }

    public void menuAtualizar() {
        Usuario usuario = new Usuario();
        System.out.println("*** Atualizar Usuario ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe o Username");
        usuario.setLogin(leia.next());
        System.out.println("Informe a senha");
        usuario.setSenha(leia.next());
        System.out.println("-");

        if (!usuaControl.atualizar(usuario)) {
            System.out.println("Usuario nao encontrado na base");
        } else {
            System.out.println("Usuario atualizado!!!");
        }

        menuUsuario();
    }


    public void menuDeletar() {
        Usuario usuario = new Usuario();

        System.out.println("*** Exclusao de Usuario ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe o Username");
        usuario.setLogin(leia.next());
        System.out.println("-");

        if (!usuaControl.deletar(usuario)) {
            System.out.println("Usuario nao encontrado");
        } else {
            System.out.println("Usuario excluido");
        }
        menuUsuario();

    }
}
