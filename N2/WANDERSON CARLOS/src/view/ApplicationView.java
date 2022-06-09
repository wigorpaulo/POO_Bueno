package view;

import controller.PessoaController;
import controller.UsuarioController;
import controller.VeiculoController;

import java.util.Scanner;

public abstract class ApplicationView {
    UsuarioController usuaControl;
    VeiculoController veiControl;
    PessoaController pesControl;
    Scanner leia;

    public ApplicationView() {
        usuaControl = new UsuarioController();
        veiControl = new VeiculoController();
        pesControl = new PessoaController();
        leia = new Scanner(System.in);
    }
}

