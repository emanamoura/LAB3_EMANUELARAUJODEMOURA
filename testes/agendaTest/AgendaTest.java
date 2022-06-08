package agendaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

class AgendaTest {
	Agenda agenda;
	
	@BeforeEach
	void preparaAgenda() {
		this.agenda = new Agenda();
	}

	@Test
	void testGetContatos() {
	}

	@Test
	void testCadastraContatoLimiteInferior() {
		String msg = "Cadastra um contato, n�o � poss�vel cadastrar um contato em uma posi��o inv�lida, umna posi��o inv�lida � menor que 1 e maior que 100";
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1,"Matheus" , "Gaudencio", "(83) 21011585"), msg);
	}
	
	@Test
	void testCadastraContatoLimiteInferiorInvalido() {
		String msg = "Cadastra um contato, n�o � poss�vel cadastrar um contato em uma posi��o inv�lida, umna posi��o inv�lida � menor que 1 e maior que 100";
		assertEquals("POSI��O INV�LIDA", this.agenda.cadastraContato(0,"Matheus" , "Gaudencio", "(83) 21011585"), msg);
	}
	
	@Test
	void testCadastraContatoLimiteSuperior() {
		String msg = "Cadastra um contato, n�o � poss�vel cadastrar um contato em uma posi��o inv�lida, umna posi��o inv�lida � menor que 1 e maior que 100";
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(100,"Matheus" , "Gaudencio", "(83) 21011585"), msg);
	}
	
	@Test
	void testCadastraContatoLimiteSuperiorInvalido() {
		String msg = "Cadastra um contato, n�o � poss�vel cadastrar um contato em uma posi��o inv�lida, umna posi��o inv�lida � menor que 1 e maior que 100";
		assertEquals("POSI��O INV�LIDA", this.agenda.cadastraContato(101,"Matheus" , "Gaudencio", "(83) 21011585"), msg);
	}
	
	@Test
	void testCadastraContatoIgual() {
		String msg = "Se um contato for igual a outro, n�o � poss�vel fazer o cadastro";
		this.agenda.cadastraContato(1,"Matheus", "Gaudencio", "1111-1111");
		assertEquals("CONTATO JA CADASTRADO", this.agenda.cadastraContato(1,"Matheus" , "Gaudencio", "(83) 21011585"), msg);
	}
	
	@Test
	void testCadastraContatoIgualEmPosicaoDiferente() {
		String msg = "Se um contato for igual a outro, n�o � poss�vel fazer o cadastro";
		this.agenda.cadastraContato(1,"Matheus", "Gaudencio", "1111-1111");
		assertEquals("CONTATO JA CADASTRADO", this.agenda.cadastraContato(3,"Matheus", "Gaudencio", "1111-1111"), msg);
	}
	
	@Test
	void testCadastraContatoComNomeVazio() {
		String msg = "N�o � poss�vel cadastrar um contato com nome vazio";
		assertEquals("CONTATO INVALIDO", this.agenda.cadastraContato(3,"", "Gaudencio", "1111-1111"), msg);
	}
	
	@Test
	void testCadastraContatoComTelefoneVazio() {
		String msg = "N�o � poss�vel cadastrar um contato com nome vazio";
		assertEquals("CONTATO INVALIDO", this.agenda.cadastraContato(3,"Matheus", "Gaudencio", ""), msg);
	}
	
	@Test
	void testExibeContato() {
		String msg = "Se a posicao for inv�lida, uma mensagem � exibida";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		assertEquals("Matheus Gaudencio\n1111-41111\n", this.agenda.exibeContato(1));	
	}
	
	@Test
	void testExibeContatoComPosicaoSuperior() {
		String msg = "Se a posicao for inv�lida, uma mensagem � exibida";
		this.agenda.cadastraContato(100, "Matheus","Gaudencio", "1111-41111");
		assertEquals("Matheus Gaudencio\n1111-41111\n", this.agenda.exibeContato(100));
		
	}
	
	@Test
	void testExibeContatoComPosicaoSuperiorInvalida() {
		String msg = "Se a posicao for inv�lida, uma mensagem � exibida";
		this.agenda.cadastraContato(101, "Matheus","Gaudencio", "1111-41111");
		assertEquals("POSICAO INV�LIDA", this.agenda.exibeContato(101));
		
	}

	@Test
	void testExibeContatoComPosicaInferiorInvalida() {
		String msg = "Se a posicao for inv�lida, uma mensagem � exibida";
		this.agenda.cadastraContato(0, "Matheus","Gaudencio", "1111-41111");
		assertEquals("POSICAO INV�LIDA", this.agenda.exibeContato(0));
		
	}
	
	@Test
	void testExibeContatoComInferior() {
		String msg = "Se a posicao for inv�lida, uma mensagem � exibida";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		assertEquals("Matheus Gaudencio\n1111-41111\n", this.agenda.exibeContato(1));
		
	}

	
	@Test
	void testExibeContatoFavorito() {
		String msg = "Se o contato for favorito, h� uma representa��o especial";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals("❤️ Matheus Gaudencio\n1111-41111\n", this.agenda.exibeContato(1));
	}

	@Test
	void testAdicionaFavorito() {
		String msg = "Um contato favorito tem uma representa��o especial , com cora��o";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		assertEquals("CONTATO FAVORITADO NA POSICAO 1!", this.agenda.adicionaFavorito(1, 1));
		
	}
	
	@Test
	void testAdicionaFavoritoJaFavoritado() {
		String msg = "Um contato favorito, n�o pode ser mais favorito outra vez";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		 this.agenda.adicionaFavorito(1, 1);
		assertEquals("CONTATO J� � FAVORITO", this.agenda.adicionaFavorito(1, 1));
		
	}

	@Test
	void testExibeFavoritos() {
		String msg = "Exibe os contatos favoritos";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.cadastraContato(2, "Nunu","Gaudencio", "1111-41111");
		this.agenda.cadastraContato(3, "Alice","Gaudencio", "1111-41111");
		this.agenda.adicionaFavorito(1, 1);
		this.agenda.adicionaFavorito(2, 2);
		this.agenda.adicionaFavorito(3, 3);
		assertEquals("1 - Matheus Gaudencio\n2 - Nunu Gaudencio\n3 - Alice Gaudencio\n", this.agenda.exibeFavoritos());
	}
	
	@Test
	void testExibeFavoritosInexistentes() {
		String msg = "Se n�o existe fgavoritos, o sistema avisa";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.cadastraContato(2, "Nunu","Gaudencio", "1111-41111");
		this.agenda.cadastraContato(3, "Alice","Gaudencio", "1111-41111");
		assertEquals("N�O H� FAVORITOS CADASTRADOS !", this.agenda.exibeFavoritos());
	}
	
	@Test
	void testAdicionaTagsAContatosEmMaisDeUmContato() {
		String msg = "Adiciona tags em um ou mais contatos.";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.cadastraContato(2, "Nunu","Gaudencio", "1111-41111");
		this.agenda.cadastraContato(3, "Alice","Gaudencio", "1111-41111");
		this.agenda.adicionaTagsAContatos("1 2 3", "ufcg", 1);
		assertEquals("Matheus Gaudencio\n1111-41111\nufcg ", this.agenda.exibeContato(1));
		assertEquals("Nunu Gaudencio\n1111-41111\nufcg ", this.agenda.exibeContato(2));
		assertEquals("Alice Gaudencio\n1111-41111\nufcg ", this.agenda.exibeContato(3));
	}
	
	@Test
	void testAdicionaTagsAContatosEmLimiteInferiorDaTag() {
		String msg = "Adiciona tags em um ou mais contatos.";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.adicionaTagsAContatos("1", "ufcg", 1);
		assertEquals("Matheus Gaudencio\n1111-41111\nufcg ", this.agenda.exibeContato(1));
	}
	
	@Test
	void testAdicionaTagsAContatosEmLimiteSuperiorDaTag() {
		String msg = "Adiciona tags em um ou mais contatos.";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.adicionaTagsAContatos("1", "ufcg", 5);
		assertEquals("Matheus Gaudencio\n1111-41111\nufcg ", this.agenda.exibeContato(1));
	}
	
	@Test
	void testAdicionaTagsAContatosEmLimiteSuperiorInvalidoDaTag() {
		String msg = "Adiciona tags em um ou mais contatos.";
		this.agenda.cadastraContato(1, "Matheus","Gaudencio", "1111-41111");
		this.agenda.adicionaTagsAContatos("1", "ufcg", 6);
		assertEquals("Matheus Gaudencio\n1111-41111\nufcg ", this.agenda.exibeContato(1));
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
