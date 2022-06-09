package view;

import java.util.Scanner;

public class LoginView {
	
	String username,password;
	
	public void logar() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("*** Login ***");
	System.out.println("-");
	System.out.println("-");
	System.out.println("Digite o usuário");
	username = sc.next();
	System.out.println("-");
	System.out.println("-");
	System.out.println("Digite a senha");
	password = sc.next();
	System.out.println("-");
	System.out.println("-");
	System.out.println("Logado!" );
	System.out.println("***      ***");
	
	MenuView menu = new MenuView();
	
	menu.menu();
	
	}
}