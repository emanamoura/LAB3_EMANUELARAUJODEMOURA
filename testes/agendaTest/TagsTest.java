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
		String msg = "Adiciona uma tag no limite inferior, logo, posição 1, se adicionado com sucesso retorna 1";
		assertTrue(this.tags.adicionaTag("ufcg", 1), msg);
	}
	
	@Test
	void testAdicionaTagNoLimteInferiorIndisponivel() {
		String msg = "Adiciona uma tag no limite inferior que não existe, logo, posição 0, como a tag não será adicionada ele, retornará false";
		assertFalse(this.tags.adicionaTag("ufcg", 0), msg);
	}
	
	@Test
	void testAdicionaTagNoLimteSuperiorIndisponivel() {
		String msg = "Adiciona uma tag no limite superior que não existe, logo, posição 6, como a tag não será adicionada ele, retornará false";
		assertFalse(this.tags.adicionaTag("ufcg", 6), msg);
	}
	
	@Test
	void testAdicionaTagNoLimteSuperior() {
		String msg = "Adiciona uma tag no limite inferior, logo, posição 5, se adicionado com sucesso retorna 1";
		assertTrue(this.tags.adicionaTag("ufcg", 5), msg);
	}
	
	@Test
	void testSobrescritaDeTag() {
		String msg = "Se já existe uma tag na posição e for adiciona outra na mesma posição, a mais recente será adicionada, se o toString tiver a última"
				+ "tag adicionada, a tag UFCG foi substituida";
		this.tags.adicionaTag("UFCG", 1);
		this.tags.adicionaTag("Tomei o lugar da tag, hihihi", 1);
		assertEquals("Tomei o lugar da tag, hihihi ", this.tags.toString());
		
	}
	
	@Test
	void testToString() {
		String msg = "Testa a presentação de tags, uma representação de tags consiste no nome delas separado por espaço";
		this.tags.adicionaTag("UFCG", 1);
		this.tags.adicionaTag("OBI", 3);
		this.tags.adicionaTag("Python", 2);
		assertEquals("UFCG Python OBI ", this.tags.toString());
	}

}
