package view;

import java.util.ArrayList;
import model.Usuario;
import model.Veiculo;

public class VeiculoView extends ApplicationView implements IApplicationView {
		
	public void menuVeiculo() {

		System.out.println("***MENU VE�CULO***\n-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para MENU");
		
		int opcao = scan.nextInt();

		switch (opcao) {
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
			System.out.println("Op��o inválida. Tente novamente!");
			menuVeiculo();
			break;
			
		}

	}

	public void menuCadastrar() {

		Veiculo veiculo = new Veiculo();
		
		System.out.println("*** CADASTRO DE VE�CULO ***");
		System.out.println("Informe a identifica��o ve�culo:");
		veiculo.setId(scan.nextInt());
		System.out.println("Informe o ano do ve�culo:");
		veiculo.setAno(scan.nextInt());
		System.out.println("Informe o tipo do ve�culo:");
		veiculo.setTipoVeiculoId(scan.nextInt());
		System.out.println("Informe a placa do ve�culo:");
		veiculo.setPlaca(scan.next());
		System.out.println("Informe a marca do ve�culo:");
		veiculo.setMarca(scan.next());

		System.out.println(veicControl.cadastrar(veiculo));

		System.out.println("");
		menuVeiculo();
	}

	public void menuListar() {

		ArrayList<Veiculo> veicList = veicControl.listar();

		if (veicList.isEmpty()) {
		
			System.out.println("N�o possui ve�culo cadastrado!");
		
		}

		else {
			
			System.out.println("*** LISTA DE VE�CULO ***");
			for (int cont = 0; cont < veicList.size(); cont++) {
			
				System.out.println(veicList.get(cont).toString());
			
			}

		}

		System.out.println("");
		menuVeiculo();
		
	}

	public void menuAtualizar() {

		Veiculo veiculo = new Veiculo();
		
		System.out.println("Informe o ano do ve�culo:");
		veiculo.setAno(scan.nextInt());
		System.out.println("Informe o tipo do ve�culo:");
		veiculo.setTipoVeiculoId(scan.nextInt());
		System.out.println("Informe a placa do ve�culo:");
		veiculo.setPlaca(scan.next());
		System.out.println("Informe a marca do ve�culo:");
		veiculo.setMarca(scan.next());
		
		if (!veicControl.atualizar(veiculo)) {
			
			System.out.println("Ve�clo n�o encontrado!");
			
		} else {
			
			System.out.println("Cadastro atualizado!");
		
		}

		System.out.println("");
		menuVeiculo();
		
	}

	public void menuDeletar() {

		Veiculo veiculo = new Veiculo();
		
		System.out.println("*** EXCLUS�O DE VE�CULO ***");
		System.out.println("Informe a identifica��o do Ve�culo:");
		veiculo.setId(scan.nextInt());

		if (!veicControl.deletar(veiculo)) {
			
			System.out.println("Ve�culo n�o encontrado.");

		} else {
			
			System.out.println("Cadastro excluido.");
		
		}

		System.out.println("");
		menuVeiculo();
	}
}
