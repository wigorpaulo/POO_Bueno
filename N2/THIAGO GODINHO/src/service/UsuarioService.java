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

	private final String DIR_USER_DB = "src/data_base/usuario.txt";	// java version error
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	public UsuarioService() {
		try {
			arquivoLeitura = new FileReader(DIR_USER_DB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(DIR_USER_DB);
		} catch (FileNotFoundException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
	}

	public Boolean escrever(Usuario usuario) {
		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_USER_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1
				int contadorLinha = 0;
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					contadorLinha = contadorLinha + 1;

				}

				contadorLinha = contadorLinha + 1;
				String dadoParaEscrever = contadorLinha + ";" + usuario.getLogin() + ";" + usuario.getSenha();

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
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (NullPointerException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());
		}
		return false;

	}

	public Boolean ler(Usuario usuario) {
		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_USER_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (usuario.getLogin().equals(linha_split[1])) {
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

	public ArrayList<Usuario> ler() {
		ArrayList<Usuario> listUser = new ArrayList<>();
		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_USER_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

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
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
		return listUser;
	}

	public Boolean excluir(Usuario usuario) {
		Boolean excluiUser = false;

		try {
			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_USER_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

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
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
		return excluiUser;
	}

	public Boolean atualizar(Usuario usuario) {
		Boolean atualizouUser = false;
		try {

			if (existiArquivo()) {
				arquivoLeitura = new FileReader(DIR_USER_DB); // se retirar isso o ID fica travado no 1
				memoriaLeitura = new BufferedReader(arquivoLeitura);// se retirar isso o ID fica travado no 1

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
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Ocoreu um erro");
			System.out.println("Erro gerado: " + e.getMessage());

		}
		return atualizouUser;
	}

	private Boolean existiArquivo() {
		arquivo = new File(DIR_USER_DB);
		return arquivo.exists();
	}

	private Boolean criaArquivo() {
		try {
			arquivoLeitura = new FileReader(DIR_USER_DB);
			return arquivo.createNewFile();

		} catch (IOException e) {
			System.out.println("Ocoreu um erro ao criar o arquivo");
			System.out.println("Erro gerado: " + e.getMessage());
			return false;
		}

	}
}
