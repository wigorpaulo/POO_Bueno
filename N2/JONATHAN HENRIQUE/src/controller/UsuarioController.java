package controller;

import model.Usuario;
import service.UsuarioService;

import java.util.ArrayList;

public class UsuarioController extends Ctrl {

    public String cadastrar(Usuario user) {

        if (userService.ler(user)){
            return "Usuario já cadastrado!";
        } else {
            if (userService.escrever(user)) {
                return "Usuario cadastrado com sucesso!";
            } else {
                return "tente novamente";
            }
        }
    }

    public ArrayList<Usuario> listar() {

        return userService.ler();


    }
    public boolean atualizar(Usuario user) {

        return userService.atualizar(user);

    }
    public boolean deletar(Usuario user) {

        return userService.excluir(user);

    }
}

