package view;

import java.util.Scanner;

import model.Pessoa;
import model.TipoEstacionamento;

public class TipoEstacionamentoView {

	public void menuTipoEstacionamento(TipoEstacionamento estacionamentos) {

		System.out.println("***MENU TipoEstacionamento***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");
		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:
			cadastroTipoEstacionamento();
			break;
		case 2:
			listaTipoEstacionamento(estacionamentos);
			break;
		case 9:
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		}
	}
	public void cadastroTipoEstacionamento() {
		TipoEstacionamento estacionamentos = new TipoEstacionamento();

		Scanner scan = new Scanner(System.in);
		System.out.println("**Cadastro o Veiculo***");
		System.out.println("-");
		System.out.println("Informe a Identificação");
		estacionamentos.setId(scan.nextInt());
		System.out.println("Informe a Descrição");
		estacionamentos.setDescricao(scan.next());
		System.out.println("-");
		System.out.println("TipoEstacionamento Registrado!!!");

		menuTipoEstacionamento(estacionamentos);

		
	}
	public void listaTipoEstacionamento(TipoEstacionamento estacionamentos) {
		System.out.println("***Lista de TipoEstacionamentos");
		System.out.println("-");
		System.out.println("-Id: " + estacionamentos.getId());
		System.out.println("-Descrição: " +estacionamentos.getDescricao());
		System.out.println("******");
		System.out.println("");
		System.out.println("");

		menuTipoEstacionamento(null);
		
	}
}
