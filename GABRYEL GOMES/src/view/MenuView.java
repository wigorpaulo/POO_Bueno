package view;

import java.util.Scanner;

public class MenuView {
	public void menuView() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***MENU***");
		System.out.println("1 - Cadastrar usuário");
		System.out.println("2 - Cadastrar tipo do veículo");
		System.out.println("3 - Cadastrar veículo");
		System.out.println("4 - Cadastrar pessoa");
		System.out.println("5 - Cadastrar tipo de estacionamento");
		System.out.println("9 - Sair");
		int opcao = scan.nextInt();
		System.out.println("");
		
		switch(opcao) {
		case 1:
			UserView userView = new UserView();
			userView.userView(null);
			break;
			
		case 2:
			VehicleTypeView vehicleType = new VehicleTypeView();
			vehicleType.vehicleTypeView(null);
			break;
			
		case 3:
			VehicleView vehicle = new VehicleView();
			vehicle.vehicleView(null);
			break;
			
		case 4:
			PersonaView personaView = new PersonaView();
			personaView.personaView(null);
			break;
			
		case 5:
			ParkingTypeView parkingType = new ParkingTypeView();
			parkingType.parkingTypeView(null);
			break;
			
		case 9:
			System.out.println("Você saiu do sistema!");
			System.exit(0);
		}
		
		
		
		
		scan.close();
	}

}
