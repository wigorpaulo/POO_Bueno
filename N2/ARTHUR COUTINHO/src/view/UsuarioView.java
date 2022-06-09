package view;

import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;

public class UsuarioView {
	Scanner sc = new Scanner(System.in);
	
	public void menuUsuario(){
		System.out.println("***Menu Usuário***");
		System.out.println("-");
		System.out.println("- 1 - Cadastrar ");
		System.out.println("- 2 - Listar ");
		System.out.println("- 3 - Atualizar ");
		System.out.println("- 4 - Deletar");
		System.out.println("- 9 - Voltar para menu");
		System.out.println("-");
		System.out.println("*********");
		int numero = sc.nextInt();
		
		if (numero == 1) {
			menuCadastrar();
		}
		if (numero == 2) {
			menuListar();
		}
		if (numero == 3) {

		}
		if (numero == 4) {
		
		}
		if (numero == 9) {
			System.out.println("Você retornou para o menu");
			MenuView menu = new MenuView();
			
			menu.menu();
		}
		else {
			menuUsuario();
		}
	} 
	
	public void menuCadastrar(){
		Scanner sc = new Scanner(System.in);
		
		Usuario user = new Usuario();
		
		System.out.println("***Cadastro de usuário");
		System.out.println("-");
		System.out.println("Informe o username: ");
		user.setUsername(sc.next());
		System.out.println("Informe o password: ");
		user.setPassword(sc.next());
		System.out.println("-");
		System.out.println("Cadastro realizado!!!");
		
		UsuarioController userControl = new UsuarioController();
		
		userControl.cadastrar(user);

	}
	
	public void menuListar(){
		UsuarioController userControl = new UsuarioController();
		
		userControl.listar();
		
		System.out.println("Não possui usuário cadastrado!");
		
		System.out.println("***Lista de usuário***");
		System.out.println("-");
		System.out.println("-");
		System.out.println("-");

				
	}
	
	public void menuAtualizar() {
		Usuario user = new Usuario();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***Atualização de usuário");
		System.out.println("-");
		System.out.println("Informe o username: ");
		user.setUsername(sc.next());
		System.out.println("Informe o password: ");
		user.setPassword(sc.next());
		System.out.println("-");
		
		UsuarioController userControl = new UsuarioController();
		
		if(!userControl.atualizar(user)) {
		System.out.println("Usuário não encontrado");	
		}else {
		System.out.println("Cadastro de usuário atualizado com sucesso");	
		
		}
	}
	
	public void menuDeletar() {
		Usuario user = new Usuario();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***Atualização de usuário");
		System.out.println("-");
		System.out.println("Informe o username: ");
		user.setUsername(sc.next());
		System.out.println("Informe o password: ");
		user.setPassword(sc.next());
		System.out.println("-");
		
		UsuarioController userControl = new UsuarioController();
		
		if (userControl.deletar(user)) {
			System.out.println("Usuário não encontrado");	
		}
		
		else {
			System.out.println("Usuário excluido");	
		}
	}
	
}