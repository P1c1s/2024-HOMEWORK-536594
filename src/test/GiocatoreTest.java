package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	/* testSetCfu - INZIO */
	
	@Test
	public void testSetCfu_ValoreCasuale() {
		Giocatore giocatore = new Giocatore();
		giocatore.setCfu(5);
		assertEquals(5, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu_ValoreZero() {
		Giocatore giocatore = new Giocatore();
		giocatore.setCfu(0);
		assertEquals(0, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu_ValoreNegativo() {
		Giocatore giocatore = new Giocatore();
		giocatore.setCfu(-2);
		assertNotEquals(-2, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu_ValoreInEccesso() {
		Giocatore giocatore = new Giocatore();
		giocatore.setCfu(21);
		assertNotEquals(21, giocatore.getCfu());
	}
	
	/* testSetCfu - FINE */
	
	/* testGetCfu - INZIO */
	
	@Test
	public void testGetCfu_CfuIniziali() {	
		Giocatore giocatore = new Giocatore();
		assertEquals(20, giocatore.getCfu());		
	}
	
//	@Test
//	public void testGetCfu_CfuIniziali() {	
//		Giocatore giocatore = new Giocatore();
//		assertEquals(20, giocatore.getCfu());		
//	}

	/* testGetCfu - FINE */
	
}


