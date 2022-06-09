package view;

import model.TipoVeiculo;

import java.util.Scanner;

public class TipoVeiculoView {

    public void menuTipoVeiculo(TipoVeiculo tipoVeiculo) {

        System.out.println("*** MENU TIPO VEICULO ***");
        System.out.println("-1 Cadastrar");
        System.out.println("-2 Listar");
        System.out.println("-3 Atualizar");
        System.out.println("-4 Deletar");
        System.out.println("-9 Voltar para o menu");
        Scanner leia = new Scanner(System.in);

        int opcao = leia.nextInt();
        switch (opcao) {
            case 1:
                cadastroTipoVeiculo();
                break;
            case 2:
                listaTipoVeiculo(tipoVeiculo);
                break;
            case 9:
                MenuView menuView = new MenuView();
                menuView.menu();
                break;
            default:
                System.out.println("opcao invalida");
                menuTipoVeiculo(tipoVeiculo);
                break;

        }
    }

    public void cadastroTipoVeiculo() {

        TipoVeiculo tipoVeiculos = new TipoVeiculo();

        Scanner leia = new Scanner(System.in);
        System.out.println("*** Cadastro do Tipo Veiculo ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe a Identificacao");
        tipoVeiculos.setNome(leia.nextInt());
        System.out.println("Informe a Descricao");
        tipoVeiculos.setDescricao(leia.next());
        System.out.println("-");
        System.out.println("-");
        System.out.println("TipoVeiculo cadastrado!");
        menuTipoVeiculo(tipoVeiculos);
    }

    public void listaTipoVeiculo(TipoVeiculo tipoVeiculo) {

        System.out.println("*** Lista de TipoVeiculos ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("-Nome: " + tipoVeiculo.getNome());
        System.out.println("-Descricao: " + tipoVeiculo.getDescricao());
        System.out.println("*******");
        System.out.println("");
        System.out.println("");
        menuTipoVeiculo(null);

    }

}
