package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Pessoa;
import model.Pessoa;
import model.Pessoa;
import model.Pessoa;
import model.Pessoa;

public class PessoaView extends ApplicationView implements IApplicationView {

	public void menuPessoa() {

		System.out.println("***MENU PESSOA***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");

		int ch = s.nextInt();
		switch (ch) {
		case 1:
			menuCadastro();
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
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;

		}

	}

	public void menuCadastro() {
		Pessoa pessoa = new Pessoa(); 

		System.out.println("**Cadastro de Pessoa***");
		System.out.println("-");
		System.out.println("Informe o Username");
		pessoa.setNome(s.next());
		System.out.println("Informe o Telefone");
		pessoa.setTelefone(s.next());
		System.out.println("Informe o Email");
		pessoa.setEmail(s.next());
		System.out.println("-");

		System.out.println(peControl.cadastrar(pessoa));

		menuPessoa();

	}

	public void menuListar() {
		ArrayList<Pessoa> pessoaListar = peControl.listar();

		if (pessoaListar.isEmpty()) {
			System.out.println("Não possui pessoa cadastrada");
		} else {
			System.out.println("**Lista de Pessoas***");
			System.out.println("-");

			for (int cont = 0; cont < pessoaListar.size(); cont++) {
				System.out.println(pessoaListar.get(cont).toString());
			}

			System.out.println("-");
			System.out.println("**************");
		}
		menuPessoa();

	}
	public void menuAtualizar() {
		Pessoa pessoa = new Pessoa();
		System.out.println("**Atualização de Pessoa***");
		System.out.println("-");
		System.out.println("Informe o Username");
		pessoa.setNome(s.next());
		System.out.println("Informe o Telefone");
		pessoa.setTelefone(s.next());
		System.out.println("Informe o Email");
		pessoa.setEmail(s.next());
		
		System.out.println("-");

		if (!peControl.atualizar(pessoa)) {
			System.out.println("Pessoa nao encontrada");
		} else {
			System.out.println("Pessoa atualizada");
		}
		menuPessoa();
	}
	public void menuDeletar() {
		Pessoa pessoa = new Pessoa();

		System.out.println("**Exclusão de Pessoa***");
		System.out.println("-");
		System.out.println("Informe o Username");
		pessoa.setNome(s.next());
		System.out.println("-");

		if (!peControl.deletar(pessoa)) {
			System.out.println("Pessoa nao encontrada");
		} else {
			System.out.println("Pessoa excluida");
		}
		menuPessoa();
	}
}
