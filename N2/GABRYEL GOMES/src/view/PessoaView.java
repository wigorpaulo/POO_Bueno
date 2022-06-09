package view;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaView extends ApplicationView implements IApplicationView {

	public void menuPessoa() {

		System.out.println("*** MENU PESSOA ***");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("9 - Voltar para MENU");
		int opcao = scan.nextInt();
		System.out.println("");

		switch (opcao) {
		
		case 1:
			menuCadastrar();
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
			MenuView menu = new MenuView();
			menu.menu();
			break;

		default:
			System.out.println("Op��o Invalida, inicie novamente.");
			menuPessoa();
			break;
			
		}

	}

	public void menuCadastrar() {

		Pessoa pessoa = new Pessoa();
		
		System.out.println("*** CADASTRO DE PESSOA ***");
		System.out.println("Informe o nome:");
		pessoa.setNome(scan.next());
		System.out.println("Informe o telefone:");
		pessoa.setTelefone(scan.next()); 
		System.out.println("Informe o e-mail:");
		pessoa.setEmail(scan.next()); 

		System.out.println(pessControl.cadastrar(pessoa));
		
		System.out.println("");

		menuPessoa();
		
	}

	public void menuListar() {

		ArrayList<Pessoa> pessList = pessControl.listar();

		if (pessList.isEmpty()) {
			
			System.out.println("N�o possui usu�rio cadastrado!");
		
		}
		
		else {
			
			System.out.println("*** LISTA DE PESSOA ***");
			for (int cont = 0; cont < pessList.size(); cont++) {
				
				System.out.println(pessList.get(cont).toString());
			
			}
		}

		System.out.println("");
		menuPessoa();
	}

	public void menuAtualizar() {

		Pessoa pessoa = new Pessoa();

		System.out.println("*** CADASTRO DE PESSOA ***");
		System.out.println("Informe o nome:");
		pessoa.setNome(scan.next());
		System.out.println("Informe o telefone:");
		pessoa.setTelefone(scan.next()); 
		System.out.println("Informe o e-mail:");
		pessoa.setEmail(scan.next()); 

		if (!pessControl.atualizar(pessoa)) {
			
			System.out.println("Usu�rio n�o encontrado");
			
		} else {
			
			System.out.println("Cadastro atualizado");
		
		}

		System.out.println("");
		menuPessoa();
		
	}

	public void menuDeletar() {

		Pessoa pessoa = new Pessoa();;

		System.out.println("*** EXCLUS�O DE PESSOA ***");
		System.out.println("Informe o nome:");
		pessoa.setNome(scan.next());
		System.out.println("");

		if (!pessControl.deletar(pessoa)) {
			System.out.println("Pessoa n�o encontrada.");

		} else {
			System.out.println("Cadastro excluido.");
		}
		
		System.out.println("");
		menuPessoa();
	}
}
