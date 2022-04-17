package view;

import java.util.Scanner;

import model.TipoEstacionamento;

public class TipoEstacionamentoView {
	public void tipoEstacionamentoView(TipoEstacionamento tipoEstacionamento) {
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
			listar(tipoEstacionamento);
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
		TipoEstacionamento tipoestacionamento = new TipoEstacionamento();
		
		System.out.println("Informe o tipo de estacionamento:");
		tipoestacionamento.setDescricao(leia.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		tipoEstacionamentoView(tipoestacionamento);

	}
	
	public void listar(TipoEstacionamento tipoEstacionamento) {

			System.out.println("***LISTA DE TIPOS DE ESTACIONAMENTO***");
			System.out.println("Tipo: "+ tipoEstacionamento.getDescricao());
			System.out.println("");
			tipoEstacionamentoView(null);
	}
	
}
