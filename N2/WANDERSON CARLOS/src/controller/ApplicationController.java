package controller;

import service.PessoaService;
import service.UsuarioService;
import service.VeiculoService;

public abstract class ApplicationController {
    public UsuarioService userService;
    public VeiculoService veiService;
    public PessoaService pesService;


    public ApplicationController() {

        userService = new UsuarioService();
        veiService = new VeiculoService();
        pesService = new PessoaService();
    }
}
