package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Usuario;
import model.Veiculo;

public class VeiculoView extends ApplicationView {
	
	public void veiculomenu(Veiculo veiculo){
		Scanner ler = new Scanner (System.in);
		
		System.out.println("***MENU VEICULO***");
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
		cadastrar(veiculo);

	} else if (opcao == 2) {
		listar(null);
		
	} else if (opcao == 3) {
		atualizar();
		
	} else if (opcao == 4) {
		deletar();
	}
}
	
public void cadastrar(Veiculo veiculo) {
	
	Veiculo veiculo1 = new Veiculo();
	
			System.out.println("****Cadastro Veiculo****");
			System.out.println("-");
			System.out.println("Informe a descrição");
			veiculo1.setDescricao(ler.next());
			System.out.println("Informe sua Placa");
			veiculo1.setPlaca(ler.next());
			System.out.println("Informe a Marca");
			veiculo1.setMarca(ler.next());
			System.out.println("Informe o Ano");
			veiculo1.setAno(ler.next());
			System.out.println("Informe o tipo do veiculo:");
			veiculo1.setTipoveiculo(ler.next());
			System.out.println("-");
			System.out.println("Cadastro Realizado!!!");
			System.out.println("********************");
			
			System.out.println(veiculoCont.cadastrar(veiculo1)); 
			
			veiculomenu(null);
		
	}

public void listar(Veiculo veiculo) {
    ArrayList<Veiculo> veiculoList = veiculoCont.listar(); 
	
	if (veiculoList.isEmpty()){
		
	} else {
		System.out.println("***Lista de Usuario***");
		System.out.println("-");
		for(int cont = 0; cont < veiculoList.size(); cont++) {
		System.out.println(veiculoList.get(cont).toString());
		}
	    System.out.println("-");
	    System.out.println("*****************************");
	}

    veiculomenu(veiculo);
}

public void atualizar() {
	Veiculo veiculo = new Veiculo();
	
	System.out.println("****Atualizar Veiculo****");
	System.out.println("Informe a descrição");
	veiculo.setDescricao(ler.next());
	System.out.println("Informe sua Placa");
	veiculo.setPlaca(ler.next());
	System.out.println("Informe a Marca");
	veiculo.setMarca(ler.next());
	System.out.println("Informe o Ano");
	veiculo.setAno(ler.next());
	System.out.println("Informe o tipo do veiculo:");
	veiculo.setTipoveiculo(ler.next());
	System.out.println("-");
	
	if (!veiculoCont.atualizar(veiculo)) {
		
		System.out.println("Usuario não encontrado");
		
	} else {
		System.out.println("Usuario Atualizado!");
	}
	
	/* Executar o metodo: menuUsuario() */
	veiculomenu(null);
}

public void deletar() {
	
	/* CRIAR UMA INSTANCIA DE USUARIO*/
	Veiculo veiculo = new Veiculo();
	
	/* SETAR AS INFORMAÇÕES PARA USUARIO*/
	System.out.println("****Deletar****");
	System.out.println("-");
	System.out.println("Informe a placa:");
	veiculo.setPlaca(ler.next()); 
	System.out.println("-"); // setar as informações ao objeto
	
	if(!veiculoCont.deletar(veiculo)){ // executar o metodo: deletar()
		System.out.println("Usuario não encontrado!");
	} else {
		System.out.println("Usuario Excluido!");
	}
	/* Executar o metodo: menuUsuario() */
	veiculomenu(null);
  }
}


