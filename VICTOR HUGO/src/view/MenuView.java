package view;

import java.util.Scanner;

import view.LoginView;

public class MenuView {
	Scanner ler = new Scanner (System.in);

		public void menu(){
		
		
			System.out.println("****MENU****");
			System.out.println("-");
			System.out.println("1- Cadastrar Usuario");
			System.out.println("2- Cadastrar tipo de veiculo");
			System.out.println("3- Cadastro Veiculo");
			System.out.println("4- Cadastrar Pessoa");
			System.out.println("5 - Cadastrar tipo Estacionamento");
			System.out.println("9 - Sair");
			int opcao = ler.nextInt();
			System.out.println("-");
			System.out.println("********************");
			
			if (opcao==9) {
				System.out.println("Você saiu do Sistema");
				System.exit(0);
				
			} else if (opcao == 1) {
			
				UsuarioView usuario = new UsuarioView();
				usuario.usuario(null);

			} else if (opcao==2) {
				TipoVeiculoView  tipoveiculomenu = new TipoVeiculoView();
				 tipoveiculomenu.tipoveiculomenu(null);
			}
			
			
			}
		
		}

