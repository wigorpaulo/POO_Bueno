package view;

import java.util.Scanner;

import model.TipoVeiculo;

public class TipoVeiculoView {
	
	public void cadastrar() {
		Scanner scan = new Scanner(System.in);
		TipoVeiculo tipoVeiculo = new TipoVeiculo();
		MenuView menu = new MenuView();
		
		System.out.println("*****TIPO DE VEÍCULO*****");
		System.out.println("-");
		System.out.println("Defina o Tipo de Veículo:");
		
		tipoVeiculo.setDescricao(scan.nextLine());
		menu.menu();
		
	}

}
