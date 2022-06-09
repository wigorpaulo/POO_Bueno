package view;

import java.util.Scanner;
import controller.PessoaController;
import controller.UsuarioController;
import controller.VeiculoController;

public abstract class ApplicationView {
	/*CRIAR UMA INSTANCIA DE USUARIOCONTROLLER  */
	public UsuarioController userCont;
	public Scanner ler;
	public PessoaController pessoaCont;
	public VeiculoController veiculoCont;

	
	public ApplicationView () {
		
		/* criar uma INSTANCIA DE USUARIOcontroller */
		userCont = new UsuarioController();
		pessoaCont = new PessoaController();
		veiculoCont = new VeiculoController();
		ler = new Scanner (System.in);

	}
}
