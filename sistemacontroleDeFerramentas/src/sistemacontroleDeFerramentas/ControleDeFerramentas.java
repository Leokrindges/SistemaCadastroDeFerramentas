package sistemacontroleDeFerramentas;

import java.io.InputStream;
import java.util.Scanner;

public class ControleDeFerramentas {
	// criando os vetores
	static String[] categoriaFerramentas = new String[1];
	static String pessoa[][] = new String[2][2];
	static String objeto[][] = new String[4][4];
	static String emprestimo[][] = new String[7][7];
	static String manutencao[][] = new String[8][8];
	Scanner entrada = new Scanner(System.in);

	// declaracao dos metodos
	public void inicializaVetores() {
		int i;
		int j;
		for (i = 0; i < categoriaFerramentas.length; i++) {// percore todos os arrays e inicializa com ""
			categoriaFerramentas[i] = "";
		}
		for (i = 0; i < pessoa.length; i++) {
			for (j = 0; j < pessoa.length; j++) {
				pessoa[i][j] = "";
			}
		}
	}

	public int verificaPosicaoLivreVetor(String vetor[]) {
		int i;
		int posicaoLivre = -1;
		for (i = 0; i < vetor.length; i++) { // percore o vetor recebido por paramentro e caso a posicao seja == a ""
			if (vetor[i] == "") { // atribui aquela posicao a variavel posicao livre retorna essa posicao
				posicaoLivre = i;
				i = vetor.length;
			}
		}
		return posicaoLivre;
	}

	public int verificaPosicaoLivreMatriz(String matriz[][]) {
		int i;
		int posicaoLivre = -1;
		for (i = 0; i < matriz.length; i++) { // percore a matriz recebido por paramentro e caso a posicao seja == a ""
			if (matriz[i][0] == "") { // atribui aquela posicao a variavel posicao livre retorna essa posicao
				posicaoLivre = i;
				i = matriz.length;
			}
		}
		return posicaoLivre;
	}

	public int verificaSeExistemPessoasCadastradas(String[][] matriz, int idPessoa) {
		int i;
		int j;
		int existeCadastro = -1;
		for (i = 0; i < matriz.length; i++) { // recebe por paramentro uma matriz e o id da pessoa, verifica se
			for (j = 0; j < matriz.length; j++) { // existe aquele id cadastrado, e se tiver algum dado gravado naquele
				if (i == idPessoa && matriz[i][1] != "") { // id, passa aquela posicao pra variavel existeCadastro
					existeCadastro = i;
					i = matriz.length;
				}
			}
		}
		return existeCadastro;
	}

	public void menu() {
		int opcao;
		System.out.println("\t-----------------------------------");
		System.out.println("\t Sistema de Emprestimos de Objetos ");
		System.out.println("\t-----------------------------------");
		System.out.println("1. Pessoas");
		System.out.println("2. Categoria de Objetos");
		System.out.println("3. Objetos");
		System.out.println("4. Manutenção");
		System.out.println("5. Realizar Emprestimo");
		System.out.println("6. Relatórios");
		System.out.println("7. Sair");
		System.out.println("Escolha sua opcao:"); // imprime o menu principal e aguarda o usuario escolher a opcao
		opcao = entrada.nextInt();
		do {
			switch (opcao) { // depois de escolhida a opcao usando o switch ele encaminha para o metodo
								// correspondente
			case 1:
				pessoa();
				break;
			case 2:
				categoriaObtejo();
				break;
			case 3:
				objetos();
				break;
			case 4:
				manutencao();
				break;
			case 5:
				realizarEmprestimo();
				break;
			case 6:
				relatorios();
				break;

			case 7:
				System.out.println("Saindo...");
				System.exit(7);
				break;

			default:
				System.out.println("OPCAO INVALIDA!");
			}

		} while (opcao != 7);
	}

	public void subMenu() {
		System.out.println("\tSistema de Emprestimos de Objetos");
		System.out.println("1. Incluir");
		System.out.println("2. Consultar");
		System.out.println("3. Alterar");
		System.out.println("4. Excluir");
		System.out.println("5. Sair");
		System.out.println("Escolha sua opção");
	}

	public void pessoa() {
		int opcao;
		int posicaoLinha;
		do {
			System.out.println("\t-----------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("\t       Cadastro de Pessoas");
			System.out.println("\t-----------------------------------");
			System.out.println("1. Incluir");
			System.out.println("2. Listar Pessoas Cadastradas");
			System.out.println("3. Alterar");
			System.out.println("4. Excluir");
			System.out.println("5. Voltar ao menu anterior");
			System.out.println("6. Sair");
			System.out.println("Escolha sua opção"); // imprime o sub Menu e aguarda a esolha do usuario
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1: {
				System.out.println("-------------------");
				System.out.println("- INCLUIR PESSSOA -");
				System.out.println("-------------------");
				posicaoLinha = verificaPosicaoLivreMatriz(pessoa);// verifica se existem posicoes livres e atribui a
																	// variavel
				if (posicaoLinha == -1) {// se o metodo retornar -1 nao existem posicoes livres
					System.out.println("ATENCÃO, NÃO EXISTEM POSICOES LIVRES");
				} else { // se encontrar posicoes grava na matriz, nas posicoes que retornaram do metodo
					System.out.print("NOME: ");
					pessoa[posicaoLinha][0] = entrada.next().toUpperCase().trim();// para gravar todos os dados em
																					// maiusculo
					System.out.print("E-MAIL: ");
					pessoa[posicaoLinha][1] = entrada.next().toUpperCase().trim();
					System.out.println("CADASTRO REALIZADO COM SUCESSO!");
				}
				break;
			}
			case 2: {
				System.out.println("---------------------");// imprime a matriz e mostra se tem ou nao usuarios
															// cadastrados
				System.out.println("- LISTAR PESSOAS -");
				System.out.println("---------------------");
				for (int i = 0; i < pessoa.length; i++) {
					System.out.println("ID         NOME             E-MAIL");
					System.out.print(i + "  -  ");
					for (int j = 0; j < pessoa.length; j++) {
						System.out.print("     " + pessoa[i][j] + "  ");
					}
					System.out.println("");
				}
				break;
			}
			case 3: {
				int idPessoa;
				int existeCadastro;
				System.out.println("------------------");
				System.out.println("- ALTERAR PESSOA -");
				System.out.println("------------------");
				System.out.println("A seguir segue a lista de clientes cadastrados");
				for (int i = 0; i < pessoa.length; i++) {
					System.out.println("ID         NOME             E-MAIL");
					System.out.print(i + "  -  ");
					for (int j = 0; j < pessoa.length; j++) { // exibe os usuarios cadastrados
						System.out.print("     " + pessoa[i][j] + "  ");
					}
					System.out.println("");
				}
				System.out.println("Digite o ID da pessoa que quer alterar");
				idPessoa = entrada.nextInt();
				existeCadastro = verificaSeExistemPessoasCadastradas(pessoa, idPessoa);// chama o metodo que verifica
				if (existeCadastro != idPessoa) { // se tem cadastros com o mesmo id fornecido pelo usuario
					System.out.println("NÃO EXISTEM CADASTROS");// caso o valor retornado do metodo seja diferente do
																// valor
				} else { // que o usuario informou nao deixa alterar, mas se for
					System.out.print("Informe o novo Nome: "); // igual atribui o novos valores naquela posicao
					pessoa[existeCadastro][0] = entrada.next().toUpperCase().trim();
					System.out.print("Informe o novo E-mail: ");
					pessoa[existeCadastro][1] = entrada.next().toUpperCase().trim();// grava os dados todos em maiusculo
					System.out.println("PESSOA ALTERADA COM SUCESSO!");
				}
			}

				break;
			case 4: {
				int existeCadastro;
				int idPessoa;
				System.out.println("------------------");
				System.out.println("- EXCLUIR PESSOA -");
				System.out.println("------------------");
				System.out.println("A seguir segue a lista de clientes cadastrados");
				for (int i = 0; i < pessoa.length; i++) {
					System.out.println("ID         NOME             E-MAIL");
					System.out.print(i + "  -  ");
					for (int j = 0; j < pessoa.length; j++) { // exibe os usuarios cadastrados
						System.out.print("     " + pessoa[i][j] + "  ");
					}
					System.out.println("");
				}
				System.out.println("Digite o ID da pessoa que quer excluir");
				idPessoa = entrada.nextInt();
				existeCadastro = verificaSeExistemPessoasCadastradas(pessoa, idPessoa);
				if (existeCadastro == idPessoa) {
					pessoa[existeCadastro][0] = "";
					pessoa[existeCadastro][1] = "";
					System.out.println("EXCLUIDA COM SUCESSO");
				} else {
					System.out.println("NAO EXISTEM PESSOAS CADASTRADAS COM ESSE ID");
				}
			}
				break;
			case 5:
				menu();
				break;
			case 6:
				System.out.println("Saindo...");
				System.exit(6);
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
			}
		} while (opcao != 6);
	}

	public void categoriaObtejo() {
		int opcao;
		int posicaoLinha;
		do {
			System.out.println("\t------------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("\t Cadastro de Categorias dos Objetos ");
			System.out.println("\t------------------------------------");
			System.out.println("1. Incluir");
			System.out.println("2. Listar categorias Cadastradas");
			System.out.println("3. Alterar");
			System.out.println("4. Excluir");
			System.out.println("5. Voltar ao menu anterior");
			System.out.println("6. Sair");
			System.out.println("Escolha sua opção");
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1: {
				System.out.println("---------------------");
				System.out.println("- INCLUIR CATEGORIA -");
				System.out.println("---------------------");
				posicaoLinha = verificaPosicaoLivreVetor(categoriaFerramentas);
				if (posicaoLinha == -1) {
					System.out.println("NAO EXISTEM POSICOES LIVRES");
				} else {
					System.out.println("Nome da Categoria");
					categoriaFerramentas[posicaoLinha] = entrada.next();
				}
			}
				break;
			case 2:
				System.out.println("--------------------");
				System.out.println("- LISTAR CATEGORIA -");
				System.out.println("--------------------");
				for (int i = 0; i < categoriaFerramentas.length; i++) {
					System.out.println(i + "  -  " + categoriaFerramentas[i]);
				}
				break;
			case 3:
				System.out.println("---------------------");
				System.out.println("- ALTERAR CATEGORIA -");
				System.out.println("---------------------");
				break;
			case 4:
				System.out.println("---------------------");
				System.out.println("- EXCLUIR CATEGORIA -");
				System.out.println("---------------------");
				break;
			case 5:
				menu();
				break;
			case 6:
				System.out.println("SAINDO...");
				System.exit(6);
				break;
			default:
				System.out.println("OPCAO INDALIDA!");
			}
		} while (opcao != 6);

	}

	public void objetos() {
		int opcao;
		do {
			System.out.println("\t-----------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("\t       Cadastro de Objetos");
			System.out.println("\t-----------------------------------");
			System.out.println("1. Incluir");
			System.out.println("2. Listar objetos Cadastrados");
			System.out.println("3. Alterar");
			System.out.println("4. Excluir");
			System.out.println("5. Voltar ao menu anterior");
			System.out.println("6. Sair");
			System.out.println("Escolha sua opção");
			opcao = entrada.nextInt();
			switch (opcao) {

			case 1:
				System.out.println("------------------");
				System.out.println("- INCLUIR OBJETO -");
				System.out.println("------------------");
				break;
			case 2:
				System.out.println("--------------------");
				System.out.println("- CONSULTAR OBJETO -");
				System.out.println("--------------------");
				break;
			case 3:
				System.out.println("------------------");
				System.out.println("- ALTERAR OBJETO -");
				System.out.println("------------------");
				break;
			case 4:
				System.out.println("------------------");
				System.out.println("- EXCLUIR OBJETO -");
				System.out.println("------------------");
				break;
			case 5:
				menu();
				break;
			case 6:
				System.out.println("SAINDO...");
				System.exit(6);
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
			}
		} while (opcao != 6);
	}

	public void manutencao() {
		int opcao;
		do {
			System.out.println("\t-----------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("\t            Manutencoes            ");
			System.out.println("\t-----------------------------------");
			System.out.println("1. Incluir");
			System.out.println("2. Listar manutencoes");
			System.out.println("3. Alterar");
			System.out.println("4. Encerar Manutencao");
			System.out.println("5. Voltar ao menu anterior");
			System.out.println("6. Sair");
			System.out.println("Escolha sua opção");
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("----------------------");
				System.out.println("- INCLUIR MANUTENCAO -");
				System.out.println("----------------------");
				break;
			case 2:
				System.out.println("---------------------");
				System.out.println("- LISTAR MANUTENCAO -");
				System.out.println("---------------------");
				break;
			case 3:
				System.out.println("----------------------");
				System.out.println("- ALTERAR MANUTENCAO -");
				System.out.println("----------------------");
				break;
			case 4:
				System.out.println("----------------------");
				System.out.println("- ENCERAR MANUTENCAO -");
				System.out.println("----------------------");
				break;
			case 5:
				menu();
				break;
			case 6:
				System.out.println("SAINDO...");
				System.exit(6);
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
			}
		} while (opcao != 6);

	}

	public void realizarEmprestimo() {
		int opcao;
		do {
			System.out.println("\t-----------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("             EMPRESTIMOS             ");
			System.out.println("\t-----------------------------------");
			System.out.println("1. Incluir");
			System.out.println("2. Listar Emprestimos");
			System.out.println("3. Alterar");
			System.out.println("4. Encerar Emprestimo");
			System.out.println("5. Voltar ao menu anterior");
			System.out.println("6. Sair");
			System.out.println("Escolha sua opção");
			opcao = entrada.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("----------------------");
				System.out.println("- INCLUIR EMPRESTIMO -");
				System.out.println("----------------------");
				break;
			case 2:
				System.out.println("---------------------");
				System.out.println("- LISTAR EMPRESTIMO -");
				System.out.println("---------------------");
				break;
			case 3:
				System.out.println("----------------------");
				System.out.println("- ALTERAR EMPRESTIMO -");
				System.out.println("----------------------");
				break;
			case 4:
				System.out.println("----------------------");
				System.out.println("- ENCERAR EMPRESTIMO -");
				System.out.println("----------------------");
				break;
			case 5:
				menu();
				break;
			case 6:
				System.out.println("SAINDO...");
				System.exit(6);
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
			}
		} while (opcao != 6);

	}

	public void relatorios() {

	}

}