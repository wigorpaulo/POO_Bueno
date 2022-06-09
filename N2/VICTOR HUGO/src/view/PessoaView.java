package view;

import java.util.ArrayList;
import model.Pessoa;

public class PessoaView extends ApplicationView {
	
	public void pessoaview (Pessoa pessoa){
		
		System.out.println("***MENU PESSOA***");
		System.out.println("-");
		System.out.println("1- Cadastrar");
		System.out.println("2- Listar");
		System.out.println("3- Atualizar");
		System.out.println("4- Deletar");
		System.out.println("9- Voltar para o Menu");
		System.out.println("-");
		System.out.println("-");
		System.out.println("Aguardando a opção desejada");
		int opcao = ler.nextInt();
		System.out.println("********************");
		
		if (opcao == 9) {
			MenuView menu = new MenuView();
			menu.menu();
			
	} else if (opcao==1) {
		cadastrar();

	} else if (opcao == 2) {
		 listar(pessoa);
	}  else if (opcao == 3) {
		atualizar();
		
	} else if (opcao == 4) {
		deletar();
	}
		
	}
	public void cadastrar() {
		Pessoa pessoa = new Pessoa();
		
		System.out.println("****Cadastro de Pessoa****");
		System.out.println("-");
		System.out.println("Informe seu Nome:");
		pessoa.setNome(ler.next());
		System.out.println("Informe seu Telefone:");
		pessoa.setTelefone(ler.next());
		System.out.println("Informe sua E-mail:");
		pessoa.setEmail(ler.next());
		System.out.println("-");
		System.out.println("Cadastro Realizado!!!");
		System.out.println("********************");
		
		System.out.println(pessoaCont.cadastrar(pessoa)); 
		pessoaview(pessoa);
		
	}
	public void listar(Pessoa pessoa) {
		ArrayList<Pessoa> pessoaList = pessoaCont.listar();
		
		//SE O RETORNO DO METODO LISTAR() FOR VAZIO
		if (pessoaList.isEmpty()){
			
		} else {

		System.out.println("***Lista Pessoa***");
	    System.out.println("-");
	    for(int cont = 0; cont < pessoaList.size(); cont++) {
			System.out.println(pessoaList.get(cont).toString());
			}
	    System.out.println("-");
	    System.out.println("*****************************");

	pessoaview(null);
	}
	}
	public void atualizar() {
		Pessoa pessoa = new Pessoa();
		
		System.out.println("****Atualizar Pessoa****");
		System.out.println("-");
		System.out.println("Informe seu Nome:");
		pessoa.setNome(ler.next());
		System.out.println("Informe seu Telefone:");
		pessoa.setTelefone(ler.next());
		System.out.println("Informe sua E-mail:");
		pessoa.setEmail(ler.next());
		System.out.println("-");
		
		if (!pessoaCont.atualizar(pessoa)) {
			
			System.out.println("Usuario não encontrado");
			
		} else {
			System.out.println("Usuario Atualizado!");
		}
		pessoaview(null);
	}

	public void deletar() {
		Pessoa pessoa = new Pessoa();
		
		System.out.println("****Deletar****");
		System.out.println("-");
		System.out.println("Informe seu Nome:");
		pessoa.setNome(ler.next());
		System.out.println("Informe seu Telefone:");
		pessoa.setTelefone(ler.next());
		System.out.println("Informe sua E-mail:");
		pessoa.setEmail(ler.next());
		System.out.println("-"); 
		
		if(!pessoaCont.deletar(pessoa)){ 
			System.out.println("Usuario não encontrado!");
		} else {
			System.out.println("Usuario Excluido!");
		}
		pessoaview(null);
	  }
		
	}

	


