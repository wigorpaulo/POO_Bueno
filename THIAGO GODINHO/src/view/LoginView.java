package view;

import java.util.Scanner;

public class LoginView {

	public void login() {

		Scanner scan = new Scanner(System.in);

		System.out.println("***  LOGIN  ***");
		System.out.println("-");
		System.out.println("-");

		System.out.println("Informe o usuario");
		String usuario = scan.next();

		System.out.println("Informe a senha");
		String senha = scan.next();

		System.out.println("-");

		System.out.println("-Logado com sucesso!");
		System.out.println("***             ***");

		MenuView menuGeral = new MenuView();

		menuGeral.menu();

	}

}
