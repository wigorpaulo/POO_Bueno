package view;

import java.util.Scanner;

public class MenuView {

	public void menu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("*** MENU ***");
		System.out.println("1 - Cadastrar Usu�rio");
		System.out.println("2 - Cadastrar Tipo Ve�culo");
		System.out.println("3 - Cadastrar Ve�culo");
		System.out.println("4 - Cadastrar Pessoa");
		System.out.println("5 - Cadastrar Tipo Estacionamento");
		System.out.println("9 - SAIR");
		int opcao = scan.nextInt();
		System.out.println("");

		switch (opcao) {
		
		case 1:
			UsuarioView usuarioview = new UsuarioView();
			usuarioview.menuUsuario();
			break;
			
		case 3:
			VeiculoView veiculoview = new VeiculoView();
			veiculoview.menuVeiculo();
			break;
			
		case 4:
			PessoaView pessoaview = new PessoaView();
			pessoaview.menuPessoa();
			break;
			
		case 9:
			System.out.println("Programa finalizado!");
			System.exit(0);
			break;
			
		default:
			System.out.println("Op��o Invalida, inicie novamente.");
			menu();

		}
		
		scan.close();
	}
}