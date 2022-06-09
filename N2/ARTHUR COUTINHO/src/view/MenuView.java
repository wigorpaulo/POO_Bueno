package view;

import java.util.Scanner;

public class MenuView {
	
	public void menu() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("***Menu***");
	System.out.println("-");
	System.out.println("- 1 - Cadastrar Usuário");
	System.out.println("- 2 - Cadastrar Tipo Veículo");
	System.out.println("- 3 - Cadastrar Pessoa");
	System.out.println("- 4 - Cadastrar Tipo Estacionamento");
	System.out.println("- 9 - Sair");
	System.out.println("-");
	System.out.println("*********");
	int numero = sc.nextInt();
	
	if (numero == 1) {
		UsuarioView userView = new UsuarioView();
		userView.menuUsuario();
	}
	if (numero == 2) {
		
		
	}
	if (numero == 3) {
	
	}
	if (numero == 4) {
	
	}
	if (numero == 9) {
		System.out.println("Sistema encerrado!");
		System.exit(0);
	}
	else {
		System.out.println("Opção invalida, escolha novamente!");
		menu();
	}
	
	} 

}
