package view;

import java.util.Scanner;

import model.TipoVeiculo;

public class TipoVeiculoView {
	public void tipoVeiculo (TipoVeiculo tipoveiculo) {
	
	Scanner leia = new Scanner (System.in);
		
		System.out.println("***MENU TIPO VE�CULO ***\n-");
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
			menuListar(tipoveiculo);
		}
	}

	public void menuCadastrar () {
		
		Scanner leia = new Scanner (System.in);
		
		TipoVeiculo usuario = new TipoVeiculo();
		
		// System.out.println("***CADASTRO DE USU�RIO*** \n-");
		// System.out.println("Informe o Username:");
		// usuario.setLogin(leia.next()); 
		// System.out.println("Informe o PassWord:");
		// usuario.setSenha(leia.next()); 
		
		// System.out.println("-\n Cadastro Realizado!!!");
		
		// menuUsuario(usuario);
	}

	public void menuListar (TipoVeiculo tipoveiculo) {
		// System.out.println("***LISTA DE USU�RIO*** \n-");
		// System.out.println("Username:\n" +usuario.getLogin());
		// System.out.println("PassWord:\n" +usuario.getSenha());
		// System.out.println("-\n ***************");
		
		// menuUsuario(null);
	}
}
