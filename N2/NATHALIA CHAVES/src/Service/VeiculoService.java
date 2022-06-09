
package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// import model.Usuario;
import model.Veiculo;

public class VeiculoService {

	// ATRIBUTO
	private final String DIR_USER_DB = "src/data_base/veiculo.txt";
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	// CONSTRUTOR
	public VeiculoService() {
		try {
			arquivoLeitura = new FileReader(DIR_USER_DB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(DIR_USER_DB);

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		}
	}

	// Mï¿½TODOS

	public Boolean escrever(Veiculo veiculo) {
		try {
			if (existeArquivo()) {

				int contadorLinha = 0;

				String linha = null;

				while ((linha = memoriaLeitura.readLine()) != null) {
					contadorLinha = contadorLinha + 1;
				}

				contadorLinha = contadorLinha + 1;

				String dadoParaEscrever = contadorLinha + ";" + veiculo.getAno() + ";" + veiculo.getTipoVeiculoId() + ";" + veiculo.getPlaca() + ";" + veiculo.getMarca();
				
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
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		}

		return false;
	}

	public boolean ler(Veiculo veiculo) {
				
		try {
			if (existeArquivo()) {

				String linha = null;

				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (veiculo.getPlaca().equals(linha_split[1])) {
						return true;
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		}

		return false;

	}

	public ArrayList<Veiculo> ler() {
		ArrayList<Veiculo> listVer = new ArrayList<>();

		try {
			if (existeArquivo()) {
				
				arquivoLeitura = new FileReader(DIR_USER_DB); 
				memoriaLeitura = new BufferedReader(arquivoLeitura);

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					Veiculo veiculo = new Veiculo();
					
					veiculo.setId(Integer.parseInt(linha_split[0]));
					veiculo.setAno(Integer.parseInt(linha_split[1]));
					veiculo.setTipoVeiculoId(Integer.parseInt(linha_split[2]));
					veiculo.setPlaca(linha_split[3]);
					veiculo.setMarca(linha_split[4]);
					
					;

					listVer.add(veiculo);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		}

		return listVer;
	}

	public Boolean excluir(Veiculo veiculo) {
		Boolean excluiVer = false;

		try {
			// verificar se existe
			if (existeArquivo()) {

				ArrayList<String> veicListGravar = new ArrayList<>();

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (!veiculo.getPlaca().equals(linha_split[1])) {
						veicListGravar.add(linha);
					} else {
						excluiVer = true;
					}
				}

				arquivoLeitura.close();
				memoriaLeitura.close();

				// se encontrar excluir e retorne true
				// se nï¿½o retorna false

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
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado ï¿½: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		}

		return excluiVer;

	}

	public Boolean atualizar(Veiculo veiculo) {
		Boolean atualizouVeic = false;

		try {
			// verificar se existe
			if (existeArquivo()) {
				// fazer a leitura

				ArrayList<String> veicListGravar = new ArrayList<>();

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (veiculo.getPlaca().equals(linha_split[1])) {
						// se encontrar atualizar
						String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + veiculo.getAno() + ";" + veiculo.getId()+ ";" + veiculo.getMarca() + ";" + veiculo.getPlaca() + ";" + veiculo.getTipoVeiculoId(); 
						veicListGravar.add(novaLinha);
						atualizouVeic = true;
					} else {

						veicListGravar.add(linha);
					}
				}

				arquivoLeitura.close();
				memoriaLeitura.close();

				// se nï¿½o retorna false

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
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Não foi possível ler o arquivo");
			System.out.println("O erro gerado é: " + e.getMessage());
		}

		return atualizouVeic;

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

