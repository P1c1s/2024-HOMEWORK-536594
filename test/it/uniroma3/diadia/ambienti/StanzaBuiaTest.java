package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	@Test
	public void getDescrizione_buia() {
		Stanza stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
		assertEquals("Qui c'è un buio pesto", stanzaBuia.getDescrizione());
	}


	@Test
	public void getDescrizione_illuminata() {
		Stanza stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
		stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 3));
		assertNotEquals("Qui c'è un buio pesto", stanzaBuia.getDescrizione());
	}
	
}
