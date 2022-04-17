package view;

import java.util.Scanner;
import model.User;

public class UserView {
	
	public void userView(User user) {
		Scanner scan = new Scanner(System.in);
	
		
		System.out.println("***MENU USUÁRIO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o menu");
		int option = scan.nextInt();
		System.out.println("");
		
		switch(option) {
		case 1:
			register();
			break;
			
		case 2:
			toDisplay(user);
			break;
			
		case 9:
			MenuView menuView = new MenuView();
			menuView.menuView();
			break;
			
		}
		
		scan.close();
	}
	
	public void register() {
		Scanner scan = new Scanner(System.in);
		User user = new User();
		
		System.out.println("Informe o username:");
		user.setUsername(scan.next());
		System.out.println("Informe a senha:");
		user.setPassword(scan.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		userView(user);
		
		scan.close();
	}
	
	public void toDisplay(User user) {

			System.out.println("***LISTA DE USUARIO***");
			System.out.println("Username: "+ user.getUsername());
			System.out.println("Password: "+ user.getPassword());
			System.out.println("");
			userView(null);			
	}


}
