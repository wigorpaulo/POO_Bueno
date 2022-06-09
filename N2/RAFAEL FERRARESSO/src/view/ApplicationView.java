package view;

import java.util.Scanner;

import controller.UsuarioController;
import service.UsuarioService;

public abstract class ApplicationView {
	
	public UsuarioController userControl;
	public Scanner scan;
	
	public ApplicationView() {
	userControl = new UsuarioController();
	scan = new Scanner(System.in);
	}
}