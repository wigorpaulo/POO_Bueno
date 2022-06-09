package view;

import java.util.Scanner;
import model.Usuario;

public class LoginView {

	public void login() {
		Scanner leia = new Scanner(System.in);

		System.out.println("***LOGIN***\n-\n-");
		System.out.println("Informe o usuário:");
		String username = leia.next();
		System.out.println("Informe a senha:");
		String senha = leia.next();
		System.out.println("-\n-Logado com sucesso!");
		System.out.println("***    ***");

		MenuView menu = new MenuView();
		menu.menu();
	}
}