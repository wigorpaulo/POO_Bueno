package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;

public class UsuarioView extends ApplicationView implements IApplicationView {

	public void menuUsuario() {
		System.out.println("***MENU USUARIO***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");
		int ch = s.nextInt();

		switch (ch) {
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
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;
		}
	}

	public void menuCadastro() {
		Usuario usuario = new Usuario(); // instancia

		System.out.println("**Cadastro de Usuario***");
		System.out.println("-");
		System.out.println("Informe o Username");
		usuario.setLogin(s.next());
		System.out.println("Informe a Password");
		usuario.setSenha(s.next());
		System.out.println("-");

		System.out.println(userControl.cadastrar(usuario));

		menuUsuario();

	}

	public void menuListar() {
		ArrayList<Usuario> userList = userControl.listar();

		if (userList.isEmpty()) {
			System.out.println("Não possui usuario cadastrado");
		} else {
			System.out.println("**Lista de Usuario***");
			System.out.println("-");

			for (int cont = 0; cont < userList.size(); cont++) {
				System.out.println(userList.get(cont).toString());
			}

			System.out.println("-");
			System.out.println("**************");
		}
		menuUsuario();
	}

	public void menuAtualizar() {
		Usuario usuario = new Usuario();
		System.out.println("**Atualização de Usuario***");
		System.out.println("-");
		System.out.println("Informe o Username");
		usuario.setLogin(s.next());
		System.out.println("Informe a Password");
		usuario.setSenha(s.next());
		System.out.println("-");

		if (!userControl.atualizar(usuario)) {
			System.out.println("Usuario nao encontrado");
		} else {
			System.out.println("Usuario atualizado");
		}
		menuUsuario();
	}

	public void menuDeletar() {
		Usuario usuario = new Usuario();

		System.out.println("**Exclusão de Usuario***");
		System.out.println("-");
		System.out.println("Informe o Username");
		usuario.setLogin(s.next());
		System.out.println("-");

		if (!userControl.deletar(usuario)) {
			System.out.println("Usuario nao encontrado");
		} else {
			System.out.println("Usuario excluido");
		}
		menuUsuario();

	}
}
