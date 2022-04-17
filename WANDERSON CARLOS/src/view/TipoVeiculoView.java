package view;

import java.util.Scanner;
import model.TipoVeiculo;

public class TipoVeiculoView {
	public void tipoVeiculoView(TipoVeiculo tipoVeiculo) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("***MENU TIPO VE�CULO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o  menu");
		int opcao = scan.nextInt();
		System.out.println("");
		
		switch(opcao) {
		case 1:
			registrar();
			break;
			
		case 2:
			listar(tipoVeiculo);
			break;
			
		case 9:
			MenuView menuView = new MenuView();
			menuView.menuView();
			break;
			
		}
	}
	
	public void registrar() {
		Scanner leia = new Scanner(System.in);
		TipoVeiculo tipoVeiculo = new TipoVeiculo();
		
		System.out.println("Descreva o tipo do ve�culo:");
		tipoVeiculo.setDescricao(leia.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		tipoVeiculoView(tipoVeiculo);

	}
	
	public void listar(TipoVeiculo tipoVeiculo) {

			System.out.println("***LISTA DE TIPOS DE VE�CULO***");
			System.out.println("Tipo: "+ tipoVeiculo.getDescricao());
			System.out.println("");
			tipoVeiculoView(null);
	}
}
