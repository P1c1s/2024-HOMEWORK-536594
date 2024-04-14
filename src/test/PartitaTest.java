package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.giocatore.*;

public class PartitaTest {

	/* testIsFinita- INIZIO */
	
	@Test
	public void testIsFinita_NonFinita() {
		Partita partita = new Partita();
		assertFalse(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_Finita() {
		Partita partita = new Partita();
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_Cfu() {
		Partita partita = new Partita();
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	/* testIsFinitaTrue - FINE */
	
	/*  testIsFinitaTrue - INIZIO */
	
//	@Test
//	void testVintaTrue() {
//		assertEquals(true, this.partitaVintaBiblioteca.vinta());
//	}
//	
//	@Test
//	void testVintaFalse() {
//		assertEquals(false, this.partitaVintaNonBiblioteca.vinta());
//	}
	
	/*  testIsFinita - FINE */

}
