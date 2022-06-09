package controller;

import service.UsuarioService;

public class aplicationController {
	
	public UsuarioService userService ;
	
	public aplicationController () {
		userService = new UsuarioService();
	}

}
