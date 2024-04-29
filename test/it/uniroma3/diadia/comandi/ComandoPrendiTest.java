package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {


	@Test
	public void testEsegui_AttrezzoNull() {
		Comando comandoPrendi = new ComandoPrendi(new IOConsole());
		comandoPrendi.setParametro(null);
		Partita partita = new Partita();
		comandoPrendi.esegui(partita);
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("osso"));
	}

	@Test
	public void testEsegui_prendiUnicoAttrezzoStanza() {
		Comando comandoPrendi = new ComandoPrendi(new IOConsole());
		comandoPrendi.setParametro("osso");
		Partita partita = new Partita();
		comandoPrendi.esegui(partita);
		assertEquals("osso", partita.getGiocatore().getBorsa().getAttrezzo("osso").getNome());
	}
	
	@Test
	public void testEsegui_prendiAttrezzoDueDellaStanza() {
		Comando comandoPrendi = new ComandoPrendi(new IOConsole());
		comandoPrendi.setParametro("penna");
		Partita partita = new Partita();
		Attrezzo penna = new Attrezzo("penna", 0);
		partita.getGiocatore().getBorsa().addAttrezzo(penna);
		comandoPrendi.esegui(partita);
		assertEquals("penna", partita.getGiocatore().getBorsa().getAttrezzo("penna").getNome());
	}
}
