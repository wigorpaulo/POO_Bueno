package view;

import java.util.Scanner;

public class LoginView {
		
	public void login() {

		Scanner sc = new Scanner(System.in);

		System.out.println("*** LOGIN ***");

		System.out.println("-");
		System.out.println("-");

		System.out.println(" Informe o USUARIO: ");
		String username = sc.next();

		System.out.println(" Informe a SENHA: ");
		String password = sc.next();

		System.out.println("-");

		System.out.println("- LOGADO COM SUCESSO!");
		System.out.println("***      ***");
		
		MenuView mv = new MenuView();
		mv.menu();
	}
}
