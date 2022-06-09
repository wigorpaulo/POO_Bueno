package view;

import java.util.Scanner;

public class MenuView {

	public void menu() {

		System.out.println("***  MENU  ***");
		System.out.println("-");
		System.out.println("-1.Cadastrar Usuario");
		System.out.println("-2.Cadastrar TipoVeiculo");
		System.out.println("-3.Cadastrar Veiculo");
		System.out.println("-4.Cadastrar Pessoa");
		System.out.println("-5.Cadastrar TipoEstacionamento");
		System.out.println("-9.Sair");

		Scanner s = new Scanner(System.in);
		int ch = s.nextInt();
		switch (ch) {
		case 1:

			UsuarioView user = new UsuarioView();
			user.menuUsuario();
			break;

		case 2:
			System.out.println("Opção não configurada");
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		case 3:
			VeiculoView veiculos = new VeiculoView();
			veiculos.menuVeiculo();
			break;

		case 4:

			PessoaView pessoas = new PessoaView();
			pessoas.menuPessoa();
			break;
		case 5:
//				TipoEstacionamentoView estacionamentos = new TipoEstacionamentoView();
//				estacionamentos.menuTipoEstacionamento(null);
			System.out.println("Opção não configurada");
			MenuView menuGeral2 = new MenuView();
			menuGeral2.menu();
			break;
		case 6:
			System.out.println("-Opção não configurada");
			MenuView menuGeral3 = new MenuView();
			menuGeral3.menu();

			break;
		case 7:
			System.out.println("-Opção não configurada");
			MenuView menuGeral4 = new MenuView();
			menuGeral4.menu();

			break;
		case 8:
			System.out.println("-Opção não configurada");
			MenuView menuGeral5 = new MenuView();
			menuGeral5.menu();

			break;
		case 9:

			System.out.println("Saindo do Menu"); // finalizar o sistema
			System.out.println("-");
			System.out.println("-");
			System.exit(1);

			break;
		}

	}

}
