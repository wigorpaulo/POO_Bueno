package Controller;

import Service.PessoaService;
import Service.UsuarioService;
import Service.VeiculoService;

public abstract class ApplicationController {

	public UsuarioService userService;
	public VeiculoService veicService; 
	public PessoaService pessService;

	public ApplicationController() {

		userService = new UsuarioService();
		veicService = new VeiculoService();
		pessService = new PessoaService();
		
	}

}
