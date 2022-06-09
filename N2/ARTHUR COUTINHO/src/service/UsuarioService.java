package service;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class UsuarioService {

    private final String user_DB = "src/data_base/usuario.txt";
    private FileReader arquivoLeitura;
    private BufferedReader memoriaLeitura;
    private File arquivo;
    private FileWriter escreverArquivo;
    private BufferedWriter memoriaEscrita;

    public UsuarioService(){
        try {
            arquivoLeitura = new FileReader(user_DB);
            memoriaLeitura = new BufferedReader(arquivoLeitura);
            arquivo = new File(user_DB);
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        }
    }

    public boolean escrever(Usuario user) {
        try {

            if (existeArquivo()){

                int contadorLinha = 0;
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {
                	contadorLinha ++;
                }

                contadorLinha ++;

               String paraEscrever = contadorLinha + ";" + user.getUsername() +  ";" + user.getPassword();

               arquivo = new File(user_DB);
               escreverArquivo = new FileWriter(arquivo, true);
               memoriaEscrita = new BufferedWriter(escreverArquivo);

               memoriaEscrita.write(paraEscrever);
               memoriaEscrita.newLine();

               memoriaEscrita.close();
               return true;
            } else {
                criarArquivo();
                escrever(user);
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

    public boolean ler(Usuario user) {
        try {

            if (existeArquivo()){

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (user.getUsername().equals(linha_split[1])) {

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

    public ArrayList<Usuario> ler() {
        ArrayList<Usuario> listaUser = new ArrayList<>();

        try {

            if (existeArquivo()) {
                //FileReader arquivoLeitura = new FileReader(user_DB);
                //BufferedReader memoriaLeitura = new BufferedReader(arquivoLeitura);

                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    Usuario user = new Usuario();
                    user.setId(Integer.parseInt(linha_split[0]));
                    user.setUsername(linha_split[1]);
                    user.setPassword(linha_split[2]);

                    listaUser.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }
        return listaUser;

    }

    public boolean excluir(Usuario user) {
        Boolean excluiuUser = false;

        try {

            if (existeArquivo()) {

                ArrayList<String> userListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (user.getUsername().equals(linha_split[1])) {
                        userListGravar.add(linha);
                    } else {
                        excluiuUser = true;
                    }

                }

                arquivoLeitura.close();
                memoriaLeitura.close();

                arquivo = new File(user_DB);
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
             System.out.println("Não foi possivel abrir o arquivo!");
             System.out.println("O erro gerado é: " + e.getMessage());
        } catch (IOException e) {
             System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
             System.out.println("O erro gerado é: " + e.getMessage());
        }

        return excluiuUser;
    }

    public boolean atualizar(Usuario user) {
        Boolean atualizouUser = false;

        try {

            if (existeArquivo()) {

                ArrayList<String> userListGravar = new ArrayList<>();
                String linha = null;
                while ((linha = memoriaLeitura.readLine()) != null) {

                    String[] linha_split = linha.split(";");

                    if (user.getUsername().equals(linha_split[1])) {

                        String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + user.getPassword();
                        userListGravar.add(novaLinha);
                        atualizouUser = true;
                    } else {
                        userListGravar.add(linha);
                    }

                }

                arquivoLeitura.close();
                memoriaLeitura.close();

                arquivo = new File(user_DB);
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

        }catch(FileNotFoundException e){
            System.out.println("Não foi possivel abrir o arquivo!");
            System.out.println("O erro gerado é: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Não foi possivel ler o arquivo:" + e.getMessage());
            System.out.println("O erro gerado é: " + e.getMessage());
        }

        return atualizouUser;

    }

    private boolean existeArquivo() {
        File arquivo = new File(user_DB);
        return arquivo.exists();

    }

    private boolean criarArquivo() {

        try {
            File arquivo = new File(user_DB);

            return arquivo.createNewFile();

        } catch (IOException e)  {
            System.out.println("Ocorreu um erro ao criar o arquivo de Usuario.");
            System.out.println("O erro gerado é: " + e.getMessage());
            return false;
        }
    }
}
