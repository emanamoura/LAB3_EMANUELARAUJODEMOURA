package agenda;

import java.util.Objects;

public class Favorito {
	Contato contato;
	
	public Favorito(Contato contatoFavorito) {
		this.contato = contatoFavorito;
	}
	
	public String getNomEESobrenome() {
		return this.contato.getNomeESobrenome();
	}
	
	public String toString() {
		return "❤️ " + contato.toString(); 
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorito other = (Favorito) obj;
		return Objects.equals(contato, other.contato);
	}
	
}
