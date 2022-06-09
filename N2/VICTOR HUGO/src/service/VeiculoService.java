package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Veiculo;

public class VeiculoService {
		
		/*Atributo*/
		private final String diretorioArquivo = "src/data_base/VeiculoTxt";
		private FileReader arquivoLeitura;
		private BufferedReader memoriaLeitura;
		private File arquivo;
		private FileWriter escreverArquivo;
		private BufferedWriter memoriaEscrita;

		
		/*Construtor*/
		
		public VeiculoService() {
			
			try {
				arquivoLeitura = new FileReader(diretorioArquivo);
				memoriaLeitura = new BufferedReader(arquivoLeitura);
				arquivo = new File(diretorioArquivo);
			
				
			}  catch (FileNotFoundException e) {
				System.out.println("Não foi possivel abrir o arquivo!");
				System.out.println("O erro gerado é:"+ e.getMessage());
			}
			
		}
		
		/* Metudos */
	public Boolean escrever(Veiculo veiculo) {
		try {
				/* DEVE VERIFICAR SE O ARQUIVO EXISTE */
			if (existeArquivo()) {
				arquivoLeitura = new FileReader(diretorioArquivo);
				memoriaLeitura = new BufferedReader(arquivoLeitura);
			
				int contadorLinha = 0;
				String linha = null;
				while((linha = memoriaLeitura.readLine())!= null) {
					contadorLinha = contadorLinha = 1;
				}
					
				contadorLinha = contadorLinha = 1;
				/*--------------------------------------------------------------------*/
				
				/*--------------------------------------------------------------------*/
	            /* IRÁ RETORNAR TRUE, QUANDO FEZ A ESCRITA NO ARQUIVO TEXTO COM SUCESSO*/
				
				                         /*ID, USERNAME, PASSWORD*/
				String dadoParaEscrever = contadorLinha + ";"+ veiculo.getAno() + ";"+ veiculo.getDescricao() + ";" + veiculo.getMarca() + ";"+ veiculo.getPlaca()+";"+ veiculo.getTipoveiculo();
					
			    escreverArquivo = new FileWriter(arquivo, true);
			    memoriaEscrita = new BufferedWriter(escreverArquivo);	
				
				memoriaEscrita.write(dadoParaEscrever);
				memoriaEscrita.newLine();
				
				
				memoriaEscrita.close();
				return true;
					
			} else {
				criarArquivo();
				escrever(veiculo); //recursão
			}
				
			} catch (FileNotFoundException e) {
				System.out.println("Não foi possivel abrir o arquivo!");
				System.out.println("O erro gerado é:"+ e.getMessage());
			} catch (IOException e) {
				System.out.println("Não foi possivel ler o arquivo!");
				System.out.println("O erro gerado é:"+ e.getMessage());
				
			}
			return false;
		}
		
	public boolean ler(Veiculo veiculo) {
		ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
		
		try {
			/*DEVE VERIFICAR SE O ARQUIVO EXISTE */
			if (existeArquivo()) {
				arquivoLeitura = new FileReader(diretorioArquivo);
				memoriaLeitura = new BufferedReader(arquivoLeitura);
				
				String linha = null;
				while((linha = memoriaLeitura.readLine())!= null) {
					
					String[] linha_split = linha.split(";");
					
					if (veiculo.getPlaca().equals(linha_split[0])) {
						/* IRA RETORNAR TRUE, QUANDO DENTRO DO ARQUIVO TEXTO "EXISTIR" O USERNAME, PASSADO PELO PARAMETRO */
						return true;
					}
				}
			} 
			
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possivel abrir o arquivo!");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Não foi possivel ler o arquivo!");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
			return false;
		}
		
	public ArrayList<Veiculo> ler(){
		ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
		
		try {
			/*DEVE VERIFICAR SE O ARQUIVO EXISTE */
			if (existeArquivo()) {
				arquivoLeitura = new FileReader(diretorioArquivo);
				memoriaLeitura = new BufferedReader(arquivoLeitura);
					
				String linha = null;
				while((linha = memoriaLeitura.readLine())!= null) {
					String[] linha_split = linha.split(";");
					
					Veiculo veiculo = new Veiculo();
					veiculo.setId(Integer.parseInt(linha_split[0]));
					veiculo.setAno((linha_split[1])); 
					veiculo.setDescricao(linha_split[2]); 
					veiculo.setMarca(linha_split[3]);
					veiculo.setPlaca(linha_split[4]);
					veiculo.setTipoveiculo(linha_split[5]);
					
					listaVeiculo.add(veiculo);
					
					}
				}
		
		}  catch (FileNotFoundException e) {
			System.out.println("Não foi possivel abrir o arquivo!");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Não foi possivel ler o arquivo!");
			System.out.println("O erro gerado é:"+ e.getMessage());
		}
		return listaVeiculo;
		}
		
	public Boolean excluir(Veiculo veiculo) {
		
		Boolean excluiuVeiculo =  false;
		try {
			
			/* VERIFICAR SE O ARQUIVO EXISTE */
			if (existeArquivo()) {
				arquivoLeitura = new FileReader(diretorioArquivo);
				memoriaLeitura = new BufferedReader(arquivoLeitura);
				
				ArrayList<String> veiculoListGravar = new ArrayList<>();
				String linha = null;
				while((linha = memoriaLeitura.readLine())!= null) {
					
					String[] linha_split = linha.split(";");
					
					if (!veiculo.getAno().equals(linha_split[1])) {
						veiculoListGravar.add(linha);
						
				} else {
					excluiuVeiculo = true;
				}
					}
				
				arquivoLeitura.close();
				memoriaLeitura.close();
				
				 escreverArquivo = new FileWriter(arquivo, false);
				 memoriaEscrita = new BufferedWriter(escreverArquivo);	
				
				for(String novalinha : veiculoListGravar) {
					
					memoriaEscrita.write(novalinha);
					memoriaEscrita.newLine();
				}
				
				memoriaEscrita.close();
					
			} else {
				return false;
				
				}
		
	}  catch (FileNotFoundException e) {
		
		/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
		System.out.println("Não foi possivel abrir o arquivo!");
		System.out.println("O erro gerado é:"+ e.getMessage());
	} catch (IOException e) {
		/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
		System.out.println("Não foi possivel ler o arquivo!");
		System.out.println("O erro gerado é:"+ e.getMessage());
	}
		return excluiuVeiculo;
		}
		
	public Boolean atualizar(Veiculo veiculo) {
		Boolean atualizouVeiculo =  false;
		try {
			
			/* VERIFICAR SE O ARQUIVO EXISTE */
			if (existeArquivo()) {
				arquivoLeitura = new FileReader(diretorioArquivo);
				memoriaLeitura = new BufferedReader(arquivoLeitura);
				
				ArrayList<String> veiculoListGravar = new ArrayList<>();
				String linha = null;
				while((linha = memoriaLeitura.readLine())!= null) {
								
				String[] linha_split = linha.split(";");
								
					//PROCURAR NO ARQUIVO O "username"
				if (veiculo.getAno().equals(linha_split[1])) {
					// ATUALIZAR AS INFORMAÇÕES DO USUARIO
					String novaLinha = linha_split[0]+ ";"+linha_split[1] +";" +veiculo.getMarca();
					veiculoListGravar.add(novaLinha);
					atualizouVeiculo = true;
				} else {
					veiculoListGravar.add(linha);
				}
			}	
				arquivoLeitura.close();
			    memoriaLeitura.close();
			    
				 escreverArquivo = new FileWriter(arquivo, false);
				 memoriaEscrita = new BufferedWriter(escreverArquivo);	
				
				for(String novalinha : veiculoListGravar) {
					
					memoriaEscrita.write(novalinha);
					memoriaEscrita.newLine();
				}
				
				memoriaEscrita.close();
							
			} else {
				return false;
				}
			
		} catch (FileNotFoundException e) {
			
			/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
			System.out.println("Não foi possivel abrir o arquivo!");
			System.out.println("O erro gerado é:"+ e.getMessage());
		} catch (IOException e) {
			/* IRA RETORNAR FALSE, QUANDO TIVER UM ERRO NA ESCRITA DO ARQUIVO TEXTO */
			System.out.println("Não foi possivel ler o arquivo!");
			System.out.println("O erro gerado é:"+ e.getMessage());
			
			return atualizouVeiculo;
		}
		return atualizouVeiculo;
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


