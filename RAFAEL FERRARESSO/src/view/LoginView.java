package view;

import java.util.Scanner;

import model.Usuario;

public class LoginView {
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("**********LOGIN**********");
		System.out.println("-");
		System.out.println("Informe o usuário:");
		String username = scan.nextLine();
		System.out.println("Informe a Senha:");
		String password = scan.nextLine();
			
		System.out.println("***Logado com Sucesso!***");
		
		MenuView menu = new MenuView();
		menu.menu();
	}
	
}
