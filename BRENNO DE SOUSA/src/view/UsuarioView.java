package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {

	public void menuUsuario(Usuario user) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("*** Menu Usuario ***");
		System.out.println("-");
		System.out.println("- 1 - Cadastrar ");
		System.out.println("- 2 - Listar ");
		System.out.println("- 3 - Atualizar");
		System.out.println("- 4 - Deletar ");
		System.out.println("- 9 - Volta para o menu ");
		System.out.println("-");
		System.out.println("*********");

		int opcao = entrada.nextInt();

		switch (opcao) {
		case 9:
			MenuView mv = new MenuView();
			mv.menu();
			break;
		case 1:
			menuCadastrar();
			break;
		case 2:
			menuListar(user);
			break;
		}
	}

	public void menuCadastrar() {
		Usuario user = new Usuario();
		Scanner entrada = new Scanner(System.in);

		
		System.out.println("*** Menu Usuario ***");
		System.out.println("-");

		System.out.println("- Informe o usuario: ");
		user.setLogin(entrada.next());

		System.out.println("- Informe a senha: ");
		user.setSenha(entrada.next());
		
		System.out.println("-");
		System.out.println("- Cadastro realizado!!!");
		
		menuUsuario(user);
	}
	
	public void menuListar(Usuario user) {
		System.out.println("*** Lista de Usuario ***");
		System.out.println("-");

		System.out.println("- Usuario: " + user.getLogin());
		System.out.println("- Senha: " + user.getSenha());
		System.out.println("*********");
		menuUsuario(null);
	}

}
