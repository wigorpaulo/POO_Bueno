package view;

import java.util.Scanner;

import model.TipoEstacionamento;

public class TipoEstacionamentoView {

	public void cadastrar() {
		Scanner scan = new Scanner(System.in);
		TipoEstacionamento tipoEstacionamento = new TipoEstacionamento();
		MenuView menu = new MenuView();
		
		System.out.println("******ESTACIONAMENTO*****");
		System.out.println("-");
		System.out.println("Defina o Tipo de Estacionamento:");
		
		tipoEstacionamento.setDescricao(scan.nextLine());
		menu.menu();
	}
	
}
