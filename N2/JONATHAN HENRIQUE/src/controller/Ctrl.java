package controller;

import service.UsuarioService;

public abstract class Ctrl {

    public UsuarioService userService;

    public Ctrl (){
        userService = new UsuarioService();

    }
}
