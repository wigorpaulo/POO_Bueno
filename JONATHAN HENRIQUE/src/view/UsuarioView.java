package view;

import java.util.Scanner;

public class UsuarioView {
	public void UsuarioView(){
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("***Menu Usu�rio***");
		System.out.println("-");
		System.out.println("- 1 - Cadastro");
		System.out.println("- 2 - Lista");
		System.out.println("- 3 - Atualiza��es");
		System.out.println("- 4 - Deletar");
		System.out.println("- 9 - Voltar para o menu");
		numero = sc.nextInt();
		
		if (numero==1) {
			MenuCadastrar menuCadastrar = new MenuCadastrar();
			menuCadastrar.menuCadastrar();
		}
		
		if (numero==2) {
			MenuListar menuListar = new MenuListar();
			menuListar.menuListar();
		}
		
		if (numero==9) {
			MenuUsuario Menuview = new MenuUsuario();
			Menuview.MenuView();
		}
		
	}
}