package view;

import java.util.Scanner;

import model.Pessoa;

public class PessoaView {

	public void menuPessoa(Pessoa pessoas) {

		System.out.println("***MENU PESSOA***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");
		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:
			cadastroPessoa();
			break;
		case 2:
			listaPessoa(pessoas);
			break;
		case 9:
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		}

	}

	public void cadastroPessoa() {
		Pessoa pessoas = new Pessoa();

		Scanner scan = new Scanner(System.in);
		System.out.println("**Cadastro o Veiculo***");
		System.out.println("-");
		System.out.println("Informe a Identificação");
		pessoas.setId(scan.nextInt());
		System.out.println("Informe o Nome");
		pessoas.setNome(scan.next());
		System.out.println("Informe o Telefone");
		pessoas.setTelefone(scan.next());
		System.out.println("Informe o Email");
		pessoas.setEmail(scan.next());
		System.out.println("-");
		System.out.println("Pessoa registrada!!!");

		menuPessoa(pessoas);

	}

	public void listaPessoa(Pessoa pessoas) {
		System.out.println("***Lista de Pessoas");
		System.out.println("-");
		System.out.println("-Id: " + pessoas.getId());
		System.out.println("-Nome: " +pessoas.getNome());
		System.out.println("-Telefone: "+ pessoas.getTelefone());
		System.out.println("-Email: " + pessoas.getEmail());
		System.out.println("******");
		System.out.println("");
		System.out.println("");

		menuPessoa(null);

	}
}
