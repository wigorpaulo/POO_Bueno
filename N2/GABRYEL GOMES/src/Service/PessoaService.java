package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Pessoa;


public class PessoaService {

	// ATRIBUTO
	private final String DIR_USER_DB = "src/data_base/pessoa.txt";
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	// CONSTRUTOR
	public PessoaService() {
		try {
			
			arquivoLeitura = new FileReader(DIR_USER_DB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(DIR_USER_DB);

		} catch (FileNotFoundException e) {
			
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		
		}
	}

	// M�TODOS

	public Boolean escrever(Pessoa pessoa) {
		try {
			if (existeArquivo()) {

				int contadorLinha = 0;

				String linha = null;

				while ((linha = memoriaLeitura.readLine()) != null) {
					contadorLinha = contadorLinha + 1;
				}

				contadorLinha = contadorLinha + 1;

				String dadoParaEscrever = pessoa.getNome() + ";" + pessoa.getTelefone() + ";" + pessoa.getEmail();

				escreverArquivo = new FileWriter(arquivo, true);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				memoriaEscrita.write(dadoParaEscrever);
				memoriaEscrita.newLine();

				memoriaEscrita.close();
				return true;

			} else {
				criaArquivo();
				escrever(pessoa);
			}

		} catch (FileNotFoundException e) {
			
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		
		}

		return false;
	}

	public Boolean ler(Pessoa pessoa) {
		try {
			if (existeArquivo()) {

				String linha = null;

				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (pessoa.getNome().equals(linha_split[1])) {
						return true;
					}
				}
			}

		} catch (FileNotFoundException e) {
			
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
			
		}

		return false;

	}

	public ArrayList<Pessoa> ler() {
		ArrayList<Pessoa> listPess = new ArrayList<>();

		try {
			if (existeArquivo()) {
				
				arquivoLeitura = new FileReader(DIR_USER_DB); 
				memoriaLeitura = new BufferedReader(arquivoLeitura);

				String linha = null;
				
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					Pessoa pessoa = new Pessoa();
					pessoa.setNome(linha_split[0]);
					pessoa.setTelefone(linha_split[1]);
					pessoa.setEmail(linha_split[2]);
					
					listPess.add(pessoa);
					
				}
			}

		} catch (FileNotFoundException e) {
			
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		
		}

		return listPess;
	}

	public Boolean excluir(Pessoa pessoa) {
		Boolean excluiPess = false;

		try {
			if (existeArquivo()) {

				ArrayList<String> pessListGravar = new ArrayList<>();

				String linha = null;

				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (!pessoa.getNome().equals(linha_split[1])) {
						
						pessListGravar.add(linha);
						
					} else {
						
						excluiPess = true;
						
					}
				}

				arquivoLeitura.close();
				memoriaLeitura.close();

				escreverArquivo = new FileWriter(arquivo, false);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				for (String novaLinha : pessListGravar) {
					
					memoriaEscrita.write(novaLinha);
					memoriaEscrita.newLine();
					
				}

				memoriaEscrita.close();

			} else {

				return false;
				
			}

		} catch (FileNotFoundException e) {
			
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			
			System.out.println("N�o foi poss�vel ler o arquivo");
			System.out.println("O erro gerado �: " + e.getMessage());
		
		}

		return excluiPess;

	}

	public Boolean atualizar(Pessoa pessoa) {
		Boolean atualizouPess = false;

		try {
			if (existeArquivo()) {
				ArrayList<String> pessListGravar = new ArrayList<>();

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (pessoa.getNome().equals(linha_split[1])) {
	
						String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + pessoa.getEmail() + ";" + pessoa.getTelefone();
						pessListGravar.add(novaLinha);
						atualizouPess = true;
	
					} else {

						pessListGravar.add(linha);
						
					}
				}

				arquivoLeitura.close();
				memoriaLeitura.close();

				escreverArquivo = new FileWriter(arquivo, false);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				for (String novaLinha : pessListGravar) {
					
					memoriaEscrita.write(novaLinha);
					memoriaEscrita.newLine();
				
				}

				memoriaEscrita.close();

			} else {
				
				return false;
				
			}
			
			return true;

		} catch (FileNotFoundException e) {
			
			System.out.println("Não foi possível abrir o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		
		}

		return atualizouPess;

	}

	private Boolean existeArquivo() {
		return arquivo.exists();
	}

	private Boolean criaArquivo() {
		try {

			return arquivo.createNewFile();

		} catch (IOException e) {
			
			System.out.println("Ocorreu um erro ao criar o arquivo.");
			System.out.println("O erro gerado é: " + e.getMessage());
			
			return false;
		}

	}

}