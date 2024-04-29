package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza {

	private String attrezzoLuminoso;

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.attrezzoLuminoso = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.attrezzoLuminoso))
			return "Qui c'è un buio pesto";
		return super.getDescrizione();
	}
}
