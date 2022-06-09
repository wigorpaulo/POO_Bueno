package view;

import model.Veiculo;

import java.util.ArrayList;

public class VeiculoView extends ApplicationView implements IApplicationView {

    public void menuVeiculo() {

        System.out.println("*** MENU VEICULO ***");
        System.out.println("-1 Cadastrar");
        System.out.println("-2 Listar");
        System.out.println("-3 Atualizar");
        System.out.println("-4 Deletar");
        System.out.println("-9 Voltar para o menu");

        int opcao = leia.nextInt();
        switch (opcao) {
            case 1:
                menuCadastro();
                break;
            case 2:
                menuListar();
                break;
            case 3:
                menuAtualizar();
                break;
            case 4:
                menuDeletar();
                break;
            case 9:
                MenuView menuView = new MenuView();
                menuView.menu();
                break;

        }
    }

    @Override
    public void menuCadastro() {
        Veiculo veiculo = new Veiculo();

        System.out.println("*** Cadastro de Veiculo ***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe a Placa: ");
        veiculo.setPlaca(leia.next());
        System.out.println("Informe a Marca: ");
        veiculo.setMarca(leia.next());
        System.out.println("Informe o Ano: ");
        veiculo.setAno(leia.next());
        System.out.println("-");
        System.out.println("-");

        System.out.println(veiControl.cadastrar(veiculo));
        menuVeiculo();

    }

    @Override
    public void menuListar() {
        ArrayList<Veiculo> veicList = veiControl.listar();

        if (veicList.isEmpty()) {
            System.out.println("Nao possui veiculo cadastrado");
        } else {
            System.out.println("**Lista de Veiculo***");
            System.out.println("-");
            System.out.println("-");

            for (int cont = 0; cont < veicList.size(); cont++) {
                System.out.println(veicList.get(cont).toString());
            }

            System.out.println("-");
            System.out.println("************");
        }
        menuVeiculo();
    }


    @Override
    public void menuAtualizar() {
        Veiculo veiculo = new Veiculo();
        System.out.println("*** Atualizar Veiculo***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe a Placa");
        veiculo.setPlaca(leia.next());
        System.out.println("Informe a Marca");
        veiculo.setMarca(leia.next());
        System.out.println("Informe o Ano");
        veiculo.setAno(leia.next());
        System.out.println("-");
        System.out.println("-");

        if (!veiControl.atualizar(veiculo)) {
            System.out.println("Veiculo nao encontrado!");
        } else {
            System.out.println("veiculo atualizado!!!");
        }

        menuVeiculo();
    }


    @Override
    public void menuDeletar() {
        Veiculo veiculo = new Veiculo();

        System.out.println("*** Exclusao de Veiculo***");
        System.out.println("-");
        System.out.println("-");
        System.out.println("Informe a Placa");
        veiculo.setPlaca(leia.next());
        System.out.println("-");
        System.out.println("-");

        if (!veiControl.deletar(veiculo)) {
            System.out.println("Veiculo nao encontrado");
        } else {
            System.out.println("Veiculo excluido com sucesso!");
        }

        menuVeiculo();
    }
}
