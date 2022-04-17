package view;

import java.util.Scanner;

import model.Vehicle;

public class VehicleView {
	public void vehicleView(Vehicle vehicle) {
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
			toDisplay(vehicle);
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
		Vehicle vehicle = new Vehicle();
		
		System.out.println("Informe o ano:");
		vehicle.setAge(scan.nextInt());
		System.out.println("Informe o id:");
		vehicle.setVehicleTypeId(scan.nextInt());
		System.out.println("Informe a placa:");
		vehicle.setPlate(scan.next());
		System.out.println("Informe a marca:");
		vehicle.setMark(scan.next());
		
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		vehicleView(vehicle);
		
		scan.close();
	}
	
	public void toDisplay(Vehicle vehicle) {

			System.out.println("***LISTA DE VEÍCULOS***");
			System.out.println("Ano: "+ vehicle.getAge());
			System.out.println("Id: "+ vehicle.getVehicleTypeId());
			System.out.println("Placa: "+ vehicle.getPlate());
			System.out.println("Mark: "+ vehicle.getMark());
			System.out.println("");
			vehicleView(null);			
	}
}
