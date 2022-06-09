package view;

import java.util.ArrayList;
import model.Usuario;
import model.Veiculo;

public class VeiculoView extends ApplicationView implements IApplicationView {
		
	public void menuVeiculo() {

		System.out.println("***MENU VEÍCULO***\n-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para MENU");
		
		int num = leia.nextInt();

		switch (num) {
		case 1:

			menuCadastrar();
			break;

		case 2:

			menuListar();
			break;

		case 3:

			menuAtualizar();
			break;

		case 4:

			menuDeletar();
			break;

		case 9:

			MenuView menu = new MenuView();
			menu.menu();
			break;

		default:
			System.out.println("Opção Invalida, inicie novamente.");
			menuVeiculo();
			break;
		}

	}

	public void menuCadastrar() {

		Veiculo veiculo = new Veiculo();
		
		System.out.println("***CADASTRO DE VEÍCULO*** \n-");
		System.out.println("Informe a identificação veículo, considere números inteiros:");
		veiculo.setId(leia.nextInt());
		System.out.println("Informe o ano do veículo:");
		veiculo.setAno(leia.nextInt());
		System.out.println("Informe o tipo do veículo, sendo 1 para carro, 2 para moto e 3 para camionete:");
		veiculo.setTipoVeiculoId(leia.nextInt());
		System.out.println("Informe a placa do veículo:");
		veiculo.setPlaca(leia.next());
		System.out.println("Informe a marca do veículo:");
		veiculo.setMarca(leia.next());
		

		System.out.println(veicControl.cadastrar(veiculo));

		// EXECUTAR NOVAMENTE

		menuVeiculo();
	}

	public void menuListar() {

		ArrayList<Veiculo> veicList = veicControl.listar();

		// if retorno vazio
		if (veicList.isEmpty()) {
			System.out.println("Não possui veículo cadastrado!");
		}
		// senão
		// chamar toString

		else {
			System.out.println("***LISTA DE VEÍCULO*** \n-");
			System.out.println("-");
			for (int cont = 0; cont < veicList.size(); cont++) {
				System.out.println(veicList.get(cont).toString());
			}

			System.out.println("-\n ***************");

		}

		menuVeiculo();
	}

	public void menuAtualizar() {

		Veiculo veiculo = new Veiculo();
		
		System.out.println("Informe o ano do veículo:");
		veiculo.setAno(leia.nextInt());
		System.out.println("Informe o tipo do veículo, sendo 1 para carro, 2 para moto e 3 para camionete:");
		veiculo.setTipoVeiculoId(leia.nextInt());
		System.out.println("Informe a placa do veículo:");
		veiculo.setPlaca(leia.next());
		System.out.println("Informe a marca do veículo:");
		veiculo.setMarca(leia.next());
		
		if (!veicControl.atualizar(veiculo)) {
			System.out.println("Veúclo não encontrado");
		} else {
			System.out.println("Cadastro atualizado");
		}

		menuVeiculo();
	}

	public void menuDeletar() {

		Veiculo veiculo = new Veiculo();
		
		System.out.println("***EXCLUSÃO DE VEÍCULO*** \n-");
		System.out.println("Informe a identificação do Veículo:");
		veiculo.setId(leia.nextInt());
		System.out.println("-");

		if (!veicControl.deletar(veiculo)) {
			System.out.println("Veículo não encontrado.");

		} else {
			System.out.println("Cadastro excluido.");
		}

		menuVeiculo();
	}
}
