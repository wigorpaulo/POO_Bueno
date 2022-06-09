package view;

import java.util.Scanner;

public class LoginView {

    public void login() {

        Scanner leia = new Scanner(System.in);

        System.out.println("***  Login  ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe seu usuario:");
        String usuario = leia.next();
        System.out.println("Informe sua senha:");
        String senha = leia.next();
        System.out.println("-");
        System.out.println("- Logado com sucesso! ");
        System.out.println("***             ***");

        MenuView menuGeral = new MenuView();
        menuGeral.menu();

    }

}
