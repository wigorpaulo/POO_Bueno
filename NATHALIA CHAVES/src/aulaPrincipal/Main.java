package aulaPrincipal;

import model.TipoEstaconamento;

public class Main {

	public static void main(String[] args) {
		
		TipoEstaconamento objeto = new TipoEstaconamento();
	
		objeto.setDecricao("Teste");
		
		System.out.println ("Identifica��o �:" +objeto.getDescricao());
	}

}
