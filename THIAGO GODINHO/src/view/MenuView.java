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

		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:

			UsuarioView user = new UsuarioView();
			user.menuUsuario(null);
			break;

		case 2:

			TipoVeiculoView tipoVeiculo = new TipoVeiculoView();
			tipoVeiculo.menuTipoVeiculo(null);
			break;

		case 3:
			VeiculoView veiculos = new VeiculoView();
			veiculos.menuVeiculo(null);
			break;

		case 4:

			PessoaView pessoas = new PessoaView();
			pessoas.menuPessoa(null);
			break;
		case 5:
			TipoEstacionamentoView estacionamentos = new TipoEstacionamentoView();
			estacionamentos.menuTipoEstacionamento(null);

			break;
		case 6:
			System.out.println("-Opção não configurada");

			break;
		case 7:
			System.out.println("-Opção não configurada");

			break;
		case 8:
			System.out.println("-Opção não configurada");

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
