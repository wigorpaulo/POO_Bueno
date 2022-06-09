package service;

import model.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class PessoaService {

    private final String DIR_USER = "src/data_base/pessoa.txt";
    private FileReader arquivoLeitura;
    private BufferedReader memoriaLeitura;
    private File arquivo;
    private FileWriter escreverArquivo;
    private BufferedWriter memoriaEscrita;

    public PessoaService() {
        try {
            arquivoLeitura = new FileReader(DIR_USER);
            memoriaLeitura = new BufferedReader(arquivoLeitura);
            arquivo = new File(DIR_USER);
        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro Construtor PessoaService");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro Construtor PessoaService");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
    }

    public Boolean escreve(Pessoa pessoa) {
        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);
                int cont = 0;

                String linha = null;

                while ((linha = memoriaLeitura.readLine()) != null) {

                    cont = cont + 1;

                }

                cont = cont + 1;
                String dadoParaEscrever = cont + ";" + pessoa.getNome() + ";" + pessoa.getTelefone() + ";"
                        + pessoa.getEmail();

                escreverArquivo = new FileWriter(arquivo, true);

                memoriaEscrita = new BufferedWriter(escreverArquivo);

                memoriaEscrita.write(dadoParaEscrever);
                memoriaEscrita.newLine();
                memoriaEscrita.close();
                return true;

            } else {
                criaArquivo();
                escreve(pessoa);
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

    public Boolean ler(Pessoa pessoa) {
        try {
            if (existiArquivo()) {

                arquivoLeitura = new FileReader(DIR_USER);

                memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;

                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (pessoa.getNome().equals(linha_split[1])) {
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

    public ArrayList<Pessoa> ler() {

        ArrayList<Pessoa> listPessoa = new ArrayList<>();

        try {
            if (existiArquivo()) {

                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;

                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");
                    Pessoa usuario = new Pessoa();
                    usuario.setId(Integer.parseInt(linha_split[0]));
                    usuario.setNome(linha_split[1]);
                    usuario.setTelefone(linha_split[2]);
                    usuario.setEmail(linha_split[3]);
                    listPessoa.add(usuario);

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao ler o arquivo array");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao ler o arquivo array");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
        return listPessoa;
    }

    public Boolean excluir(Pessoa usuario) {
        Boolean excluiPessoa = false;

        try {
            if (existiArquivo()) {

                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                ArrayList<String> pessoaListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (!usuario.getNome().equals(linha_split[1])) {
                        pessoaListGravar.add(linha);
                    } else {
                        excluiPessoa = true;
                    }

                }
                arquivoLeitura.close();
                memoriaLeitura.close();

                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : pessoaListGravar) {
                    memoriaEscrita.write(novaLinha);
                    memoriaEscrita.newLine();
                }

                memoriaEscrita.close();

            } else {
                return false;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao excluir");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao excluir");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
        return excluiPessoa;
    }

    public Boolean atualizar(Pessoa pessoa) {
        Boolean atualizouPessoa = false;
        try {

            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                ArrayList<String> pessoaListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (pessoa.getNome().equals(linha_split[1])) {
                        String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + pessoa.getTelefone() + ";" + pessoa.getEmail();
                        pessoaListGravar.add(novaLinha);
                        atualizouPessoa = true;
                    } else {
                        pessoaListGravar.add(linha);
                    }

                }
                arquivoLeitura.close();
                memoriaLeitura.close();

                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : pessoaListGravar) {
                    memoriaEscrita.write(novaLinha);
                    memoriaEscrita.newLine();
                }

                memoriaEscrita.close();

            } else {
                return false;
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao atualizar");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao atualizar");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
        return atualizouPessoa;
    }

    private Boolean existiArquivo() {

        return arquivo.exists();
    }

    private Boolean criaArquivo() {
        try {
            return arquivo.createNewFile();

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao criar o arquivo");
            System.out.println("Mensagem de erro: " + e.getMessage());
            return false;
        }

    }

}
