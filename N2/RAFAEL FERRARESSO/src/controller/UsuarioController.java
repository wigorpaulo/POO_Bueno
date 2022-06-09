package controller;

import java.util.ArrayList;
import model.Usuario;

public class UsuarioController extends ApplicationController{
	
	public String cadastrar(Usuario user) {
		
		if (userService.ler(user)) {
			return "Usu�rio j� cadastrado";
		}else {
			
			
			if(userService.escrever(user)) {
				return "Usu�rio cadastrado com sucesso!";
			} else {
				return "Tente novamente!";
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
