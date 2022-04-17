package view;
import model.Usuario;
import view.MenuUsuario;

public class LoginView {
	
	public void LoginView() {
	
	Usuario usuario = new Usuario();
	
	usuario.setUsername("Jonathan"); 
	usuario.setPassword("10a5a4f");
	
	System.out.println("*** Login ***");
	System.out.println("-");
	System.out.println("-");
	System.out.println("Digite o usuário");
	System.out.println(usuario.getUsername());
	System.out.println("-");
	System.out.println("-");
	System.out.println("Digite a senha");
	System.out.println(usuario.getPassword());
	System.out.println("-");
	System.out.println("-");
	System.out.println("Logado!" );
	System.out.println("***      ***");
	
	MenuUsuario menuview = new MenuUsuario();
	
	menuview.MenuView();
	
	}
}