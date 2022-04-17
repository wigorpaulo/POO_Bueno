package view;
import model.Usuario;
import view.MenuUsuario;

public class LoginView {
	
	public void LoginView() {
	
	Usuario usuario = new Usuario();
	
	usuario.setUsername("Arthur_Coutinho"); 
	usuario.setPassword("10255010");
	
	System.out.println("*** Login ***");
	System.out.println("-");
	System.out.println("-");
	System.out.println("Informe o usuário");
	System.out.println(usuario.getUsername());
	System.out.println("-");
	System.out.println("-");
	System.out.println("Informe a senha");
	System.out.println(usuario.getPassword());
	System.out.println("-");
	System.out.println("-");
	System.out.println("Logado com sucesso" );
	System.out.println("***      ***");
	
	MenuUsuario menuview = new MenuUsuario();
	
	menuview.MenuView();
	
	}
}