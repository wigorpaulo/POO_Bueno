package view;

import java.util.Scanner;

import model.Veiculo;

public class VeiculoView {
		
	public void cadastrar() {
		Scanner scan = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		MenuView menu = new MenuView();
			
		System.out.println("Defina o ano do ve�culo:");
		veiculo.setAno(scan.nextInt());
		System.out.println("Descreva o ve�culo:");
		veiculo.setDescricao(scan.nextLine());
		menu.menu();
	}

}
