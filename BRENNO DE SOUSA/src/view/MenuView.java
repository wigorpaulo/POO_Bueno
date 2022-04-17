package view;

import java.util.Scanner;

public class MenuView {

	public void menu() {
				
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("*** Menu Principal***");

		System.out.println("-");

		System.out.println("- 1 - Cadastrar usu�rio ");
		System.out.println("- 2 - Cadastrar tipo de veiculo ");
		System.out.println("- 3 - Cadastrar veiculo");
		System.out.println("- 4 - Cadastrar pessoa ");
		System.out.println("- 5 - Cadastrar tipo de estacionamento ");
		System.out.println("- 9 - Sair ");
		System.out.println("-");
		System.out.println("*********");
		int opcao = entrada.nextInt();

		switch (opcao) {
		case 9:
			System.exit(0);
			System.out.println("Programa finalizado");
			break;
		case 1:
			UsuarioView usuarioview = new UsuarioView();
			usuarioview.menuUsuario(null);
			break;
		case 2:
			TipoVeiculoView tipoveiculoview = new TipoVeiculoView();
			tipoveiculoview.menuVeiculo(null);
			break;
		case 3:
			VeiculoView veiculoview = new VeiculoView();
			veiculoview.menuVeiculo(null);
			break;
		case 4:
			PessoaView pessoaview = new PessoaView();
			pessoaview.menuPessoa(null);
			break;
		}

	}

}
