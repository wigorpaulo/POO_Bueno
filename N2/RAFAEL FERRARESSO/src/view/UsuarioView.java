package view;
 
import java.util.ArrayList;
import model.Usuario;

public class UsuarioView extends ApplicationView implements IApplicationView{
	
	public void menuCadastrar() {
		Usuario user = new Usuario();
		
		System.out.println("********CADASTRO*********");
		System.out.println("-");
		System.out.println("-Informe o username:");
		user.setUsername(scan.next()); 		
		System.out.println("-Informe a password:");
		user.setPassword(scan.next());
		
		System.out.println(userControl.cadastrar(user));
		
		menuUsuario();
		
	}
	
	
	public void menuListar() {
		
		ArrayList<Usuario> userList = userControl.listar();
		
		if(userList.isEmpty()) {
		System.out.println("Não possui usuário cadastrado!");
		} else {

			System.out.println("*** LISTA DE USUÁRIO ***");
			System.out.println("-");
			for(int cont = 0; cont < userList.size(); cont++) {
				System.out.println(userList.get(cont).toString());
			}
			System.out.println("-");
			System.out.println("-");;
			System.out.println("************************");
		}
		menuUsuario();
	}
	
	public void menuUsuario() {
		System.out.println("******Menu Usuário*******");
		System.out.println("-");
		System.out.println("-1 - Cadastrar");
		System.out.println("-2 - Listar");
		System.out.println("-3 - Atualizar");
		System.out.println("-4 - Deletar");
		System.out.println("-");
		System.out.println("-9 - VOLTAR PARA O MENU");
		
		switch(scan.nextInt()) {
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
			System.out.println("Opção inválida");
			menuUsuario();
		}
	}
	
	public void menuAtualizar() {
		Usuario user = new Usuario();
		
		System.out.println("*** ATUALIZAÇÃO DE USUÁRIO ***");
		System.out.println("-");
		System.out.println("-Informe o username:");
		user.setUsername(scan.next());	
		System.out.println("Informe a password:");
		user.setPassword(scan.next());

		
		if(!userControl.atualizar(user)) {
			System.out.println("Usuário não encontrado!");
		} else {
			System.out.println("Cadastro de usuário atualizado com sucesso!");
		}
		menuUsuario();
	}
	
	public void menuDeletar() {
		Usuario user = new Usuario();
		
		System.out.println("*** EXCLUSÃO DE USUÁRIO ***");
		System.out.println("-");
		System.out.println("-Informe o username:");
		user.setUsername(scan.next());
		
		if(!userControl.deletar(user)) {
			System.out.println("Usuário não encontrado!");
		} else {
			System.out.println("Cadastro do usuário excluido com sucesso!");
		}
		menuUsuario();
	}

}
