package view;

import java.util.Scanner;

import model.Pessoa;

public class PessoaView {

	public void menuPessoa(Pessoa pessoa) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("*** Menu Veiculo ***");
		System.out.println("-");
		System.out.println("- 1 - Cadastrar ");
		System.out.println("- 2 - Listar ");
		System.out.println("- 3 - Atualizar");
		System.out.println("- 4 - Deletar ");
		System.out.println("- 9 - Volta para o menu ");
		System.out.println("-");
		System.out.println("*********");

		int opcao = entrada.nextInt();

		switch (opcao) {
		case 1:
			menuCadPessoa();
			break;
		case 2:
			menuListarPessoa(pessoa);
			break;
		case 9:
			MenuView menuview = new MenuView();
			menuview.menu();

			break;
		}
				
	}
	public void menuCadPessoa() {
		Scanner entrada = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		System.out.println("Digite o nome da pessoa: ");
		pessoa.setNome(entrada.next());
		System.out.println("Digite o email da pessoa: ");
		pessoa.setEmail(entrada.next());
		System.out.println("Digite o telefone da pessoa: ");
		pessoa.setTelefone(entrada.next());
		menuPessoa(pessoa);
	}
	
	public void menuListarPessoa(Pessoa pessoa) {
		System.out.println("*** Lista de Pessoa ***");
		System.out.println("-");
		System.out.println("- Nome da pessoa: " + pessoa.getNome());
		System.out.println("- Email da pessoa: " + pessoa.getEmail());
		System.out.println("- Telefone da pessoa: " + pessoa.getTelefone());
		System.out.println("*********");
		menuPessoa(pessoa);
	}
}
