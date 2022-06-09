package controller;

import java.util.ArrayList;
import model.Usuario;

public class UsuarioController extends ApplicacaoController {
	
	public String cadastrar(Usuario user) {
		 
		if (userService.ler(user)) {
			return "Usuario j� cadastrado";
					
		} else {
		
		if (userService.escrever(user)) {
			return "Usuario cadastrado com sucesso!";
		} else {
			return"Tente novamente!";
		}
		}
	}


	public ArrayList<Usuario> listar() {
		return userService.ler();
	}
	
	public Boolean atualizar(Usuario user) {
		return userService.atualizar(user); 
	}
	
	public Boolean deletar(Usuario user) {
		return userService.excluir(user);
		 
	}
}

