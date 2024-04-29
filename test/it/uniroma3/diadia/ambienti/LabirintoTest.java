package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoTest {

	/* testGetsStanza* - INIZIO */
	
	@Test
	public void testGetStanzaIniziale_Atria() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaFinale_Biblioteca() {
		Labirinto labirinto = new Labirinto();
		assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
	}
	
	/* testGetsStanza* - FINE */
	
}
