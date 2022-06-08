package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa � a maneira de lidar com possiveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usu�rio/a.
	 * 
	 * @param scanner Para captura da op��o do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" +
						"(E)xibir contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" + 
						"(R)emover contato\n" + 
						"(S)air" +
						"\n" + 
						"Op��o> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema.
	 * 
	 * @param opcao op��o digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "F":
			exibeFavoritos(agenda);
			break;
		case "T":
			adicionaTags(agenda, scanner);
			break;
		case "A":
			adicionaFavoritos(agenda, scanner);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "R":
			removeContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OP��O INV�LIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.println(agenda.toString());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println("Dados do contato:\n" + agenda.exibeContato(posicao));
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informa��es do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
	}
	
	private static void exibeFavoritos(Agenda agenda) {
		System.out.println(agenda.exibeFavoritos());
	}
	
	private static void adicionaFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int posicaoFavorito = scanner.nextInt();
		System.out.println(agenda.adicionaFavorito(posicaoContato, posicaoFavorito));
	}
	
	private static void adicionaTags(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato(s)> ");
		scanner.nextLine();
		String contatos = scanner.nextLine();
		System.out.print(contatos);
		System.out.print("\nTag> ");
		String nomeDaTag = scanner.next();
		System.out.print(nomeDaTag);
		System.out.print("\nPosicao tag> ");
		int posicaoTag = scanner.nextInt();
		System.out.print(posicaoTag);
		agenda.adicionaTagsAContatos(contatos, nomeDaTag, posicaoTag);
	}
	
	private static void removeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato(s)>");
		int posicaoContato = scanner.nextInt();
		agenda.removeContatoDeAgenda(posicaoContato);
	}
	/**
	 * Sai da aplica��o.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
