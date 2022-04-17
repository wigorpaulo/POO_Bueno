package view;

import java.util.Scanner;
import model.User;

public class LoginView {

	public void login() {
		Scanner scan = new Scanner (System.in);

		System.out.println("***LOGIN***");
		System.out.println("Informe o usuáio:");
		String username = scan.next();
		System.out.println("Informe a senha:");
		String password = scan.next();
		System.out.println("Logado com sucesso!");
		System.out.println("");
		
		MenuView menuView = new MenuView();
		menuView.menuView();
		
		scan.close();
	}
}