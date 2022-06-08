package agenda;

public class Tags {
	private String[] tags;
	
	public Tags() {
		this.tags = new String[5];
	}
	
	public boolean adicionaTag(String nomeTag, int posicaoTag) {
		if(posicaoTag < 1 || posicaoTag > 5) {
			return false;
		}
		this.tags[posicaoTag - 1] = nomeTag;
		return true;
	}
	
	public String toString() {
		String saida = "";
		for(int i = 0; i < this.tags.length; i++) {
			if(this.tags[i] != null) {
				saida += this.tags[i] + " ";
			}
		}
		return saida;
	}
}
