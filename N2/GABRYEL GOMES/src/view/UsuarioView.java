package view;

import java.util.ArrayList;

import model.Usuario;

public class UsuarioView extends ApplicationView implements IApplicationView {

	public void menuUsuario() {

		System.out.println("*** MENU PESSOA ***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para MENU");
		int opcao = scan.nextInt();
		System.out.println("");

		switch (opcao) {
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
			System.out.println("Op��o inválida. Tente novamente!");
			menuUsuario();
			break;
			
		}

	}

	public void menuCadastrar() {

		Usuario usuario = new Usuario();

		System.out.println("*** CADASTRO DE USU�RIO ***");
		System.out.println("Informe o Username:");
		usuario.setLogin(scan.next());
		System.out.println("Informe o PassWord:");
		usuario.setSenha(scan.next());

		System.out.println(userControl.cadastrar(usuario));
		
		System.out.println("");
		menuUsuario();
	}

	public void menuListar() {

		ArrayList<Usuario> userList = userControl.listar();

		if (userList.isEmpty()) {

			System.out.println("N�o possui usu�rio cadastrado!");
		
		}
		
		else {
			
			System.out.println("*** LISTA DE USU�RIO ***");
			for (int cont = 0; cont < userList.size(); cont++) {
				
				System.out.println(userList.get(cont).toString());
			
			}

		}

		System.out.println("");
		menuUsuario();
	}

	public void menuAtualizar() {

		Usuario usuario = new Usuario();

		System.out.println("*** ATUALIZA��O DE USU�RIO ***");
		System.out.println("Informe o username:");
		usuario.setLogin(scan.next());
		System.out.println("Informe o password:");
		usuario.setSenha(scan.next());

		if (!userControl.atualizar(usuario)) {
			
			System.out.println("Usu�rio n�o encontrado!");
		
		} else {
		
			System.out.println("Cadastro atualizado!");
		
		}
		
		System.out.println("");
		menuUsuario();
		
	}

	public void menuDeletar() {

		Usuario usuario = new Usuario();

		System.out.println("*** EXCLUS�O DE USU�RIO ***");
		System.out.println("Informe o username:");
		usuario.setLogin(scan.next());

		if (!userControl.deletar(usuario)) {
		
			System.out.println("Usu�rio n�o encontrado!");

		} else {
			
			System.out.println("Cadastro excluido!");
		
		}

		System.out.println("");
		menuUsuario();
	}
}
