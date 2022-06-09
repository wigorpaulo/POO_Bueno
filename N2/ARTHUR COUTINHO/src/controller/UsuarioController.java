package controller;

import java.util.ArrayList;

import model.Usuario;
import service.UsuarioService;

public class UsuarioController extends aplicationController{
	
	public String cadastrar(Usuario user) {
		
		UsuarioService userService = new UsuarioService();
		Boolean retornar = userService.ler(user);
			
		if (userService.ler(user)) {
			System.out.println("Usuário ja cadastrado!");
		}
		else {
			if (userService.escrever(user)) {
			System.out.println("Usuário cadastrado com sucesso!");
		} 	else { System.out.println("Tente novamente!");
	
		}
	}
		return null;
		
}		
	
	public ArrayList<Usuario> listar() {
		UsuarioService userService = new UsuarioService();
		return userService.ler();
	}
	
	public Boolean atualizar(Usuario user) {
		UsuarioService userService = new UsuarioService();
		return userService.atualizar(user);
	}
	
	
	public Boolean deletar(Usuario user){
		
		UsuarioService userService = new UsuarioService();
		
		return userService.excluir(user);
		
	}
	

}
