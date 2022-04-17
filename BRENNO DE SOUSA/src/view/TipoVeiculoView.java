package view;

import java.util.Scanner;

import model.TipoVeiculo;
import model.Veiculo;


public class TipoVeiculoView {

	public void menuVeiculo(TipoVeiculo tipoveiculo) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("*** Menu Tipo Veiculo ***");
		System.out.println("-");
		System.out.println("- 1 - Cadastrar ");
		System.out.println("- 2 - Listar ");
		System.out.println("- 3 - Atualizar");
		System.out.println("- 4 - Deletar ");
		System.out.println("- 9 - Volta para o menu ");
		System.out.println("-");
		System.out.println("*********");

		int opcao = entrada.nextInt();
		
		switch (opcao) {
		case 1:
			menuCadTipoVeiculo();
			break;
		case 2: 
			menuListarTipoVeiculo(tipoveiculo);
			break;
		case 9:
			MenuView menuview = new MenuView();
			menuview.menu();
		}
	}
	
	public void menuCadTipoVeiculo () {
		Scanner entrada = new Scanner(System.in);
		
		TipoVeiculo tipoveiculo = new TipoVeiculo();
		
		System.out.println("Digite o tipo do veiculo: ");
		tipoveiculo.setDescricao(entrada.next());
		menuVeiculo(tipoveiculo);
	}
	
	public void menuListarTipoVeiculo(TipoVeiculo tipoveiculo) {
		System.out.println("*** Lista de Tipo de Veiculo ***");
		System.out.println("-");
		System.out.println("- Tipo de veículo: " + tipoveiculo.getDescricao());
		System.out.println("*********");

		menuVeiculo(tipoveiculo);
	}
	
}
