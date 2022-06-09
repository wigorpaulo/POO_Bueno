package view;

import java.util.Scanner;

import model.TipoEstacionameto;


public class TipoEstacionamentoView {

	public void estacionamento (TipoEstacionameto tipoestacionamento) {
		Scanner ler = new Scanner (System.in);
		
		TipoEstacionamentoView estacionamento  = new TipoEstacionamentoView();
		
		
		System.out.println("***MENU TIPO ESTACIONAMENTO***");
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
		 listar(tipoestacionamento);
	}
	}
		
		public void cadastrar() {
			Scanner ler = new Scanner (System.in);
			
			TipoEstacionameto tipoestacionamento = new TipoEstacionameto();
			TipoEstacionamentoView cadastrar = new TipoEstacionamentoView();
			
			System.out.println("****Cadastro Usuario****");
			System.out.println("-");
			System.out.println("Descrição:");
			tipoestacionamento.setDescricao(ler.next());
			System.out.println("-");
			System.out.println("Cadastro Realizado!!!");
			System.out.println("********************");
			
			estacionamento(tipoestacionamento);
		}

		public void listar(TipoEstacionameto tipoestacionamento) {
			
			

		    System.out.println("***Tipo Estacionamento lista***");
		    System.out.println("-");
		    System.out.println("Descrição:"+tipoestacionamento.getDescricao());
		    System.out.println("-");
		    System.out.println("*****************************");

		    estacionamento (null);

		
	
	
	}

		
		}

		



