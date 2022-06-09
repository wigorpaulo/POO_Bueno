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
	private final String DIR_VEICULO_DB =  "src/data_base/veiculo.txt"; // java version error
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	public VeiculoService() {
		try {
			arquivoLeitura = new FileReader(DIR_VEICULO_DB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(DIR_VEICULO_DB);
		} catch (FileNotFoundException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
	}

	public Boolean escrever(Veiculo veiculo) {
		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_VEICULO_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1
				int contadorLinha = 0;
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					contadorLinha = contadorLinha + 1;

				}

				contadorLinha = contadorLinha + 1;
				String dadoParaEscrever = contadorLinha + ";" + veiculo.getPlaca() + ";" + veiculo.getMarca() + ";"
						+ veiculo.getAno();

				escreverArquivo = new FileWriter(arquivo, true);// se retirar isso o ID fica travado no 1
				memoriaEscrita = new BufferedWriter(escreverArquivo);// se retirar isso o ID fica travado no 1

				memoriaEscrita.write(dadoParaEscrever);
				memoriaEscrita.newLine();
				memoriaEscrita.close();
				return true;
			} else {
				criaArquivo();
				escrever(veiculo);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
		return false;

	}

	public Boolean ler(Veiculo veiculo) {
		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_VEICULO_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (veiculo.getPlaca().equals(linha_split[1])) {
						return true;
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}

		return false;
	}

	public ArrayList<Veiculo> ler() {
		ArrayList<Veiculo> listVeiculo = new ArrayList<>();
		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_VEICULO_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

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
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
		return listVeiculo;
	}

	public Boolean excluir(Veiculo veiculo) {
		Boolean excluiVeiculo = false;

		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_VEICULO_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

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

				escreverArquivo = new FileWriter(arquivo, false);// se retirar isso o ID fica travado no 1
				memoriaEscrita = new BufferedWriter(escreverArquivo);// se retirar isso o ID fica travado no 1

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
				arquivoLeitura = new FileReader(DIR_VEICULO_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

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
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

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
