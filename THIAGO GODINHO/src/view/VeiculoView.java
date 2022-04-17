package view;

import java.util.Scanner;

import model.Veiculo;

public class VeiculoView {

	public void menuVeiculo(Veiculo veiculos) {

		System.out.println("***MENU VEICULO***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");
		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:
			cadastroVeiculo();
			break;
		case 2:
			listaVeiculo(veiculos);
			break;
		case 9:
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		}
	}

	public void cadastroVeiculo() {
		Veiculo veiculos = new Veiculo();
		Scanner scan = new Scanner(System.in);
		System.out.println("**Cadastro o Veiculo***");
		System.out.println("-");
		System.out.println("Informe a Identificação");
		veiculos.setId(scan.nextInt());
		System.out.println("Informe o Ano");
		veiculos.setAno(scan.nextInt());
		System.out.println("Informe a Placa");
		veiculos.setPlaca(scan.next());
		System.out.println("Informe a Marca");
		veiculos.setMarca(scan.next());
		System.out.println("-");
		System.out.println("TipoVeiculo registrado!!!");
		
		menuVeiculo(veiculos);

	}
	
	
	public void listaVeiculo(Veiculo veiculos) {
		
		System.out.println("***Lista de Veiculos");
		System.out.println("-");
		System.out.println("-Id: " + veiculos.getId());
		System.out.println("-Ano: " + veiculos.getAno());
		System.out.println("-Placa: "+ veiculos.getPlaca());
		System.out.println("-Marca: " + veiculos.getMarca());
		System.out.println("******");
		System.out.println("");
		System.out.println("");

		menuVeiculo(null);
		
	}
}
