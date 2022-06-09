package controller;

import service.UsuarioService;

public abstract class ApplicationController {
	/*ATRIBUTOS*/
	public UsuarioService userService;
	
	public ApplicationController() {
	userService = new UsuarioService();
	}
}
