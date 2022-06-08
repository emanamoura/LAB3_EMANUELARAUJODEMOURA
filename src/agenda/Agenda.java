package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_LISTA_FAVORITOS = 10;
	
	private Contato[] contatos;
	private Favorito[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Favorito[TAMANHO_LISTA_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	private Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}

	/**
	 * Cadastra um contato em uma posi��o. Um cadastro em uma posi��o que j� existe sobrescreve o anterior. 
	 * @param posicao Posi��o do contato.
	 * @param nome Nome do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if(posicao < 1 || posicao > 100) {
			return "POSI��O INV�LIDA";
		}
		Contato contatoArray = this.contatos[posicao - 1];
		Contato contato = new Contato(nome, sobrenome, telefone);
		if(this.isContato(contato) == true) {
			return "CONTATO JA CADASTRADO";
		}
		if(nome.isBlank() == true || telefone.isBlank()) {
			return "CONTATO INVALIDO";
		}
		this.contatos[posicao - 1] = contato;
		return "CADASTRO REALIZADO";
	}
	
	public String exibeContato(int posicao) {
		if(posicao < 1 || posicao > 100) {
			return "POSICAO INV�LIDA";
		}
		Contato contato = getContato(posicao);
		if(contato == null) {
			return "POSICAO INV�LIDA";
		}
		Favorito favorito = isFavorito(contato);
		if(favorito != null) {
			return favorito.toString();
		}
		return contato.toString();
	}
	
	public String adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		Contato contato = this.getContato(posicaoContato);
		if(isFavorito(contato) != null) {
			return "CONTATO J� � FAVORITO";
		}
		this.favoritos[posicaoFavorito - 1] = new Favorito(contato);
		return "CONTATO FAVORITADO NA POSICAO " + posicaoFavorito + "!";
		
	}
	
	public String exibeFavoritos() {
		String saida = "";
		for(int i = 0; i < this.favoritos.length; i++) {
			if(this.favoritos[i] == null) {
				continue;
			}
			saida += (i + 1) + " - " + this.favoritos[i].getNomEESobrenome() + "\n";
		}
		if(saida.equals("")) {
			return "N�O H� FAVORITOS CADASTRADOS !";
		}
		return saida;
	}
	
	private Favorito isFavorito(Contato contato) {
		Favorito favorito = new Favorito(contato);
		for(int i = 0; i < this.favoritos.length; i++) {
			if(this.favoritos[i] == null) {
				continue;
			}
			if(this.favoritos[i].equals(favorito)) {
				return this.favoritos[i];
			}
		}
		return null;
	}
	
	public boolean adicionaTagsAContatos(String posicaoContatos, String nomeDaTag, int posicaoTag) {
		String[] contatos = posicaoContatos.split(" ");
		for(int i = 0; i < contatos.length; i++) {
			int posicaoContato = Integer.parseInt(contatos[i]) - 1;
			if(this.contatos[posicaoContato].adicionaTag(nomeDaTag, posicaoTag) == false) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isContato(Contato contato) {
		for(int i = 0; i < this.contatos.length; i++) {
			if(this.contatos[i] != null) {
				if(this.contatos[i].equals(contato)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String removeContatoDeAgenda(int posicaoContato) {
		Contato contato = this.getContato(posicaoContato);
		if(this.isContato(contato)) {
			return "POSIÇÃO INVÁLIDA";
		}
		this.contatos[posicaoContato + 1] = null;
		return "";
	}	
	
	public String toString() {
		String saida = "";
		for(int i = 0; i < this.contatos.length; i++) {
			Contato contatoAtual = this.contatos[i];
			if(contatoAtual != null) {
				if(i == this.contatos.length - 1) {
					saida += (i + 1) + " - "+ contatoAtual.getNomeESobrenome();
				}
				saida += (i + 1) + " - "+ contatoAtual.getNomeESobrenome() + "\n"; 
			}
		}
		return saida;
	}

}
