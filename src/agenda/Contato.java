package agenda;

import java.util.Objects;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private Tags tags;
	
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tags = new Tags();
	}
	
	public String getNomeESobrenome() {
		return this.nome + " " + this.sobrenome;
	}
	
	public boolean adicionaTag(String nomeTag, int posicaoTag) {
		this.tags.adicionaTag(nomeTag, posicaoTag);
		return true;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	public String toString() {
		return this.nome + " " + this.sobrenome + "\n" + this.telefone + "\n" + this.tags.toString();
	}
}
