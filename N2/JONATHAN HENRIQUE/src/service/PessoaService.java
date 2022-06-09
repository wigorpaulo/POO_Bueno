package service;

import model.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class PessoaService {
    private final String pessoa_DB = "src/data_base/pessoa.txt";
    private FileReader arquivoLeitura;
    private BufferedReader memoriaLeitura;
    private File arquivo;
    private FileWriter escreverArquivo;
    private BufferedWriter memoriaEscrita;

    public PessoaService(){
        try {
            arquivoLeitura = new FileReader(pessoa_DB);
            memoriaLeitura = new BufferedReader(arquivoLeitura);
            arquivo = new File(pessoa_DB);
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        }
    }

    public boolean escrever(Pessoa pessoa) {
        try {

            if (existeArquivo()){

                int contatorLinha = 0;
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    contatorLinha = contatorLinha +1;
                }

                contatorLinha = contatorLinha +1;

                String paraEscrever = contatorLinha + ";" + pessoa.getEmail() +  ";" + pessoa.getTelefone() + ";" +
                        pessoa.getNome();

                arquivo = new File(pessoa_DB);
                escreverArquivo = new FileWriter(arquivo, true);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                memoriaEscrita.write(paraEscrever);
                memoriaEscrita.newLine();

                memoriaEscrita.close();
                return true;
            } else {
                criarArquivo();
                escrever(pessoa);
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

    public boolean ler(Pessoa pessoa) {
        try {

            if (existeArquivo()){

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (pessoa.getNome().equals(linha_split[1])) {

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

    public ArrayList<Pessoa> ler() {
        ArrayList<Pessoa> listaPessoa = new ArrayList<>();

        try {

            if (existeArquivo()) {

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(Integer.parseInt(linha_split[0]));
                    pessoa.setNome(linha_split[1]);
                    pessoa.setTelefone(linha_split[2]);
                    pessoa.setEmail(linha_split[3]);

                    listaPessoa.add(pessoa);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }
        return listaPessoa;

    }

    public boolean excluir(Pessoa pessoa) {
        Boolean excluiuPessoa = false;

        try {

            if (existeArquivo()) {

                ArrayList<String> pessoaListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (pessoa.getNome().equals(linha_split[1])) {
                        pessoaListGravar.add(linha);
                    } else {
                        excluiuPessoa = true;
                    }

                }

                arquivoLeitura.close();
                memoriaLeitura.close();

                arquivo = new File(pessoa_DB);
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
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }

        return excluiuPessoa;
    }

    public boolean atualizar(Pessoa pessoa) {
        Boolean atualizouPessoa = false;

        try {

            if (existeArquivo()) {

                ArrayList<String> pessoaListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (pessoa.getNome().equals(linha_split[1])) {

                        String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + pessoa.getNome() + ";" + pessoa.getTelefone()
                                + ";" + pessoa.getEmail();
                        pessoaListGravar.add(novaLinha);
                        atualizouPessoa = true;
                    } else {
                        pessoaListGravar.add(linha);
                    }

                }

                arquivoLeitura.close();
                memoriaLeitura.close();

                arquivo = new File(pessoa_DB);
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

        }catch(FileNotFoundException e){
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }

        return atualizouPessoa;

    }

    private boolean existeArquivo() {
        File arquivo = new File(pessoa_DB);
        return arquivo.exists();

    }

    private boolean criarArquivo() {

        try {
            File arquivo = new File(pessoa_DB);

            return arquivo.createNewFile();

        } catch (IOException e)  {
            System.out.println("Ocorreu um erro ao criar o arquivo de Pessoa.");
            System.out.println("O erro gerado é: " + e.getMessage());
            return false;
        }
    }
}
