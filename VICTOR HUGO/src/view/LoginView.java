package view;

import java.util.Scanner;

import model.Usuario;

public class LoginView {
	
		
	        public void login() {
			Scanner ler = new Scanner (System.in);
			
			
			Usuario user = new Usuario();
			
			System.out.println("**Login**");
			System.out.println("-");
			System.out.println("-");
			System.out.println("----------------");
			System.out.println("Usarname:");
			String username = ler.next();
			System.out.println("----------------");
			System.out.println("Password:");
			String password = ler.next();
			System.out.println("----------------");
			System.out.println("-");
			System.out.println("-");
			System.out.println("Logado com Sucesso");
			System.out.println("*********************");
			
			MenuView menu = new MenuView();
			menu.menu();
	}

				
			}

			

		
				

			
				
			

			

				
			
		
		

