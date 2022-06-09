package service;

import model.Veiculo;

import java.io.*;
import java.util.ArrayList;

public class VeiculoService {
    
    private final String veiculo_DB = "src/data_base/veiculo.txt";
    private FileReader arquivoLeitura;
    private BufferedReader memoriaLeitura;
    private File arquivo;
    private FileWriter escreverArquivo;
    private BufferedWriter memoriaEscrita;

    public VeiculoService(){
        try {
            arquivoLeitura = new FileReader(veiculo_DB);
            memoriaLeitura = new BufferedReader(arquivoLeitura);
            arquivo = new File(veiculo_DB);
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        }
    }

    public boolean escrever(Veiculo veiculo) {
        try {

            if (existeArquivo()){

                int contatorLinha = 0;
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    contatorLinha = contatorLinha +1;
                }

                contatorLinha = contatorLinha +1;

                String paraEscrever = contatorLinha + ";" + veiculo.getId() +  ";" + veiculo.getDescricao() + ";" + veiculo.getAno() 
                        + ";" + veiculo.getMarca() + ";" + veiculo.getPlaca();

                arquivo = new File(veiculo_DB);
                escreverArquivo = new FileWriter(arquivo, true);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                memoriaEscrita.write(paraEscrever);
                memoriaEscrita.newLine();

                memoriaEscrita.close();
                return true;
            } else {
                criarArquivo();
                escrever(veiculo);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }
        return false;
    }

    public boolean ler(Veiculo veiculo) {
        try {

            if (existeArquivo()){

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (veiculo.getDescricao().equals(linha_split[2])) {

                        return false;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }

        return false;
    }

    public ArrayList<Veiculo> ler() {
        ArrayList<Veiculo> listaVeiculo = new ArrayList<>();

        try {

            if (existeArquivo()) {
                //FileReader arquivoLeitura = new FileReader(veiculo_DB);
                //BufferedReader memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    Veiculo veiculo = new Veiculo();
                    veiculo.setId(Integer.parseInt(linha_split[0]));
                    veiculo.setDescricao(linha_split[1]);
                    veiculo.setMarca(linha_split[2]);
                    veiculo.setPlaca(linha_split[2]);


                    listaVeiculo.add(veiculo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }
        return listaVeiculo;

    }

    public boolean excluir(Veiculo veiculo) {
        Boolean excluiuVeiculo = false;

        try {

            if (existeArquivo()) {

                ArrayList<String> veiculoListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (veiculo.getDescricao().equals(linha_split[1])) {
                        veiculoListGravar.add(linha);
                    } else {
                        excluiuVeiculo = true;
                    }

                }

                arquivoLeitura.close();
                memoriaLeitura.close();

                arquivo = new File(veiculo_DB);
                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : veiculoListGravar) {
                    memoriaEscrita.write(novaLinha);
                    memoriaEscrita.newLine();
                }

                memoriaEscrita.close();

            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }

        return excluiuVeiculo;
    }

    public boolean atualizar(Veiculo veiculo) {
        Boolean atualizouVeiculo = false;

        try {

            if (existeArquivo()) {

                ArrayList<String> veiculoListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (veiculo.getDescricao().equals(linha_split[1])) {

                        String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + veiculo.getDescricao() + ";" + veiculo.getPlaca()
                                + ";" + veiculo.getMarca() + ";" + veiculo.getTipoVeiculos() + ";" + veiculo.getAno();
                        veiculoListGravar.add(novaLinha);
                        atualizouVeiculo = true;
                    } else {
                        veiculoListGravar.add(linha);
                    }

                }

                arquivoLeitura.close();
                memoriaLeitura.close();

                arquivo = new File(veiculo_DB);
                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : veiculoListGravar) {
                    memoriaEscrita.write(novaLinha);
                    memoriaEscrita.newLine();
                }

                memoriaEscrita.close();
            } else {

                return false;
            }

        }catch(FileNotFoundException e){
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }

        return atualizouVeiculo;

    }

    private boolean existeArquivo() {
        File arquivo = new File(veiculo_DB);
        return arquivo.exists();

    }

    private boolean criarArquivo() {

        try {
            File arquivo = new File(veiculo_DB);

            return arquivo.createNewFile();

        } catch (IOException e)  {
            System.out.println("Ocorreu um erro ao criar o arquivo de Veiculo.");
            System.out.println("O erro gerado é: " + e.getMessage());
            return false;
        }
    }
}
