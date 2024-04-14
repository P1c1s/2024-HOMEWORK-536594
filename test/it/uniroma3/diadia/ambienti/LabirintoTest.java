package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoTest {

	/* testGetsStanza* - INIZIO */
	
	@Test
	public void testGetStanzaCorrente_StanzaIniziale() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente_StanzaNonIniziale() {
		Labirinto labirinto = new Labirinto();
		labirinto.setStanzaCorrente(new Stanza("Aula N1"));
		assertEquals("Aula N1", labirinto.getStanzaCorrente().getNome());
	}
	

	
	@Test
	public void testGesStanzaVincente_NotNul() {
		Labirinto labirinto = new Labirinto();
		labirinto.setStanzaCorrente(new Stanza("Biblioteca"));
		assertEquals("Biblioteca", labirinto.getStanzaCorrente().getNome());
	}
	
	/* testGetsStanza* - FINE */
	
}
