package aulaPrincipal;

import model.TipoEstaconamento;

public class Main {

	public static void main(String[] args) {
		
		TipoEstaconamento objeto = new TipoEstaconamento();
	
		objeto.setDecricao("Teste");
		
		System.out.println ("Identificação é:" +objeto.getDescricao());
	}

}
