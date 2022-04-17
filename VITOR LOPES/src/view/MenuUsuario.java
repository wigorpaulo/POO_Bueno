package view;

import java.util.Scanner;

public class MenuUsuario {
	public void MenuView(){
		
	Scanner sc = new Scanner(System.in);
	
	int numero;
	
	System.out.println("***Menu***");
	System.out.println("-");
	System.out.println("- 1 - Cadastrar Usuário");
	System.out.println("- 2 - Cadastrar Tipo Veículo");
	System.out.println("- 3 - Cadastrar Pessoa");
	System.out.println("- 4 - Cadastrar Tipo Estacionamento");
	System.out.println("- 9 - Sair");
	numero = sc.nextInt();
	
	if (numero == 1) {
		UsuarioView UsuarioView = new UsuarioView();
		UsuarioView.UsuarioView();
	}
	
	sc.close();
	
	}
}
