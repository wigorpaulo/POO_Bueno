package view;

import java.util.Scanner;
import model.VehicleType;
import model.User;

public class VehicleTypeView {
	public void vehicleTypeView(VehicleType vehicleType) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("***MENU TIPO VEÍCULO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o  menu");
		int option = scan.nextInt();
		System.out.println("");
		
		switch(option) {
		case 1:
			register();
			break;
			
		case 2:
			toDisplay(vehicleType);
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
		VehicleType vehicleType = new VehicleType();
		
		System.out.println("Descreva o tipo do veículo:");
		vehicleType.setDescription(scan.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		vehicleTypeView(vehicleType);
		
		scan.close();
	}
	
	public void toDisplay(VehicleType vehicleType) {

			System.out.println("***LISTA DE TIPOS DE VEÍCULO***");
			System.out.println("Tipo: "+ vehicleType.getDescription());
			System.out.println("");
			vehicleTypeView(null);			
	}
}
