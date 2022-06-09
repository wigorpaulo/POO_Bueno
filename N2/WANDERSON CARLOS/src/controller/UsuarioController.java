package controller;

import model.Usuario;

import java.util.ArrayList;

public class UsuarioController extends ApplicationController {
    public String cadastrar(Usuario usuario) {

        if (userService.ler(usuario)) {
            return "Usuario está já cadastrado";
        } else {
            if (userService.escrever(usuario)) {
                return "Usuario cadastrado com sucesso";
            } else {
                return "Favor tente novamente";
            }
        }
    }

    public ArrayList<Usuario> listar() {
        return userService.ler();

    }

    public Boolean atualizar(Usuario usuario) {
        return userService.atualizar(usuario);
    }

    public Boolean deletar(Usuario usuario) {
        return userService.excluir(usuario);
    }

}
