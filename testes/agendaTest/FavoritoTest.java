package agendaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;
import agenda.Favorito;

class FavoritoTest {
	private Favorito favorito;
	
	@BeforeEach
	void preparaFavorito() {
		Contato contatoFavorito = new Contato("Matheus", "Gaudencio", "555-5551");
		this.favorito = new Favorito(contatoFavorito);
	}
	
	@Test
	void testGetNomEESobrenome() {
		String msg = "Testa se retorna o nome completo do contato favorito";
		assertEquals("Matheus Gaudencio", this.favorito.getNomEESobrenome(), msg);
	}

	@Test
	void testToString() {
		String msg = "Retorna a forma de representa��o de um favorito, todo favorito tem um cora��o";
		assertEquals("❤️ Matheus Gaudencio\n555-5551\n", this.favorito.toString(), msg);
	}

	@Test
	void testEqualsObject() {
		String msg = "Para um contato favorito ser igual a outra, � necess�rio que ele seja o mesmo contato e que seja favorito";
		Contato contatoFavorito = new Contato("Matheus", "Gaudencio", "555-5551");
		Favorito favoritoASerComparado = new Favorito(contatoFavorito);
		assertTrue(this.favorito.equals(favoritoASerComparado), msg);
	}

}
