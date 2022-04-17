package view;

import java.util.Scanner;

import model.TipoVeiculo;
import model.Usuario;


public class TipoVeiculoView {
	
	public void  tipoveiculomenu(TipoVeiculo veiculo){
		Scanner ler = new Scanner (System.in);
		
		TipoVeiculoView tipoveiculomenu = new TipoVeiculoView();
		
		System.out.println("***MENU TIPO VEICULO***");
		System.out.println("-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para o Menu");
		System.out.println("-");
		System.out.println("-");
		System.out.println("Aguardando a opção desejada");
		int opcao = ler.nextInt();
		System.out.println("********************");
		
		if (opcao == 9) {
			MenuView menu = new MenuView();
			menu.menu();
			
	} else if (opcao==1) {
		cadastrar();

	} else if (opcao == 2) {
		 listar(veiculo);
	} 
		
	}

public void cadastrar() {
	Scanner ler = new Scanner (System.in);
	
	TipoVeiculoView cadastrar = new TipoVeiculoView();
	TipoVeiculo tipoveiculo = new TipoVeiculo();
	
	System.out.println("****Cadastro Usuario****");
	System.out.println("-");
	System.out.println("Descrição:");
	tipoveiculo.setDescricao(ler.next());
	System.out.println("-");
	System.out.println("Cadastro Realizado!!!");
	System.out.println("********************");
	
	tipoveiculomenu(tipoveiculo);
	
}

public void listar(TipoVeiculo veiculo) {

    System.out.println("***Tipo Veiculo lista***");
    System.out.println("-");
    System.out.println("Descrição:"+veiculo.getDescricao());
    System.out.println("-");
    System.out.println("*****************************");

    tipoveiculomenu(null);
}

}


