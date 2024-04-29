package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String attrezzoPassepartout;
	private String direzioneBloccatta;

	public StanzaBloccata(String nome, String nomeAttrezzo, String direzioneBloccata) {
		super(nome);
		this.attrezzoPassepartout = nomeAttrezzo;
		this.direzioneBloccatta = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        if(!this.hasAttrezzo(attrezzoPassepartout) && direzioneBloccatta.equals(direzione))
        	return this;
        return super.getStanzaAdiacente(direzione);

	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.attrezzoPassepartout))
			return "Stanza con direzione [" + direzioneBloccatta + "] bloccata";
		return super.getDescrizione();
	}

}
