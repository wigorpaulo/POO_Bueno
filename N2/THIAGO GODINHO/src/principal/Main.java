package principal;

import view.LoginView;

public class Main {

	public static void main(String[] args) {

		LoginView login = new LoginView();
		login.login();

		/*
		 * erros atuais se tirar a linha "arquivo" o ID fica travado no numero 1 o
		 * sistema nao esta criando um arquivo texto quando ele nao existe
		 * dando erro "o sistema nao pode encontrar o arquivo especificado"
		 * devido a versao do java, mas esta funcionando no meu notebook onde escrive
		 * o programa e acredito que mostrei a versao finalizada em sala pra voce
		 */
	}
}
