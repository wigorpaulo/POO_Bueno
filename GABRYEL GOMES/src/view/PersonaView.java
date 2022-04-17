package view;

import java.util.Scanner;

import model.Persona;

public class PersonaView {
	public void personaView(Persona persona) {
		Scanner scan = new Scanner(System.in);
	
		
		System.out.println("***MENU USUÁRIO***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para o menu");
		int option = scan.nextInt();
		System.out.println("");
		
		switch(option) {
		case 1:
			register();
			break;
			
		case 2:
			toDisplay(persona);
			break;
			
		case 9:
			MenuView menuView = new MenuView();
			menuView.menuView();
			break;
			
		}
		
		scan.close();
	}
	
	public void register() {
		Scanner scan = new Scanner(System.in);
		Persona persona = new Persona();
		
		System.out.println("Nome:");
		persona.setName(scan.next());
		System.out.println("Telefone:");
		persona.setPhone(scan.next());
		System.out.println("Email:");
		persona.setEmail(scan.next());
		System.out.println("Cadastro realizado!");
		System.out.println("");
		
		personaView(persona);
		
		scan.close();
	}
	
	public void toDisplay(Persona persona) {

			System.out.println("***LISTA DE PESSOAS***");
			System.out.println("Nome: "+ persona.getName());
			System.out.println("Phone: "+ persona.getPhone());
			System.out.println("Email: "+ persona.getEmail());
			System.out.println("");
			personaView(null);			
	}
}
