package view;
import model.Usuario;
import view.MenuUsuario;

public class LoginView {
	
	public void LoginView() {
	
	Usuario usuario = new Usuario();
	
	usuario.setUsername("VitorLopes"); 
	usuario.setPassword("3108");
	
	System.out.println("*** Login ***");
	System.out.println("-");
	System.out.println("-");
	System.out.println("Informe o usu�rio");
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
