package view;

import model.Veiculo;
import java.util.Scanner;

public class VeiculoView {

	public void menuVeiculo (Veiculo veiculo) {
		Scanner entrada = new Scanner (System.in);
		System.out.println("*** Menu Veiculo ***");
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
			menuCadVeiculo();
		break;
		case 2:
			menuListarVeiculo(veiculo);
		break;
		case 9:
		MenuView menuview = new MenuView();
			menuview.menu();
		break;
		}
	}
	public void menuCadVeiculo() {
		Scanner entrada = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		
		System.out.println("Digite o tipo do ve�culo: ");
		veiculo.setTipoveiculo(entrada.nextInt());
		
		System.out.println("Digite o ano do ve�culo: ");
		veiculo.setAno(entrada.nextInt());
		
		System.out.println("Digite a descri��o do ve�culo: ");
		veiculo.setDescricao(entrada.next());
		
		System.out.println("Digite a marca do ve�culo: ");
		veiculo.setMarca(entrada.next());
		
		System.out.println("Digite a placa do ve�culo: ");
		veiculo.setPlaca(entrada.next());
		
		menuVeiculo(veiculo);
	}
	public void menuListarVeiculo(Veiculo veiculo) {
		System.out.println("*** Lista de Veiculo ***");
		System.out.println("-");
		System.out.println("- Tipo de ve�culo: " + veiculo.getDescricao());
		System.out.println("- Ano do ve�culo: " + veiculo.getAno());
		System.out.println("- Descri��o do ve�culo: " + veiculo.getDescricao());
		System.out.println("- Marca do ve�culo: " + veiculo.getMarca());
		System.out.println("- Placa do ve�culo: " + veiculo.getPlaca());
		System.out.println("*********");
		menuVeiculo(veiculo);
	}
}
