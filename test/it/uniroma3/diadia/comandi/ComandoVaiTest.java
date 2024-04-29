package it.uniroma3.diadia.comandi;

import org.junit.Test;
import static org.junit.Assert.*;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoVaiTest {

	@Test
	public void testEsegui_direzioneNulla() {
		Comando comandoVai = new ComandoVai(new IOConsole());
		comandoVai.setParametro(null);
		Partita partita = new Partita();
		comandoVai.esegui(partita);
		assertEquals(partita.getLabirinto().getStanzaIniziale(), partita.getStanzaCorrente());
	}

	@Test
	public void testEsegui_direzioneErrata() {
		Comando comandoVai = new ComandoVai(new IOConsole());
		Partita partita = new Partita();
		comandoVai.setParametro("destra");
		comandoVai.esegui(partita);
		assertEquals(partita.getLabirinto().getStanzaIniziale(), partita.getStanzaCorrente());
	}
	
	@Test
	public void testEsegui_direzioneNord() {
		Comando comandoVai = new ComandoVai(null);
		Partita partita = new Partita();
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		assertEquals("Biblioteca", partita.getStanzaCorrente().getNome());
	}
}
