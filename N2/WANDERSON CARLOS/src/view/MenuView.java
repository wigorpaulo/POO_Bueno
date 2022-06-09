package view;

import java.util.Scanner;

public class MenuView {

    public void menu() {

        Scanner leia = new Scanner(System.in);

        System.out.println("***  MENU  ***");
        System.out.println("-");
        System.out.println("- 1.Cadastro Usuario");
        System.out.println("- 2.Cadastro TipoVeiculo");
        System.out.println("- 3.Cadastro Veiculo");
        System.out.println("- 4.Cadastro Pessoa");
        System.out.println("- 5.Cadastro TipoEstacionamento");
        System.out.println("- 9.Sair!");

        int opcao = leia.nextInt();
        switch (opcao) {
            case 1:
                UsuarioView usuarioView = new UsuarioView();
                usuarioView.menuUsuario();
                break;

            case 2:

            case 8:
                System.out.println("Opcao nao disponivel");
                menu();
                break;

            case 3:
                VeiculoView veiculos = new VeiculoView();
                veiculos.menuVeiculo();
                break;

            case 4:
                PessoaView pessoaView = new PessoaView();
                pessoaView.menuPessoa();
                break;

            case 5:

                System.out.println("Opcao nao disponievel");
                    menu();
                break;

            case 9:

                System.out.println("Obrigado");
                System.out.println("-");
                System.out.println("-");
                System.exit(1);
                break;

            default:
                System.out.println("Opcao Invalida!");
                menu();
                break;
        }
    }
}
