package service;

import model.Veiculo;

import java.io.*;
import java.util.ArrayList;

public class VeiculoService {
    private final String DIR_VEICULO = "src/data_base/veiculo.txt";
    private FileReader arquivoLeitura;
    private BufferedReader memoriaLeitura;
    private File arquivo;
    private FileWriter escreverArquivo;
    private BufferedWriter memoriaEscrita;

    public VeiculoService() {
        try {
            arquivoLeitura = new FileReader(DIR_VEICULO);
            memoriaLeitura = new BufferedReader(arquivoLeitura);
            arquivo = new File(DIR_VEICULO);
        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro Construtor VeiculoService");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro Construtor VeiculoService");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
    }

    public Boolean escrever(Veiculo veiculo) {
        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_VEICULO);
                memoriaLeitura = new BufferedReader(arquivoLeitura);
                int cont = 0;
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    cont = cont + 1;

                }

                cont = cont + 1;
                String dadoParaEscrever = cont + ";" + veiculo.getPlaca() + ";" + veiculo.getMarca() + ";"
                        + veiculo.getAno();

                escreverArquivo = new FileWriter(arquivo, true);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                memoriaEscrita.write(dadoParaEscrever);
                memoriaEscrita.newLine();
                memoriaEscrita.close();
                return true;
            } else {
                criaArquivo();
                escrever(veiculo);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao escrever");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao escrever");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Ocoreu um erro ao escrever");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
        return false;

    }

    public Boolean ler(Veiculo veiculo) {
        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_VEICULO);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (veiculo.getPlaca().equals(linha_split[1])) {
                        return true;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao ler");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao ler");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Veiculo> ler() {
        ArrayList<Veiculo> listVeiculo = new ArrayList<>();
        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_VEICULO);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");
                    Veiculo veiculo = new Veiculo();
                    veiculo.setId(Integer.parseInt(linha_split[0]));
                    veiculo.setPlaca(linha_split[1]);
                    veiculo.setMarca(linha_split[2]);
                    veiculo.setAno(linha_split[3]);

                    listVeiculo.add(veiculo);

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao ler o arquivo array");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao ler o arquivo array");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
        return listVeiculo;
    }

    public Boolean excluir(Veiculo veiculo) {
        Boolean excluiVeiculo = false;

        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_VEICULO);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                ArrayList<String> veicListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (!veiculo.getPlaca().equals(linha_split[1])) {
                        veicListGravar.add(linha);
                    } else {
                        excluiVeiculo = true;
                    }

                }
                arquivoLeitura.close();
                memoriaLeitura.close();

                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : veicListGravar) {
                    memoriaEscrita.write(novaLinha);
                    memoriaEscrita.newLine();
                }

                memoriaEscrita.close();

            } else {
                return false;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro");
            System.out.println("Erro gerado: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro");
            System.out.println("Erro gerado: " + e.getMessage());

        }
        return excluiVeiculo;
    }

    public Boolean atualizar(Veiculo veiculo) {
        Boolean atualizouVeiculo = false;
        try {

            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_VEICULO);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                ArrayList<String> veicListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (veiculo.getPlaca().equals(linha_split[1])) {
                        String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + veiculo.getMarca() + ";"
                                + veiculo.getAno();
                        veicListGravar.add(novaLinha);
                        atualizouVeiculo = true;
                    } else {
                        veicListGravar.add(linha);
                    }

                }
                arquivoLeitura.close();
                memoriaLeitura.close();

                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : veicListGravar) {
                    memoriaEscrita.write(novaLinha);
                    memoriaEscrita.newLine();
                }

                memoriaEscrita.close();

            } else {
                return false;
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao excluir");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao excluir");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
        return atualizouVeiculo;
    }

    private Boolean existiArquivo() {
        return arquivo.exists();
    }

    private Boolean criaArquivo() {
        try {
            return arquivo.createNewFile();

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao criar o arquivo");
            System.out.println("Erro gerado: " + e.getMessage());
            return false;
        }

    }
}
