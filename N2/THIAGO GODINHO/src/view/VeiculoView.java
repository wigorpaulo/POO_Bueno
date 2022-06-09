package view;

import java.util.ArrayList;

import model.Veiculo;
import model.Veiculo;
import model.Veiculo;
import model.Veiculo;

public class VeiculoView extends ApplicationView implements IApplicationView {

	public void menuVeiculo() {

		System.out.println("***MENU VEICULO***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");

		int ch = s.nextInt();
		switch (ch) {
		case 1:
			menuCadastro();
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
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		}
	}

	@Override
	public void menuCadastro() {
		Veiculo veiculo = new Veiculo();

		System.out.println("**Cadastro de Veiculo***");
		System.out.println("-");
		System.out.println("Informe a Placa");
		veiculo.setPlaca(s.next());
		System.out.println("Informe a Marca ");
		veiculo.setMarca(s.next());
		System.out.println("Informe o Ano");
		veiculo.setAno(s.next());
		System.out.println("-");
		System.out.println(veControl.cadastrar(veiculo));

		menuVeiculo();

	}

	@Override
	public void menuListar() {
		ArrayList<Veiculo> veList = veControl.listar();

		if (veList.isEmpty()) {
			System.out.println("Não possui veiculo cadastrado");
		} else {
			System.out.println("**Lista de Veiculo***");
			System.out.println("-");

			for (int cont = 0; cont < veList.size(); cont++) {
				System.out.println(veList.get(cont).toString());
			}

			System.out.println("-");
			System.out.println("**************");
		}
		menuVeiculo();
	}

	@Override
	public void menuAtualizar() {
		Veiculo veiculo = new Veiculo();
		System.out.println("**Atualização de Usuario***");
		System.out.println("-");
		System.out.println("Informe a Placa");
		veiculo.setPlaca(s.next());
		System.out.println("Informe a Marca");
		veiculo.setMarca(s.next());
		System.out.println("Informe o Ano");
		veiculo.setAno(s.next());

		System.out.println("-");

		if (!veControl.atualizar(veiculo)) {
			System.out.println("Veiculo nao encontrado");
		} else {
			System.out.println("veiculo atualizado");
		}
		menuVeiculo();
	}

	@Override
	public void menuDeletar() {
		Veiculo veiculo = new Veiculo();

		System.out.println("**Exclusão de Veiculo***");
		System.out.println("-");
		System.out.println("Informe a Placa");
		veiculo.setPlaca(s.next());
		System.out.println("-");

		if (!veControl.deletar(veiculo)) {
			System.out.println("Veiculo nao encontrado");
		} else {
			System.out.println("Veiculo excluido");
		}
		menuVeiculo();

	}
}
