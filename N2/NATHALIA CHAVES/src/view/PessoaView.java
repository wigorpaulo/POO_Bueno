package view;

import java.util.ArrayList;

import model.Pessoa;

public class PessoaView extends ApplicationView implements IApplicationView {

	public void menuPessoa() {

		System.out.println("***MENU PESSOA***\n-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para MENU");

		int num = leia.nextInt();

		switch (num) {
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
			System.out.println("Opção Invalida, inicie novamente.");
			menuPessoa();
			break;
		}

	}

	public void menuCadastrar() {

		Pessoa pessoa = new Pessoa();
		
		System.out.println("***CADASTRO DE PESSOA*** \n-");
		System.out.println("Informe o nome:");
		pessoa.setNome(leia.next());
		System.out.println("Informe o telefone:");
		pessoa.setTelefone(leia.next()); 
		System.out.println("Informe o e-mail:");
		pessoa.setEmail(leia.next()); 

		System.out.println(pessControl.cadastrar(pessoa));

		// EXECUTAR NOVAMENTE

		menuPessoa();
	}

	public void menuListar() {

		ArrayList<Pessoa> pessList = pessControl.listar();

		// if retorno vazio
		if (pessList.isEmpty()) {
			System.out.println("Não possui usuário cadastrado!");
		}
		// senï¿½o
		// chamar toString

		else {
			System.out.println("***LISTA DE PESSOA*** \n-");
			System.out.println("-");
			for (int cont = 0; cont < pessList.size(); cont++) {
				System.out.println(pessList.get(cont).toString());
			}

			System.out.println("-\n ***************");

		}

		menuPessoa();
	}

	public void menuAtualizar() {

		Pessoa pessoa = new Pessoa();

		System.out.println("***CADASTRO DE PESSOA*** \n-");
		System.out.println("Informe o nome:");
		pessoa.setNome(leia.next());
		System.out.println("Informe o telefone:");
		pessoa.setTelefone(leia.next()); 
		System.out.println("Informe o e-mail:");
		pessoa.setEmail(leia.next()); 

		if (!pessControl.atualizar(pessoa)) {
			System.out.println("Usuário não encontrado");
		} else {
			System.out.println("Cadastro atualizado");
		}

		menuPessoa();
	}

	public void menuDeletar() {

		Pessoa pessoa = new Pessoa();;

		System.out.println("***EXCLUSÃO DE PESSOA*** \n-");
		System.out.println("Informe o nome:");
		pessoa.setNome(leia.next());
		System.out.println("-");

		if (!pessControl.deletar(pessoa)) {
			System.out.println("Pessoa não encontrada.");

		} else {
			System.out.println("Cadastro excluido.");
		}

		menuPessoa();
	}
}
