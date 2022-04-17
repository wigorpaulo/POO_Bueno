package view;

import java.util.Scanner;

import model.Pessoa;

public class PessoaView {
	
	public void cadastrar() {
		Scanner scan = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		MenuView menu = new MenuView();
		
		System.out.println("Defina o nome:");
		pessoa.setNome(scan.nextLine());
		System.out.println("Defina o telefone:");
		pessoa.setTelefone(scan.nextInt());
		menu.menu();
	}

}
