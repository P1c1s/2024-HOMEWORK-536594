package test;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	/* testAddAttrezzo - INIZIO */
	@Test
	public void testAddAttrezzo_BorsaVuota() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Borsa borsa = new Borsa();
		assertTrue(borsa.addAttrezzo(calamaio));
	}
	
	@Test
	public void testAddAttrezzo_BorsaUnOggetto() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("penna", 1);
		Borsa borsa = new Borsa();
		borsa.addAttrezzo(penna);
		assertTrue(borsa.addAttrezzo(calamaio));
	}
	
	@Test
	public void testAddAttrezzo_BorsaPiena() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 1);
		int i = 0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		assertFalse(borsa.addAttrezzo(calamaio));
	}
	
	@Test
	public void testAddAttrezzo_PesoMassimoRaggiunto() {
		Borsa borsa = new Borsa();
		for(int i = 0; i < 4; i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo"+i, 2);
			borsa.addAttrezzo(attrezzo);
		}
		Attrezzo calamaio = new Attrezzo("calamaio", 4);
		assertFalse(borsa.addAttrezzo(calamaio));
	}
	/* tetAddAttrezzo - FINE */
	
	/* testHasAttrezzo - INIZIO */
	
	@Test
	public void testHasAttrezzo_BorsaVuotaAssente() {
		Borsa borsa = new Borsa();
		assertFalse(borsa.hasAttrezzo("calamaio"));
	}

	@Test
	public void testHasAttrezzo_BorsaUnAttrezzoAssente() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Borsa borsa = new Borsa();
		borsa.addAttrezzo(calamaio);
		assertFalse(borsa.hasAttrezzo("pennino"));
	}
	
	@Test
	public void testHasAttrezzo_BorsaUnAttrezzoPresente() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Borsa borsa = new Borsa();
		borsa.addAttrezzo(calamaio);
		assertTrue(borsa.hasAttrezzo("calamaio"));
	}

	@Test
	public void testHasAttrezzo_BorsaPienaAttrezzoInTesta() {
		Borsa borsa = new Borsa();
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		assertTrue(borsa.hasAttrezzo("attrezzo0"));
	}
	
	@Test
	public void testHasAttrezzo_BorsaPienaAttrezzoInMezzo() {
		Borsa borsa = new Borsa();
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		assertTrue(borsa.hasAttrezzo("attrezzo4"));
	}
	
	
	@Test
	public void testHasAttrezzo_StanzaPienaAttrezzoInCoda() {
		Borsa borsa = new Borsa();
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		assertTrue(borsa.hasAttrezzo("attrezzo9"));
	}
	
	/* testHasAttrezzo - FINE */
	
	/* testGetAttrezzo - INIZIO */
	
	@Test
	public void testGetAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		assertNull(borsa.getAttrezzo("calamio"));
	}
	
	@Test
	public void testGetAttrezzo_BorsaUnAttrezzo() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Borsa borsa = new Borsa();
		borsa.addAttrezzo(calamaio);
		assertNotNull(borsa.getAttrezzo("calamaio"));
	}
	
	@Test
	public void testGetAttrezzo_BorsaPiena() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo0", 1);
		int i = 0;
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
		}
		assertNotNull(borsa.getAttrezzo("attrezzo5"));
	}
	
	/* testGetAttrezzo - FINE */
	
	
	/* testRemoveAttrezzo - INIZIO */
	
	@Test
	public void testRemoveAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		assertNull(borsa.removeAttrezzo("calamio"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaUnAttrezzo() {
		Borsa borsa = new Borsa();
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		borsa.addAttrezzo(calamaio);
		assertEquals(calamaio, borsa.removeAttrezzo("calamaio"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaNonPienaPrimoElemento() {
		Borsa borsa = new Borsa();
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("penna", 1);
		Attrezzo inchiostro = new Attrezzo("inchiostro", 1);
		
		borsa.addAttrezzo(calamaio);
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(inchiostro);
		
		assertEquals(calamaio, borsa.getAttrezzo("calamaio"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaNonPienaElementoInMezzo() {
		Borsa borsa = new Borsa();
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("penna", 1);
		Attrezzo inchiostro = new Attrezzo("inchiostro", 1);
		
		borsa.addAttrezzo(calamaio);
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(inchiostro);
		borsa.addAttrezzo(new Attrezzo("inchiostro2", 1));
		assertEquals(penna, borsa.getAttrezzo("inchiostro2"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaPresenteInCoda() {
		Borsa borsa = new Borsa();
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("penna", 1);
		Attrezzo inchiostro = new Attrezzo("inchiostro", 1);
		
		borsa.addAttrezzo(calamaio);
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(inchiostro);
		
		assertEquals(inchiostro, borsa.getAttrezzo("inchiostro"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaPienaPresenteInCoda() {
		Borsa borsa = new Borsa();
		for(int i = 0; i < 4; i++)
			borsa.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		
		Attrezzo attrezzo = new Attrezzo("attrezzo3", 1);
		borsa.addAttrezzo(new Attrezzo("attrezzo", 1));
		assertEquals(attrezzo, borsa.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaNonVuotaAssente() {
		Borsa borsa = new Borsa();
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("penna", 1);
		Attrezzo inchiostro = new Attrezzo("inchiostro", 1);
		
		borsa.addAttrezzo(calamaio);
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(inchiostro);
		
		assertNull(borsa.getAttrezzo("taccuino"));
	}
	/* testRemoveAttrezzo - FINE */
	
	/* testGetPeso - INIZIO */

	@Test
	public void testGetPeso_BorsaVuota() {
		Borsa borsa = new Borsa();
		assertEquals(0, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaNonVuota() {
		Borsa borsa = new Borsa();
		for(int i = 0; i < 4; i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo"+i, i);
			borsa.addAttrezzo(attrezzo);
		}
		assertEquals(6, borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_BorsaPiena() {
		Borsa borsa = new Borsa();
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+i, 1);
		while(borsa.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, 1);
			borsa.addAttrezzo(attrezzo);
		}
		assertEquals(10, borsa.getPeso());
	}
	
	/* testGetPeso - FINE */
}
