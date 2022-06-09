package view;

import controller.VeiculoController;
import model.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class VeiculoView {
    public void menuVeiculo() {
        Scanner ler = new Scanner(System.in);

        System.out.println("**** Menu Veiculo ****");
        System.out.println("-");
        System.out.println(" 1° Cadastrar ");
        System.out.println(" 2° Listar");
        System.out.println(" 3° Atualizar");
        System.out.println(" 4° Deletar");
        System.out.println(" 9° Voltar para o menu");
        System.out.println("-");
        System.out.println("***************");

        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                menuCadastrar();
                break;
            case 2:
                menuListar();
                break;
            case 3:
                menuVeiculo();
                break;
            case 4:
                break;
            case 9:
                MenuView menu = new MenuView();
                menu.menu();
                break;
            default:
                System.out.println("Opção invalida, escolha novamente!");
                menuVeiculo();
                break;
        }
    }

    public void menuCadastrar() {
        Scanner ler = new Scanner(System.in);

        Veiculo veiculo = new Veiculo();

        System.out.println("**** Cadastro Veiculo ****");
        System.out.println("-");
        System.out.println(" Informe o placa: ");
        veiculo.setPlaca(ler.next());
        System.out.println("Informe o marca: ");
        veiculo.setMarca(ler.next());
        System.out.println("Informe o ano: ");
        veiculo.setAno(Integer.parseInt(ler.next()));
        System.out.println("Informe o descrição: ");
        veiculo.setDescricao(ler.next());
        System.out.println("Informe o Tipo do Veiculo: ");
        veiculo.setTipoVeiculos(Integer.parseInt(ler.next()));
        System.out.println("-");
        System.out.println("* Cadastro Realizado! *");
        System.out.println("******************");

        VeiculoController veiculoController = new VeiculoController();
        System.out.println(veiculoController.cadastrar(veiculo));

        menuVeiculo();
    }

    public void menuListar() {

        VeiculoController veiculoController = new VeiculoController();
        ArrayList<Veiculo> veiculolist = veiculoController.listar();

        if (veiculolist.isEmpty()) {
            System.out.println("Não possui Veiculo cadastrado!");
        } else {

            System.out.println("**** LISTA DE VEICULO ****");
            System.out.println("-");
            for (int cont = 0; cont < veiculolist.size(); cont++) {
                System.out.println(veiculolist.get(cont).toString());
            }
            System.out.println("-");
            System.out.println("*************");
        }

        menuVeiculo();

    }

    public void menuAtualizar() {
        Scanner ler = new Scanner(System.in);

        Veiculo veiculo = new Veiculo();

        System.out.println("**** ATUALIZAÇÃO DE VEICULO ****");
        System.out.println("-");
        System.out.println(" Informe o descrição: ");
        veiculo.setDescricao(ler.next());
        System.out.println("Informe o tipo de veiculo: ");
        veiculo.setTipoVeiculos(Integer.parseInt(ler.next()));
        System.out.println(" Informe o Ano: ");
        veiculo.setAno(Integer.parseInt(ler.next()));
        System.out.println(" Informe o Marca: ");
        veiculo.setMarca(ler.next());
        System.out.println(" Informe o placa: ");
        veiculo.setPlaca(ler.next());
        System.out.println("-");

        VeiculoController userControl = new VeiculoController();

        if (!userControl.atualizar(veiculo)) {
            System.out.println("Usuario não encontrado!");
        } else {
            System.out.println("Cadastro de VEICULO atualizado!");
        }

        menuVeiculo();

    }

    public void menuDeletar() {
        Scanner ler = new Scanner(System.in);

        Veiculo veiculo = new Veiculo();

        System.out.println("**** EXCLUIR Veiculo ****");
        System.out.println("-");
        System.out.println(" Informe a placa: ");
        veiculo.setPlaca(ler.next());
        System.out.println("-");

        VeiculoController veiculoController = new VeiculoController();

        if (!veiculoController.deletar(veiculo)) {
            System.out.println("Veiculo não encontrado!");
        } else {
            System.out.println("Veiculo excluido!");

        }
        menuVeiculo();

    }
}
