package agendaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Tags;

class TagsTest {
	Tags tags;
	
	@BeforeEach
	void preparaTags() {
		this.tags = new Tags();
	}
	
	@Test
	void testAdicionaTagNoLimteInferior() {
		String msg = "Adiciona uma tag no limite inferior, logo, posi��o 1, se adicionado com sucesso retorna 1";
		assertTrue(this.tags.adicionaTag("ufcg", 1), msg);
	}
	
	@Test
	void testAdicionaTagNoLimteInferiorIndisponivel() {
		String msg = "Adiciona uma tag no limite inferior que n�o existe, logo, posi��o 0, como a tag n�o ser� adicionada ele, retornar� false";
		assertFalse(this.tags.adicionaTag("ufcg", 0), msg);
	}
	
	@Test
	void testAdicionaTagNoLimteSuperiorIndisponivel() {
		String msg = "Adiciona uma tag no limite superior que n�o existe, logo, posi��o 6, como a tag n�o ser� adicionada ele, retornar� false";
		assertFalse(this.tags.adicionaTag("ufcg", 6), msg);
	}
	
	@Test
	void testAdicionaTagNoLimteSuperior() {
		String msg = "Adiciona uma tag no limite inferior, logo, posi��o 5, se adicionado com sucesso retorna 1";
		assertTrue(this.tags.adicionaTag("ufcg", 5), msg);
	}
	
	@Test
	void testSobrescritaDeTag() {
		String msg = "Se j� existe uma tag na posi��o e for adiciona outra na mesma posi��o, a mais recente ser� adicionada, se o toString tiver a �ltima"
				+ "tag adicionada, a tag UFCG foi substituida";
		this.tags.adicionaTag("UFCG", 1);
		this.tags.adicionaTag("Tomei o lugar da tag, hihihi", 1);
		assertEquals("Tomei o lugar da tag, hihihi ", this.tags.toString());
		
	}
	
	@Test
	void testToString() {
		String msg = "Testa a presenta��o de tags, uma representa��o de tags consiste no nome delas separado por espa�o";
		this.tags.adicionaTag("UFCG", 1);
		this.tags.adicionaTag("OBI", 3);
		this.tags.adicionaTag("Python", 2);
		assertEquals("UFCG Python OBI ", this.tags.toString());
	}

}
