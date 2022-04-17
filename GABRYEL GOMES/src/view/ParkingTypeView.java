package view;

import java.util.Scanner;

import model.ParkingType;

public class ParkingTypeView {
	public void parkingTypeView(ParkingType parkingType) {
		Scanner scan = new Scanner(System.in);
	
		
		System.out.println("***MENU USUÁRIO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o menu");
		int option = scan.nextInt();
		System.out.println("");
		
		switch(option) {
		case 1:
			register();
			break;
			
		case 2:
			toDisplay(parkingType);
			break;
			
		case 9:
			MenuView menuView = new MenuView();
			menuView.menuView();
			break;
			
		}
		
		scan.close();
	}
	
	public void register() {
		Scanner scan = new Scanner(System.in);
		ParkingType parkingType = new ParkingType();
		
		System.out.println("Informe o tipo de estacionamento:");
		parkingType.setDescription(scan.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		parkingTypeView(parkingType);
		
		scan.close();
	}
	
	public void toDisplay(ParkingType parkingType) {

			System.out.println("***LISTA DE TIPOS DE ESTACIONAMENTO***");
			System.out.println("Tipo: "+ parkingType.getDescription());
			System.out.println("");
			parkingTypeView(null);			
	}
	
}
