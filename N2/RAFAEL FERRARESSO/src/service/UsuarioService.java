package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioService {
	
	/*ATRIBUTO*/
	private final String DIR_USER_DB = "src/data_base/usuario.txt";
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;
	
	/*CONSTRUTOR*/
	public UsuarioService() {
		try {
			arquivoLeitura = new FileReader(DIR_USER_DB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(DIR_USER_DB);
		} catch(FileNotFoundException e){
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
	}
	
	/*MÉTODOS*/
	public Boolean escrever(Usuario user) {
		
		try {
				
			if(existArquivo()) {
				
				int contadorLinha = 0;
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					contadorLinha = contadorLinha + 1;
				}
				
					contadorLinha = contadorLinha + 1;
				
				String dadoParaEscrever = contadorLinha + ";" + user.getUsername() + ";" +user.getPassword();
				
				escreverArquivo = new FileWriter(arquivo, true);
				BufferedWriter memoriaEscrita = new BufferedWriter(escreverArquivo);
				
				memoriaEscrita.write(dadoParaEscrever);
				memoriaEscrita.newLine();
				memoriaEscrita.close();
				return true;
				
			} else {
				criaArquivo();
				escrever(user);
			}
			
		} catch(FileNotFoundException e){
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch(IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
		return false;
	}

	public Boolean ler(Usuario user) {
		try {
			if(existArquivo()) {
				
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					
					if(user.getUsername().equals(linha_split[1])) {
						return true;
					}
				}
				
			}
			
	} catch(FileNotFoundException e){
		System.out.println("Não foi possível abrir o arquivo");
		System.out.println("O erro gerado é:"+ e.getMessage());
	} catch(IOException e) {
		System.out.println("Não foi possível ler o arquivo");
		System.out.println("O erro gerado é:"+ e.getMessage());
	}
		
		return false;
	}
	
	public ArrayList<Usuario> ler(){
		ArrayList<Usuario> listUser = new ArrayList<>();
		
		try {	
			
			if(existArquivo()) {
				
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					
					Usuario user = new Usuario();
					user.setId(Integer.parseInt(linha_split[0]));
					user.setUsername(linha_split[1]);
					user.setPassword(linha_split[2]);
					
					listUser.add(user);
				}
			}
			
		} catch(FileNotFoundException e){
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch(IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
		
		
		return listUser;
	}
	
	public Boolean excluir(Usuario user) {
		Boolean excluiUser = false;
		try {
			if(existArquivo()) {
				
				ArrayList<String> userListGravar = new ArrayList<>();
				
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
				
					if(!user.getUsername().equals(linha_split[1])) {
						
						userListGravar.add(linha);
					} else {
						excluiUser = true;
						
					}
				}
				
				arquivoLeitura.close();
				memoriaLeitura.close();
				
				escreverArquivo = new FileWriter(arquivo, false);
				BufferedWriter memoriaEscrita = new BufferedWriter(escreverArquivo);
				
				for(String novaLinha : userListGravar) {
				memoriaEscrita.write(novaLinha);
				memoriaEscrita.newLine();
				}
				
				memoriaEscrita.close();
				
				
			} else {
				return false;
			}
		} catch(FileNotFoundException e){
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch(IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
		return excluiUser;
	}
	
	public Boolean atualizar(Usuario user) {
		Boolean atualizouUser = false;
		try {
			if(existArquivo()) {
				
				ArrayList<String> userListGravar = new ArrayList<>();
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
				
					if(user.getUsername().equals(linha_split[1])) {
						
						String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + user.getPassword();
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
				
				for(String novaLinha : userListGravar) {
				memoriaEscrita.write(novaLinha);
				memoriaEscrita.newLine();
				}
				
				memoriaEscrita.close();
				
				
			} else {
				return false;
			}
				
		} catch(FileNotFoundException e){
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch(IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
		
		return atualizouUser ;
	}
	
	private Boolean existArquivo() {
		
		return arquivo.exists();
	}
	
	private Boolean criaArquivo() {
		
		try {
			return arquivo.createNewFile();	
		} catch(IOException e){
			System.out.println("Ocorreu um erro ao criar o arquivo de usuario");
			System.out.println("O erro gerado é:"+ e.getMessage());
			return false;
		}
	}
}
