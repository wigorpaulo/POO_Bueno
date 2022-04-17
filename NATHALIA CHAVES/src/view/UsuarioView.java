package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {

	public void menuUsuario (Usuario usuario) {
		Scanner leia = new Scanner (System.in);
		
		System.out.println("***MENU USUÁRIO***\n-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para MENU");
	
		int num = leia.nextInt();
	
		if (num == 9) {
			MenuView menuview = new MenuView();
			menuview.menu();
		} else if (num == 1) {
			menuCadastrar();
		} else if (num == 2) {
			menuListar(usuario);
		}
	}

	public void menuCadastrar () {
		
		Scanner leia = new Scanner (System.in);
		
		Usuario usuario = new Usuario();
		
		System.out.println("***CADASTRO DE USUÁRIO*** \n-");
		System.out.println("Informe o Username:");
		usuario.setLogin(leia.next()); 
		System.out.println("Informe o PassWord:");
		usuario.setSenha(leia.next()); 
		
		System.out.println("-\n Cadastro Realizado!!!");
		
		menuUsuario(usuario);
	}

	public void menuListar (Usuario usuario) {
		System.out.println("***LISTA DE USUÁRIO*** \n-");
		System.out.println("Username:\n" +usuario.getLogin());
		System.out.println("PassWord:\n" +usuario.getSenha());
		System.out.println("-\n ***************");
		
		menuUsuario(null);
	}
}



