package view;

import model.TipoEstacionamento;

import java.util.Scanner;

public class TipoEstacionamentoView {

    public void menuTipoEstacionamento(TipoEstacionamento tipoEstacionamento) {

        System.out.println("*** MENU TipoEstacionamento ***");
        System.out.println("-1 Cadastrar");
        System.out.println("-2 Listar");
        System.out.println("-3 Atualizar");
        System.out.println("-4 Deletar");
        System.out.println("-9 Voltar para o menu");
        Scanner leia = new Scanner(System.in);

        int opcao = leia.nextInt();
        switch (opcao) {
            case 1:
                cadastroTipoEstacionamento();
                break;
            case 2:
                listaTipoEstacionamento(tipoEstacionamento);
                break;
            case 9:
                MenuView menuView = new MenuView();
                menuView.menu();
                break;
            default:
                System.out.println("opcao invalida");
                menuTipoEstacionamento(tipoEstacionamento);
                break;

        }
    }
    public void cadastroTipoEstacionamento() {
        TipoEstacionamento estacionamentos = new TipoEstacionamento();

        Scanner leia = new Scanner(System.in);
        System.out.println("*** Cadastro de Veiculo ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe a Identificacao");
        estacionamentos.setId(leia.nextInt());
        System.out.println("Informe a Descricao");
        estacionamentos.setDescricao(leia.next());
        System.out.println("-");
        System.out.println("-");
        System.out.println("TipoEstacionamento cadastrado!");
        menuTipoEstacionamento(estacionamentos);
    }


    public void listaTipoEstacionamento(TipoEstacionamento estacionamentos) {
        System.out.println("*** Lista de TipoEstacionamentos ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("-Id: " + estacionamentos.getId());
        System.out.println("-Descricao: " +estacionamentos.getDescricao());
        System.out.println("****");
        System.out.println("");
        System.out.println("");
        menuTipoEstacionamento(null);

    }
}
