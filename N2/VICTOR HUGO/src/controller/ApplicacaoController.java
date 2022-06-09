package controller;

import service.PessoaService;
import service.UsuarioService;
import service.VeiculoService;

public abstract class ApplicacaoController {
	
	/*ATRIBUTOs*/
	public UsuarioService userService; 
	public PessoaService pessoaService;
	public VeiculoService veiculoService;
	
	public ApplicacaoController() {
		
		/* criar uma INSTANCIA DE USUARIOService */
		userService = new UsuarioService();
		pessoaService = new PessoaService();
		veiculoService = new VeiculoService();
	}

}
