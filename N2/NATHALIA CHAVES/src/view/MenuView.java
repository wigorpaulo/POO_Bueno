package view;

import java.util.Scanner;
import model.Usuario;
import view.LoginView;

public class MenuView {

	public void menu() {
		Scanner leia = new Scanner(System.in);

		System.out.println("***MENU***\n-");
		System.out.println(" 1- Cadastrar Usuário");
		System.out.println(" 2- Cadastrar Tipo Veículo");
		System.out.println(" 3- Cadastrar Veículo");
		System.out.println(" 4- Cadastrar Pessoa");
		System.out.println(" 5-Cadastrar Tipo Estacionamento");
		System.out.println(" 9- SAIR\n-");
		System.out.println("***    ***");

		int num = leia.nextInt();

		switch (num) {
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

			System.out.println("Programa encerrado");
			System.exit(0);
			break;
			
		default:
			System.out.println("Opção Invalida, inicie novamente.");
			menu();

		}
	}
}