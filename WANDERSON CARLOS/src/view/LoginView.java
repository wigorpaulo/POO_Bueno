package view;

import java.util.Scanner;

public class LoginView {

	public void login() {
		Scanner leia = new Scanner (System.in);

		System.out.println("***LOGIN***");
		System.out.println("Informe o usuario:");
		String usuario = leia.next();
		System.out.println("Informe a senha:");
		String senha = leia.next();
		System.out.println("Logado com sucesso!");
		System.out.println("");
		
		MenuView menuView = new MenuView();
		menuView.menuView();
	}
}