package view;

import java.util.Scanner;
import model.Usuario;

public class UsuarioView {
	
	public void usuarioView(Usuario usuario) {
		Scanner leia = new Scanner(System.in);
	
		
		System.out.println("***MENU USUARIO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o menu");
		int opcao = leia.nextInt();
		System.out.println("");
		
		switch(opcao) {
		case 1:
			registrar();
			break;
			
		case 2:
			listar(usuario);
			break;
			
		case 9:
			MenuView menuView = new MenuView();
			menuView.menuView();
			break;
			
		}
		
		leia.close();
	}
	
	public void registrar() {
		Scanner leia = new Scanner(System.in);
		Usuario usuario = new Usuario();
		
		System.out.println("Informe o username:");
		usuario.setNomeUsuario(leia.next());
		System.out.println("Informe a senha:");
		usuario.setSenha(leia.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		usuarioView(usuario);

	}
	
	public void listar(Usuario usuario) {

			System.out.println("***LISTA DE USUARIO***");
			System.out.println("Username: "+ usuario.getNomeUsuario());
			System.out.println("Password: "+ usuario.getSenha());
			System.out.println("");
			usuarioView(null);
	}


}
