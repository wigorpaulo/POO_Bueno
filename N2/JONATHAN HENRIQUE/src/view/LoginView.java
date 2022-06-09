package view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class LoginView {

    public void login(){
        Scanner ler = new Scanner(System.in);

        System.out.println("****LOGIN****");
        System.out.println("-");
        System.out.println("* Informe o usuario: *");
        String username = ler.next();
        System.out.println("-");
        System.out.println("* Informe a senha: *");
        String password = ler.next();
        System.out.println("-");
        System.out.println("Logado com sucesso!");
        System.out.println("***************");

        MenuView menu = new MenuView();
        menu.menu();
    }
}
