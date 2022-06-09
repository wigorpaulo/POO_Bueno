package view;

import java.util.Scanner;

import controller.PessoaController;
import controller.UsuarioController;
import controller.VeiculoController;

public abstract class ApplicationView {
	UsuarioController userControl ;
	VeiculoController veControl;
	PessoaController peControl;
	Scanner s;
	
	public ApplicationView() {
		userControl = new UsuarioController();
		veControl = new VeiculoController();
		peControl = new PessoaController();
		s = new Scanner(System.in);
	}
}
