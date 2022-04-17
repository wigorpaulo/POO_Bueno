package view;

import java.util.Scanner;

import model.Veiculo;

public class VeiculoView {
	public void veiculoView(Veiculo veiculo) {
		Scanner scan = new Scanner(System.in);
	
		
		System.out.println("***MENU USUARIO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o menu");
		int opcao = scan.nextInt();
		System.out.println("");
		
		switch(opcao) {
		case 1:
			registrar();
			break;
			
		case 2:
			listar(veiculo);
			break;
			
		case 9:
			MenuView menuView = new MenuView();
			menuView.menuView();
			break;
			
		}
		
		scan.close();
	}
	
	public void registrar() {
		Scanner leia = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		
		System.out.println("Informe o ano:");
		veiculo.setAno(leia.nextInt());
		System.out.println("Informe o id:");
		veiculo.setTipoVeiculoID(leia.nextInt());
		System.out.println("Informe a placa:");
		veiculo.setPlaca(leia.next());
		System.out.println("Informe a marca:");
		veiculo.setMarca(leia.next());
		
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		veiculoView(veiculo);

	}
	
	public void listar(Veiculo veiculo) {

			System.out.println("***LISTA DE VEICULOS***");
			System.out.println("Ano: "+ veiculo.getAno());
			System.out.println("Id: "+ veiculo.getTipoVeiculoID());
			System.out.println("Placa: "+ veiculo.getPlaca());
			System.out.println("Mark: "+ veiculo.getMarca());
			System.out.println("");
			veiculoView(null);
	}
}
