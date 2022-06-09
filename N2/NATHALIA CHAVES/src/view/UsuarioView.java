package view;

import java.util.ArrayList;

import model.Usuario;

public class UsuarioView extends ApplicationView implements IApplicationView {

	public void menuUsuario() {

		System.out.println("***MENU USU�RIO***\n-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para MENU");

		int num = leia.nextInt();

		switch (num) {
		case 1:

			menuCadastrar();
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

			MenuView menu = new MenuView();
			menu.menu();
			break;

		default:
			System.out.println("Op��o Invalida, inicie novamente.");
			menuUsuario();
			break;
		}

	}

	public void menuCadastrar() {

		Usuario usuario = new Usuario();

		System.out.println("***CADASTRO DE USU�RIO*** \n-");
		System.out.println("Informe o Username:");
		usuario.setLogin(leia.next());
		System.out.println("Informe o PassWord:");
		usuario.setSenha(leia.next());

		System.out.println(userControl.cadastrar(usuario));

		// EXECUTAR NOVAMENTE

		menuUsuario();
	}

	public void menuListar() {

		ArrayList<Usuario> userList = userControl.listar();

		// if retorno vazio
		if (userList.isEmpty()) {
			System.out.println("N�o possui usu�rio cadastrado!");
		}
		// sen�o
		// chamar toString

		else {
			System.out.println("***LISTA DE USU�RIO*** \n-");
			System.out.println("-");
			for (int cont = 0; cont < userList.size(); cont++) {
				System.out.println(userList.get(cont).toString());
			}

			System.out.println("-\n ***************");

		}

		menuUsuario();
	}

	public void menuAtualizar() {

		Usuario usuario = new Usuario();

		System.out.println("***ATUALIZA��O DE USU�RIO*** \n-");
		System.out.println("Informe o Username:");
		usuario.setLogin(leia.next());
		System.out.println("Informe o PassWord:");
		usuario.setSenha(leia.next());
		System.out.println("-");

		if (!userControl.atualizar(usuario)) {
			System.out.println("Usu�rio n�o encontrado");
		} else {
			System.out.println("Cadastro atualizado");
		}

		menuUsuario();
	}

	public void menuDeletar() {

		Usuario usuario = new Usuario();

		System.out.println("***EXCLUS�O DE USU�RIO*** \n-");
		System.out.println("Informe o Username:");
		usuario.setLogin(leia.next());
		System.out.println("-");

		if (!userControl.deletar(usuario)) {
			System.out.println("Usu�rio n�o encontrado.");

		} else {
			System.out.println("Cadastro excluido.");
		}

		menuUsuario();
	}
}
