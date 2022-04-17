package view;

import java.util.Scanner;

public class MenuView {
	public void menuView() {
		Scanner leia = new Scanner(System.in);
		
		System.out.println("***MENU***");
		System.out.println("1 - Cadastrar usuario");
		System.out.println("2 - Cadastrar tipo do veiculo");
		System.out.println("3 - Cadastrar veiculo");
		System.out.println("4 - Cadastrar pessoa");
		System.out.println("5 - Cadastrar tipo de estacionamento");
		System.out.println("9 - Sair");
		int opcao = leia.nextInt();
		System.out.println("");
		
		switch(opcao) {
		case 1:
			UsuarioView userView = new UsuarioView();
			userView.usuarioView(null);
			break;
			
		case 2:
			TipoVeiculoView vehicleType = new TipoVeiculoView();
			vehicleType.tipoVeiculoView(null);
			break;
			
		case 3:
			VeiculoView vehicle = new VeiculoView();
			vehicle.veiculoView(null);
			break;
			
		case 4:
			PessoaView personaView = new PessoaView();
			personaView.pessoaView(null);
			break;
			
		case 5:
			TipoEstacionamentoView parkingType = new TipoEstacionamentoView();
			parkingType.tipoEstacionamentoView(null);
			break;
			
		case 9:
			System.out.println("Obrigado!");
			System.exit(0);
		}

	}

}
