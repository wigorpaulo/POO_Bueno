package view;

import java.util.Scanner;
import model.Usuario;

public class LoginView {

	public void loginView() {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("*** LOGIN ***");
		System.out.println("Informe o usu�rio:");
		String username = scan.next();
		System.out.println("Informe a senha:");
		String senha = scan.next();
		System.out.println("Logado com sucesso!");
		System.out.println("");

		MenuView menu = new MenuView();
		menu.menu();
		
		scan.close();
		
	}
}