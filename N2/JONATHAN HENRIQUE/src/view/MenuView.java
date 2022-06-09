package view;

import java.text.BreakIterator;
import java.util.Scanner;

public class MenuView {

    public void menu() {
        Scanner ler = new Scanner(System.in);

        System.out.println("****MENU****");
        System.out.println("-");
        System.out.println(" 1° Cadastrar Usuario");
        System.out.println(" 2° Cadastrar Tipo Veiculo");
        System.out.println(" 3° Cadastrar Veiculo");
        System.out.println(" 4° Cadastrar Tipo Estacionamento");
        System.out.println(" 5° Cadastrar Pessoa");
        System.out.println(" 9° SAIR");
        System.out.println("-");
        System.out.println("*************");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                UsuarioView userView = new UsuarioView();
                userView.menuUsuario();
                break;
            case 2:

                break;
            case 3:
                VeiculoView veiculoView = new VeiculoView();
                veiculoView.menuVeiculo();
                break;
            case 4:

                break;
            case 5:
                PessoaView pessoaView = new PessoaView();
                pessoaView.menuPessoa();
                break;
            case 9:
                System.out.println("Sistema encerrado!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida, escolha novamente!");
                menu();
                break;
        }


    }
}

