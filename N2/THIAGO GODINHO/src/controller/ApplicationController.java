package controller;

import service.PessoaService;
import service.UsuarioService;
import service.VeiculoService;

public abstract class ApplicationController {
	public UsuarioService userService;
	public VeiculoService veService;
	public PessoaService peService;
	

	public ApplicationController() {

		userService = new UsuarioService();
		veService = new VeiculoService();
		peService = new PessoaService();
	}
}
