package view;

import java.util.ArrayList;
import model.Usuario;

public class UsuarioView extends ApplicationView implements IApplicationView {
	
	public void menuUsuario(Usuario user){
		
		System.out.println("***MENU USUARIO***");
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
		 listar();
		 
	} else if (opcao == 3) {
		atualizar();
		
	} else if (opcao == 4) {
		deletar();
	}
}

public void cadastrar() {
	
	/* criar uma INSTANCIA DE USUARIO */
	Usuario user = new Usuario();
	
	System.out.println("****Cadastro Usuario****");
	System.out.println("-");
	System.out.println("Informe seu Username:");
	user.setUsername(ler.next());
	System.out.println("Informe sua Senha:");
	user.setPassword(ler.next());
	System.out.println("-");
	System.out.println("********************");
	
	System.out.println(userCont.cadastrar(user)); 
	
	menuUsuario(user);
}

public void listar() {
	ArrayList<Usuario> userList = userCont.listar(); // EXECUTAR O METODO: listar(
	
	//SE O RETORNO DO METODO LISTAR() FOR VAZIO
	if (userList.isEmpty()){
		
	} else {
		// SE POSSUI REGISTRO, MOSTRA AS INFORMAÇÕES DO USUARIO
		//CHAMAR O METODO DO USUARIO: toString()
		System.out.println("***Lista de Usuario***");
		System.out.println("-");
		for(int cont = 0; cont < userList.size(); cont++) {
		System.out.println(userList.get(cont).toString());
		}
	    System.out.println("-");
	    System.out.println("*****************************");
	}
	
	/* Executar o metodo: menuUsuario() */
	menuUsuario(null);
}

public void atualizar() {
	Usuario user = new Usuario();
	
	System.out.println("****Atualizar Usuario****");
	System.out.println("-");
	System.out.println("Informe seu Username:");
	user.setUsername(ler.next());
	System.out.println("Informe sua Senha:");
	user.setPassword(ler.next());
	System.out.println("-");
	
	if (!userCont.atualizar(user)) {
		
		System.out.println("Usuario não encontrado");
		
	} else {
		System.out.println("Usuario Atualizado!");
	}
	
	/* Executar o metodo: menuUsuario() */
	menuUsuario(null);
}

public void deletar() {
	
	/* CRIAR UMA INSTANCIA DE USUARIO*/
	Usuario user = new Usuario();
	
	/* SETAR AS INFORMAÇÕES PARA USUARIO*/
	System.out.println("****Deletar****");
	System.out.println("-");
	System.out.println("Informe seu Username:");
	user.setUsername(ler.next()); 
	System.out.println("-"); // setar as informações ao objeto
	
	if(!userCont.deletar(user)){ // executar o metodo: deletar()
		System.out.println("Usuario não encontrado!");
	} else {
		System.out.println("Usuario Excluido!");
	}
	/* Executar o metodo: menuUsuario() */
	menuUsuario(null);
  }
}
