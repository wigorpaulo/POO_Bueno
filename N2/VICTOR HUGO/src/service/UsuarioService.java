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
	
	/*Atributo*/
	private final String diretorioArquivo = "src/data_base/UsuarioTxt";
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	
	/*Construtor*/
	
	public UsuarioService() {
		
		try {
			arquivoLeitura = new FileReader(diretorioArquivo);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(diretorioArquivo);
		
			
		}  catch (FileNotFoundException e) {
			System.out.println("N�o foi possivel abrir o arquivo!");
			System.out.println("O erro gerado �:"+ e.getMessage());
		}
		
	}
	
	/* Metudos */
public Boolean escrever(Usuario user) {
	try {
			/* DEVE VERIFICAR SE O ARQUIVO EXISTE */
		if (existeArquivo()) {
			arquivoLeitura = new FileReader(diretorioArquivo);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
				
			int contadorLinha = 0;
			String linha;
			while((linha = memoriaLeitura.readLine())!= null) {
				contadorLinha = contadorLinha = 1;
			}
				
			contadorLinha = contadorLinha = 1;
			/*--------------------------------------------------------------------*/
			
			/*--------------------------------------------------------------------*/
            /* IR� RETORNAR TRUE, QUANDO FEZ A ESCRITA NO ARQUIVO TEXTO COM SUCESSO*/
			
			                         /*ID, USERNAME, PASSWORD*/
			String dadoParaEscrever = contadorLinha + ";"+ user.getUsername() + ";"+ user.getPassword();
				
		    escreverArquivo = new FileWriter(arquivo, true);
		    memoriaEscrita = new BufferedWriter(escreverArquivo);	
			
			memoriaEscrita.write(dadoParaEscrever);
			memoriaEscrita.newLine();
			
			
			memoriaEscrita.close();
			return true;
				
		} else {
			criarArquivo();
			escrever(user); //recurs�o
		}
			
		} catch (FileNotFoundException e) {
			System.out.println("N�o foi possivel abrir o arquivo!");
			System.out.println("O erro gerado �:"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("N�o foi possivel ler o arquivo!");
			System.out.println("O erro gerado �:"+ e.getMessage());
			
		}
		return false;
	}
	
public Boolean ler(Usuario user) {
	try {
		/*DEVE VERIFICAR SE O ARQUIVO EXISTE */
		if (existeArquivo()) {
				
			String linha = null;
			while((linha = memoriaLeitura.readLine())!= null) {
				
				String[] linha_split = linha.split(";");
				
				if (user.getUsername().equals(linha_split[0])) {
					/* IRA RETORNAR TRUE, QUANDO DENTRO DO ARQUIVO TEXTO "EXISTIR" O USERNAME, PASSADO PELO PARAMETRO */
					return true;
				}
			}
		} 
		
	} catch (FileNotFoundException e) {
		System.out.println("N�o foi possivel abrir o arquivo!");
		System.out.println("O erro gerado �:"+ e.getMessage());
	} catch (IOException e) {
		System.out.println("N�o foi possivel ler o arquivo!");
		System.out.println("O erro gerado �:"+ e.getMessage());
	}
		return false;
	}
	
public ArrayList<Usuario> ler(){
	ArrayList<Usuario> listaUser = new ArrayList<>();
	
	try {
		/*DEVE VERIFICAR SE O ARQUIVO EXISTE */
		if (existeArquivo()) {
			
			arquivoLeitura = new FileReader(diretorioArquivo);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
				
			String linha = null;
			while((linha = memoriaLeitura.readLine())!= null) {
				
				String[] linha_split = linha.split(";");
				
				Usuario user = new Usuario();
				user.setId(Integer.parseInt(linha_split[0]));//id
				user.setUsername(linha_split[1]); //USERNAME
				user.setPassword(linha_split[2]); //PASSWORD
				
				listaUser.add(user);
				
				}
			}
	
	}  catch (FileNotFoundException e) {
		
		/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
		System.out.println("N�o foi possivel abrir o arquivo!");
		System.out.println("O erro gerado �:"+ e.getMessage());
	} catch (IOException e) {
		/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
		System.out.println("N�o foi possivel ler o arquivo!");
		System.out.println("O erro gerado �:"+ e.getMessage());
	}
	return listaUser;
	}
	
public Boolean excluir(Usuario user) {
	
	Boolean excluiuUser =  false;
	try {
		
		/* VERIFICAR SE O ARQUIVO EXISTE */
		if (existeArquivo()) {
			
			arquivoLeitura = new FileReader(diretorioArquivo);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			
			ArrayList<String> userListGravar = new ArrayList<>();
			String linha = null;
			while((linha = memoriaLeitura.readLine())!= null) {
				
				String[] linha_split = linha.split(";");
				
				//PROCURAR NO ARQUIVO O "username"
				if (!user.getUsername().equals(linha_split[1])) {
					userListGravar.add(linha);
					
			} else {
				excluiuUser = true;
			}
				}
			
			arquivoLeitura.close();
			memoriaLeitura.close();
			
			 escreverArquivo = new FileWriter(arquivo, false);
			 memoriaEscrita = new BufferedWriter(escreverArquivo);	
			
			for(String novalinha : userListGravar) {
				
				memoriaEscrita.write(novalinha);
				memoriaEscrita.newLine();
			}
			
			memoriaEscrita.close();
				
		} else {
			return false;
			
			}
	
}  catch (FileNotFoundException e) {
	
	/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
	System.out.println("N�o foi possivel abrir o arquivo!");
	System.out.println("O erro gerado �:"+ e.getMessage());
} catch (IOException e) {
	/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
	System.out.println("N�o foi possivel ler o arquivo!");
	System.out.println("O erro gerado �:"+ e.getMessage());
}
	return excluiuUser;
	}
	
public Boolean atualizar(Usuario user) {
	Boolean atualizouUser =  false;
	try {
		
		/* VERIFICAR SE O ARQUIVO EXISTE */
		if (existeArquivo()) {
			
			arquivoLeitura = new FileReader(diretorioArquivo);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			
			ArrayList<String> userListGravar = new ArrayList<>();
			String linha = null;
			while((linha = memoriaLeitura.readLine())!= null) {
							
			String[] linha_split = linha.split(";");
							
				//PROCURAR NO ARQUIVO O "username"
			if (user.getUsername().equals(linha_split[1])) {
				// ATUALIZAR AS INFORMA��ES DO USUARIO
				String novaLinha = linha_split[0]+ ";"+linha_split[1] +";" +user.getPassword();
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
			
			for(String novalinha : userListGravar) {
				
				memoriaEscrita.write(novalinha);
				memoriaEscrita.newLine();
			}
			
			memoriaEscrita.close();
						
		} else {
			return false;
			}
		
	} catch (FileNotFoundException e) {
		
		/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
		System.out.println("N�o foi possivel abrir o arquivo!");
		System.out.println("O erro gerado �:"+ e.getMessage());
	} catch (IOException e) {
		/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
		System.out.println("N�o foi possivel ler o arquivo!");
		System.out.println("O erro gerado �:"+ e.getMessage());
		
		return atualizouUser;
	}
	return atualizouUser;
}
	
private Boolean existeArquivo() {
		
	return arquivo.exists();
	}
	
private Boolean criarArquivo() {
		
	try {
			
		return arquivo.createNewFile();
			
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao criar um arquivo de usuario:");
			System.out.println("O erro gerado:"+e.getMessage());
			return false;
		}
	}
}
