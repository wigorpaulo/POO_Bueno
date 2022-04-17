package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {
	
	public void usuario(Usuario user){
		Scanner ler = new Scanner (System.in);
		
		System.out.println("***MENU USUARIO***");
		System.out.println("-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para o Menu");
		System.out.println("-");
		System.out.println("-");
		System.out.println("Aguardando a opção desejada");
		int opcao = ler.nextInt();
		System.out.println("********************");
		
		if (opcao == 9) {
			MenuView menu = new MenuView();
			menu.menu();
			
	} else if (opcao==1) {
		cadastrar();

	} else if (opcao == 2) {
		 listar(user);
	} 
		
	}

public void cadastrar() {
	Scanner ler = new Scanner (System.in);
	
	Usuario user = new Usuario();
	
	System.out.println("****Cadastro Usuario****");
	System.out.println("-");
	System.out.println("Informe seu Username:");
	user.setUsername(ler.next());
	System.out.println("Informe sua Senha:");
	user.setPassword(ler.next());
	System.out.println("-");
	System.out.println("Cadastro Realizado!!!");
	System.out.println("********************");
	
	usuario(user);
}

public void listar(Usuario user) {

    System.out.println("***Lista de Usuario***");
    System.out.println("-");
    System.out.println("Username:"+user.getUsername());
    System.out.println("Password:"+user.getPassword());
    System.out.println("-");
    System.out.println("*****************************");

usuario(null);
}

}
