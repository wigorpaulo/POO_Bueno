package Controller;

import java.util.ArrayList;

import model.Usuario;
import model.Veiculo;


public class UsuarioController extends ApplicationController {

	public String cadastrar(Usuario usuario) {
		// INSTANCIAR UsuarioService

		if (userService.ler(usuario)) {
			return ("Usu�rio j� est� cadastrado.");
		} else {
			// escreve no arquivo
			if (userService.escrever(usuario)) {
				return "Usu�rio cadastrado com sucesso!";
			} else {
				return "Teste novamente!";
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