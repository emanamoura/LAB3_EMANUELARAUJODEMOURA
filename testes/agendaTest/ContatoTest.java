package agendaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

class ContatoTest {
	
	private Contato contato;
	
	@BeforeEach
	void preparaContato() {
		this.contato = new Contato("Matheus", "Gaudencio", "555-5551");
	}

	@Test
	void testGetNomeESobrenome() {
		String msg = "Esperando o nome completo do contato";
		assertEquals("Matheus Gaudencio", this.contato.getNomeESobrenome(), msg);
	}

	@Test
	void testAdicionaTag() {
		String msg = "Adiciona uma tag a um contato";
		assertTrue(this.contato.adicionaTag("ufcg", 1), msg);
	}

	@Test
	void testEqualsObject() {
		String msg = "Para dois contatos serem iguais, é necessário ter nome e sobrenome iguais";
		Contato contatoASerComparado = new Contato("Matheus","Gaudencio", "1234-45698");
		assertTrue(this.contato.equals(contatoASerComparado), msg);
	}
	
	@Test
	void testEqualsComobreSobrenomeDiferente() {
		String msg = "Para dois contatos serem diferentes, é necessário ter nome completo diferente, testando com sobrenome diferente";
		Contato contatoASerComparado = new Contato("Matheus","Moura", "1234-45698");
		assertFalse(this.contato.equals(contatoASerComparado), msg);
	}
	
	@Test
	void testEqualsComNomeDiferente() {
		String msg = "Para dois contatos serem diferentes, é necessário ter nome completo diferente, testando com nome diferente";
		Contato contatoASerComparado = new Contato("Emanuel","Gaudencio", "1234-45698");
		assertFalse(this.contato.equals(contatoASerComparado), msg);
	}
	
	@Test
	void testEqualsComNomeComppletoDiferente() {
		String msg = "Para dois contatos serem diferentes, é necessário ter nome completo diferente, testando com nome diferente";
		Contato contatoASerComparado = new Contato("Alice","Thainá", "1245-5848");
		assertFalse(this.contato.equals(contatoASerComparado), msg);
	}

	@Test
	void testToString() {
		String msg = "Contato deve ser representado da seguinte forma: Matheus Gaudencio\n555-5551\n";
		assertEquals("Matheus Gaudencio\n555-5551\n", this.contato.toString(), msg);
	}
	
	@Test
	void testToStringComTags() {
		String msg = "Contato deve ser representado da seguinte forma: Matheus Gaudencio\n555-5551\nufcg "
				+ " Existe tags, logo, ela aparece abaixo do telefone";
		this.contato.adicionaTag("ufcg", 1);
		assertEquals("Matheus Gaudencio\n555-5551\nufcg ", this.contato.toString(),msg);
	}

}
