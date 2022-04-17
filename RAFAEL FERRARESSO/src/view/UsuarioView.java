package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {
	
	public void cadastro() {		
		Scanner scan = new Scanner(System.in);
		Usuario user = new Usuario();
		
		System.out.println("********CADASTRO*********");
		System.out.println("-");
		System.out.println("-Informe o usu�rio:");
		user.setUsername(scan.nextLine()); 		
		System.out.println("Informe a Senha:");
		user.setPassword(scan.nextLine());
		
		System.out.println("*Cadastrado com Sucesso!");
		menu(user);
	}
	
	public void lista(Usuario user) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*****Lista Usu�rio*******");
		System.out.println("-");
		System.out.println("-Username:"+ user.getUsername());
		
		menu(null);
	}
	
	public void menu(Usuario user) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("******Menu Usu�rio*******");
		System.out.println("-");
		System.out.println("-1 - Cadastrar");
		System.out.println("-2 - Listar");
		System.out.println("-3 - Atualizar");
		System.out.println("-4 - Deletar");
		System.out.println("-");
		System.out.println("-9 - VOLTAR PARA O MENU");
		
		switch(scan.nextInt()) {
		case 1:
			cadastro();
			break;
		
		case 2:
			lista(user);
			break;
			
		case 9:
			MenuView menu = new MenuView();
			menu.menu();
			break;
			
		default:
			System.out.println("Op��o inv�lida");
			menu(null);
		}
	}

}
