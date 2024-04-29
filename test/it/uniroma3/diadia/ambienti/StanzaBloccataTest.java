package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Test;

public class StanzaBloccataTest {

	@Test
	public void getStanzaAdiacente_direzioneNonBloccata() {
		Stanza stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "piedediporco", "est");
		Stanza stanzaFinale = new Stanza("Uscita");
		stanzaBloccata.impostaStanzaAdiacente("ovest", stanzaFinale);
		assertEquals(stanzaFinale, stanzaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void getStanzaAdiacente_direzioneBloccata() {
		Stanza stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "piedediporco", "est");
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("est"));
	}

	@Test
	public void getStanzaAdiacente_direzioneSbloccata() {
		Stanza stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "piedediporco", "est");
		Stanza stanzaFinale = new Stanza("Uscita");
		stanzaBloccata.impostaStanzaAdiacente("est", stanzaFinale);
		stanzaBloccata.addAttrezzo(new Attrezzo("piedediporco", 5));
		assertEquals(stanzaFinale, stanzaBloccata.getStanzaAdiacente("est"));
	}
}
