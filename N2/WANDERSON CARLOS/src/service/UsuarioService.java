package service;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class UsuarioService {

    private final String DIR_USER = "src/data_base/usuario.txt";
    private FileReader arquivoLeitura;
    private BufferedReader memoriaLeitura;
    private File arquivo;
    private FileWriter escreverArquivo;
    private BufferedWriter memoriaEscrita;

    public UsuarioService() {

        try {
            arquivoLeitura = new FileReader(DIR_USER);
            memoriaLeitura = new BufferedReader(arquivoLeitura);
            arquivo = new File(DIR_USER);

        } catch (FileNotFoundException e) {

            System.out.println("Ocoreu um erro Construtor UsuarioService");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro Construtor UsuarioService");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
    }

    public Boolean escrever(Usuario usuario) {
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

                String dadoParaEscrever = cont + ";" + usuario.getLogin() + ";" + usuario.getSenha();

                escreverArquivo = new FileWriter(arquivo, true);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                memoriaEscrita.write(dadoParaEscrever);
                memoriaEscrita.newLine();
                memoriaEscrita.close();
                return true;
            } else {
                criaArquivo();
                escrever(usuario);
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

    public Boolean ler(Usuario usuario) {

        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;

                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");
                    if (usuario.getLogin().equals(linha_split[1])) {
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

    public ArrayList<Usuario> ler() {
        ArrayList<Usuario> listUser = new ArrayList<>();
        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;

                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");
                    Usuario usuario = new Usuario();
                    usuario.setId(Integer.parseInt(linha_split[0]));
                    usuario.setLogin(linha_split[1]);
                    usuario.setSenha(linha_split[2]);
                    listUser.add(usuario);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ocoreu um erro ao ler o arquivo array");
            System.out.println("Mensagem de erro: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao ler o arquivo array");
            System.out.println("Mensagem de erro: " + e.getMessage());

        }
        return listUser;
    }

    public Boolean excluir(Usuario usuario) {
        Boolean excluiUser = false;

        try {
            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                ArrayList<String> userListGravar = new ArrayList<>();

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (!usuario.getLogin().equals(linha_split[1])) {
                        userListGravar.add(linha);
                    } else {
                        excluiUser = true;
                    }

                }
                arquivoLeitura.close();

                memoriaLeitura.close();

                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : userListGravar) {
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
        return excluiUser;
    }

    public Boolean atualizar(Usuario usuario) {
        Boolean atualizouUser = false;
        try {

            if (existiArquivo()) {
                arquivoLeitura = new FileReader(DIR_USER);
                memoriaLeitura = new BufferedReader(arquivoLeitura);

                ArrayList<String> userListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                    String[] linha_split = linha.split(";");

                    if (usuario.getLogin().equals(linha_split[1])) {
                        String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + usuario.getSenha();
                        userListGravar.add(novaLinha);
                        atualizouUser = true;

                    } else {

                        userListGravar.add(linha);
                    }

                }
                arquivoLeitura.close();

                memoriaLeitura.close();

                escreverArquivo = new FileWriter(arquivo, false);
                memoriaEscrita = new BufferedWriter(escreverArquivo);

                for (String novaLinha : userListGravar) {
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

        return atualizouUser;
    }

    private Boolean existiArquivo() {
        arquivo = new File(DIR_USER);
        return arquivo.exists();
    }

    private Boolean criaArquivo() {
        try {
            arquivoLeitura = new FileReader(DIR_USER);
            return arquivo.createNewFile();

        } catch (IOException e) {
            System.out.println("Ocoreu um erro ao criar o arquivo");
            System.out.println("Mensagem de erro: " + e.getMessage());
            return false;
        }

    }
}
