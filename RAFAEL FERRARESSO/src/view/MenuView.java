package view;

import java.util.Scanner;

public class MenuView {
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("**********MENU***********");
		System.out.println("-");
		System.out.println("-1 - Cadastrar usu�rio");
		System.out.println("-2 - Cadastrar tipo do ve�culo");
		System.out.println("-3 - Cadastrar ve�culo");
		System.out.println("-4 - Cadastrar pessoa");
		System.out.println("-5 - Cadastrar tipo do estacionamento");
		System.out.println("-");
		System.out.println("-9 - SAIR");
		
		switch (scan.nextInt()) {
		case 1:
			UsuarioView user = new UsuarioView();
			user.menu(null);
			break;

		case 2:
			TipoVeiculoView tipoVeiculo = new TipoVeiculoView();
			tipoVeiculo.cadastrar();
			break;
		
		case 3:
			VeiculoView veiculo = new VeiculoView();
			veiculo.cadastrar();
			break;
			
		case 4:
			PessoaView pessoa = new PessoaView();
			pessoa.cadastrar();
			break;
			
		case 5:
			TipoEstacionamentoView tipoEstacionamento = new TipoEstacionamentoView();
			tipoEstacionamento.cadastrar();
			break;
			
		case 9:
			System.out.println("Sess�o encerrada");
			System.exit(0);
			break;
			
		default:
			System.out.println("Op��o inv�lida");
			menu();
			
		}
		
	}

}
