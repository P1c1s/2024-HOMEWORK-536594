package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	@Test
	public void testEsegui() {
		Comando comandoPosa = new ComandoPosa(new IOConsole());
		comandoPosa.setParametro(null);
		Partita partita = new Partita();
		comandoPosa.esegui(partita);
		assertEquals(partita.getLabirinto().getStanzaIniziale(), partita.getStanzaCorrente());
	}

	@Test
	public void testEsegui_posaUnicoAttrezzoStanza() {
		Comando comandoPosa = new ComandoPosa(new IOConsole());
		comandoPosa.setParametro("calamaio");
		Partita partita = new Partita();
		partita.getGiocatore().getBorsa().addAttrezzo( new Attrezzo("calamaio", 1));
		comandoPosa.esegui(partita);
		assertEquals("calamaio", partita.getStanzaCorrente().getAttrezzo("calamaio").getNome());
	}
	
	@Test
	public void testEsegui_posaAttrezziStanza() {
		Comando comandoPosa = new ComandoPosa(new IOConsole());
		comandoPosa.setParametro("penna");
		Partita partita = new Partita();
		partita.getGiocatore().getBorsa().addAttrezzo( new Attrezzo("calamaio", 1));
		partita.getGiocatore().getBorsa().addAttrezzo( new Attrezzo("penna", 1));
		partita.getGiocatore().getBorsa().addAttrezzo( new Attrezzo("matita", 1));
		comandoPosa.esegui(partita);
		assertEquals("penna", partita.getStanzaCorrente().getAttrezzo("penna").getNome());
	}
}
