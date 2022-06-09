package view;

import java.util.Scanner;

import Controller.PessoaController;
import Controller.UsuarioController;
import Controller.VeiculoController;

public abstract class ApplicationView {

	public UsuarioController userControl;
	public VeiculoController veicControl;
	public PessoaController pessControl;
	
	public Scanner leia;

	public ApplicationView() {

		userControl = new UsuarioController();
		pessControl = new PessoaController();
		veicControl = new VeiculoController();
		leia = new Scanner(System.in);

	}
}
