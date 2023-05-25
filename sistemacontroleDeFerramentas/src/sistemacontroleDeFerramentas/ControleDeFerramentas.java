package sistemacontroleDeFerramentas;

import java.io.InputStream;
import java.util.Scanner;

public class ControleDeFerramentas {
	// criando os vetores
	static String[] categoriaFerramentas = new String[3];
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

	public int verificaSeExistemCadastrosMatriz(String[][] matriz, int id) {
		int existeCadastro = -1;
		for (int i = 0; i < matriz.length; i++) { // recebe por paramentro uma matriz e o id da pessoa, verifica se
			for (int j = 0; j < matriz.length; j++) { // existe aquele id cadastrado, e se tiver algum dado gravado
														// naquele id, passa aquela posicao pra variavel existeCadastro
				if (i == id && matriz[i][1] != "") {
					existeCadastro = i;
					i = matriz.length;
				}
			}
		}
		return existeCadastro;
	}

	public int verificaSeExistemCadastrosVetor(String vetor[], int id) {
		int existeCadastro = -1;
		for (int i = 0; i < vetor.length; i++) {
			if (i == id && vetor[i] == "") {
				existeCadastro = i;
				i = vetor.length;
			}
		}
		return existeCadastro;
	}

	public void listaPessoas() {
		for (int i = 0; i < pessoa.length; i++) {
			System.out.println("ID         NOME        E-MAIL");
			System.out.print(i + "  -  ");
			for (int j = 0; j < pessoa.length; j++) {
				System.out.print("     " + pessoa[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public void listaCategoriaFerramentas() {
		for (int i = 0; i < categoriaFerramentas.length; i++) {
			System.out.println(i + "  -  " + categoriaFerramentas[i]);
		}
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
				categoriaFerramenta();
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

	public int subMenu() {
		System.out.println("1. Incluir");
		System.out.println("2. Listar");
		System.out.println("3. Alterar");
		System.out.println("4. Excluir/Encerrar");
		System.out.println("5. Voltar ao menu anterior");
		System.out.println("6. Sair");
		System.out.println("Escolha sua opção"); // imprime o sub Menu e aguarda a esolha do usuario
		int opcao = entrada.nextInt();
		return opcao;
	}

	public void pessoa() {
		int opcao = 0;
		int posicaoLinha;
		do {
			System.out.println("\t-----------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("\t       Cadastro de Pessoas");
			System.out.println("\t-----------------------------------");
			opcao = subMenu();// chama o metodo subMenu, reutilizacao de codigo
			switch (opcao) {
			case 1: {
				System.out.println("-------------------");
				System.out.println("- INCLUIR PESSSOA -");
				System.out.println("-------------------");
				posicaoLinha = verificaPosicaoLivreMatriz(pessoa);// verifica se existem posicoes livres e atribui a variavel
																 // se o metodo retornar -1 nao existem posicoes livres
				if (posicaoLinha == -1) {	
					System.out.println("ATENCÃO, NÃO EXISTEM POSICOES LIVRES");
				} else { 
					System.out.print("NOME: ");// se encontrar posicoes grava na matriz, nas posicoes que retornaram do metodo
					pessoa[posicaoLinha][0] = entrada.next().toUpperCase().trim();// para gravar todos os dados em
																					// maiusculo e na linha que o metodo
					System.out.print("E-MAIL: "); // verificaPosiçãoLivreMatriz achou vazia
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
				listaPessoas();
				break;
			}
			case 3: {
				int idPessoa;
				int existeCadastro;
				System.out.println("------------------");
				System.out.println("- ALTERAR PESSOA -");
				System.out.println("------------------");
				System.out.println("A seguir segue a lista de clientes cadastrados");
				listaPessoas(); // chamada de metodo para listar pessoas, reutilizacao de codigo

				System.out.println("Digite o ID da pessoa que quer alterar");
				idPessoa = entrada.nextInt();
				existeCadastro = verificaSeExistemCadastrosMatriz(pessoa, idPessoa);// chama o metodo que verifica

				if (existeCadastro != idPessoa) { 				// se tem cadastros com o mesmo id fornecido pelo usuario
					System.out.println("NÃO EXISTEM CADASTROS");// caso o valor retornado do metodo seja diferente do
																// valor que o usuario informou nao deixa alterar, mas
																// se for
				} else { 										// igual atribui o novos valores naquela posicao
					System.out.print("Informe o novo Nome: ");
					pessoa[existeCadastro][0] = entrada.next().toUpperCase().trim();// grava os dados todos em maiusculo,																					
					System.out.print("Informe o novo E-mail: "); 					// na posicao que retornou do metodo
					pessoa[existeCadastro][1] = entrada.next().toUpperCase().trim();
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
				listaPessoas(); // chamada de metodo para listar pessoas, reutilizacao de codigo

				System.out.println("Digite o ID da pessoa que quer excluir");
				idPessoa = entrada.nextInt();
				existeCadastro = verificaSeExistemCadastrosMatriz(pessoa, idPessoa);
				if (existeCadastro == idPessoa) { // se encontrar na matriz um id igual ao digitado pelo usuario
					pessoa[existeCadastro][0] = ""; // todos os indices daquela linha recebem aspas duplas sse não
					pessoa[existeCadastro][1] = ""; // avisa que tem não tem pessoas com esse id
					System.out.println("EXCLUIDA COM SUCESSO");
				} else {
					System.out.println("NAO EXISTEM PESSOAS CADASTRADAS COM ESSE ID");
				}
			}
				break;
			case 5: {
				menu(); // chamada do menu principal
			}
				break;
			case 6: {
				System.out.println("Saindo..."); // saindo do sistema
				System.exit(6);
			}
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
			}
		} while (opcao != 6); // vai repetir o menu principal até ser igual a 6
	}

	public void categoriaFerramenta() {
		int opcao;
		int posicaoLinha;
		do {
			System.out.println("\t------------------------------------");
			System.out.println("\t Sistema de Emprestimos de Objetos ");
			System.out.println("\t Cadastro de Categorias dos Objetos ");
			System.out.println("\t------------------------------------");
			opcao = subMenu();
			switch (opcao) {
			case 1: {
				System.out.println("---------------------");
				System.out.println("- INCLUIR CATEGORIA -");
				System.out.println("---------------------");
				posicaoLinha = verificaPosicaoLivreVetor(categoriaFerramentas);
				if (posicaoLinha == -1) {
					System.out.println("NAO EXISTEM POSICOES LIVRES");
				} else {
					System.out.println("Nome da Categoria"); // mesmo funcionamento do metodo Pessoa
					categoriaFerramentas[posicaoLinha] = entrada.next();
				}
			}
				break;
			case 2: {
				System.out.println("--------------------");
				System.out.println("- LISTAR CATEGORIA -");
				System.out.println("--------------------");
				listaCategoriaFerramentas();
			}
				break;
			case 3: {
				System.out.println("---------------------");
				System.out.println("- ALTERAR CATEGORIA -");
				System.out.println("---------------------");
				System.out.println("A seguir segue a lista de clientes cadastrados");
				listaCategoriaFerramentas(); // chamada de metodo para listar pessoas, reutilizacao de codigo

				System.out.println("Digite o ID da Categoria que quer alterar");
				int idCategoria = entrada.nextInt();

				int existeCadastro = verificaSeExistemCadastrosVetor(categoriaFerramentas, idCategoria);

				if (existeCadastro != idCategoria) { // verifica se tem cadastros com o mesmo id fornecido pelo usuario,
					System.out.println("NÃO EXISTEM CADASTROS");// caso o valor retornado do metodo seja diferente do																
				} else { 										// valor que o usuario informou nao deixa alterar, mas se for
					System.out.print("Informe o novo Nome: "); // igual atribui o novos valores naquela posicao
					categoriaFerramentas[existeCadastro] = entrada.next().toUpperCase().trim();// grava os dados todos em maiusculo,
					System.out.println("PESSOA ALTERADA COM SUCESSO!"); 						// na posicao que retornou do metodo
					
				}
			}
				break;
			case 4: {
				System.out.println("---------------------");
				System.out.println("- EXCLUIR CATEGORIA -");
				System.out.println("---------------------");
				System.out.println("A seguir segue a lista de categorias cadastrados");
				listaCategoriaFerramentas(); // chamada de metodo para listar pessoas, reutilizacao de codigo

				System.out.println("Digite o ID da categoria que quer excluir");
				int idCategoria = entrada.nextInt();
				int existeCadastro = verificaSeExistemCadastrosVetor(categoriaFerramentas, idCategoria);
				if (existeCadastro == idCategoria) { // se encontrar na matriz um id igual ao digitado pelo usuario
					categoriaFerramentas[existeCadastro] = ""; // todos os indices daquela linha recebem aspas duplas
																// sse não
					categoriaFerramentas[existeCadastro] = ""; // avisa que tem não tem pessoas com esse id
					System.out.println("EXCLUIDA COM SUCESSO");
				} else {
					System.out.println("NAO EXISTEM PESSOAS CADASTRADAS COM ESSE ID");
				}
			}
				break;
			case 5: {
				menu();
			}
				break;
			case 6: {
				System.out.println("SAINDO...");
				System.exit(6);
			}
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
			opcao = subMenu();
			switch (opcao) {

			case 1: {
				System.out.println("------------------");
				System.out.println("- INCLUIR OBJETO -");
				System.out.println("------------------");
			}
				break;
			case 2: {
				System.out.println("--------------------");
				System.out.println("- CONSULTAR OBJETO -");
				System.out.println("--------------------");
			}
				break;
			case 3: {
				System.out.println("------------------");
				System.out.println("- ALTERAR OBJETO -");
				System.out.println("------------------");
			}
				break;
			case 4: {
				System.out.println("------------------");
				System.out.println("- EXCLUIR OBJETO -");
				System.out.println("------------------");
			}
				break;
			case 5: {
				menu();
			}
				break;
			case 6: {
				System.out.println("SAINDO...");
				System.exit(6);
			}
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
			opcao = subMenu();
			switch (opcao) {
			case 1: {
				System.out.println("----------------------");
				System.out.println("- INCLUIR MANUTENCAO -");
				System.out.println("----------------------");
			}
				break;
			case 2: {
				System.out.println("---------------------");
				System.out.println("- LISTAR MANUTENCAO -");
				System.out.println("---------------------");
			}
				break;
			case 3: {
				System.out.println("----------------------");
				System.out.println("- ALTERAR MANUTENCAO -");
				System.out.println("----------------------");
			}
				break;
			case 4: {
				System.out.println("----------------------");
				System.out.println("- ENCERAR MANUTENCAO -");
				System.out.println("----------------------");
			}
				break;
			case 5: {
				menu();
			}
				break;
			case 6: {
				System.out.println("SAINDO...");
				System.exit(6);
			}
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
			opcao = subMenu();
			switch (opcao) {
			case 1: {
				System.out.println("----------------------");
				System.out.println("- INCLUIR EMPRESTIMO -");
				System.out.println("----------------------");
			}
				break;
			case 2: {
				System.out.println("---------------------");
				System.out.println("- LISTAR EMPRESTIMO -");
				System.out.println("---------------------");
			}
				break;
			case 3: {
				System.out.println("----------------------");
				System.out.println("- ALTERAR EMPRESTIMO -");
				System.out.println("----------------------");
			}
				break;
			case 4: {
				System.out.println("----------------------");
				System.out.println("- ENCERAR EMPRESTIMO -");
				System.out.println("----------------------");
			}
				break;
			case 5: {
				menu();
			}
				break;
			case 6: {
				System.out.println("SAINDO...");
				System.exit(6);
			}
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
			}
		} while (opcao != 6);

	}

	public void relatorios() {

	}

}