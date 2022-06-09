package view;

import java.util.Scanner;

import model.TipoVeiculo;

public class TipoVeiculoView {

	public void menuTipoVeiculo(TipoVeiculo tipoVeiculos) {

		System.out.println("***MENU TIPO-VEICULO***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");
		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:
			cadastroTipoVeiculo();
			break;
		case 2:
			listaTipoVeiculo(tipoVeiculos);
			break;
		case 9:
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		}
	}

	public void cadastroTipoVeiculo() {

		TipoVeiculo tipoVeiculos = new TipoVeiculo();

		Scanner scan = new Scanner(System.in);
		System.out.println("**Cadastro Tipo Veiculo***");
		System.out.println("-");
		System.out.println("Informe a Identificação");
		tipoVeiculos.setNome(scan.nextInt());
		System.out.println("Informe a Descrição");
		tipoVeiculos.setDescricao(scan.next());
		System.out.println("-");
		System.out.println("TipoVeiculo registrado!!!");

		menuTipoVeiculo(tipoVeiculos);

	}

	public void listaTipoVeiculo(TipoVeiculo tipoVeiculos) {

		System.out.println("***Lista de TipoVeiculos");
		System.out.println("-");
		System.out.println("-Nome: " + tipoVeiculos.getNome());
		System.out.println("-Descrição: " + tipoVeiculos.getDescricao());
		System.out.println("******");
		System.out.println("");
		System.out.println("");

		menuTipoVeiculo(null);

	}

}
