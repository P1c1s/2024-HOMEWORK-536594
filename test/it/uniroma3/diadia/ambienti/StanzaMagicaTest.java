package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {


	
	/* addAttrezzo - INIZIO */
	
	@Test  
	public void testAddAttrezzo_StanzaVuotaAttrezzoAggiunto(){
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		assertTrue(stanzaMagica.addAttrezzo(calamaio));
	}
	
	@Test  
	public void testAddAttrezzo_StanzaNonVuotaAttrezzoAggiunto(){
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("calamaio", 1);
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		stanzaMagica.addAttrezzo(calamaio);
		assertTrue(stanzaMagica.addAttrezzo(penna));
	}
	
	@Test  
	public void testAddAttrezzo_StanzaPienaAttrezzoNonInseribile(){
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(stanzaMagica.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertFalse(stanzaMagica.addAttrezzo(calamaio));
	}

	@Test
	public void testGetAttrezzo_StanzaVuotaAssente() {
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		assertNull(stanzaMagica.getAttrezzo("calamaio"));
	}
	
	@Test  
	public void testGetAttrezzo_NomeAlDritto() {
		Attrezzo calamaio = new Attrezzo("calamaio", 0);
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		for(int i = 0; i < 2; i++)
			stanzaMagica.addAttrezzo(new Attrezzo("attrezzo"+i, i));
		stanzaMagica.addAttrezzo(calamaio);
		assertEquals("calamaio", stanzaMagica.getAttrezzo("calamaio").getNome());
	}
	
	@Test  
	public void testGetAttrezzo_NomeAlContrario() {
		Attrezzo chiave = new Attrezzo("chiave", 0);
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		for(int i = 0; i < 3; i++)
			stanzaMagica.addAttrezzo(new Attrezzo("attrezzo"+i, i));
		stanzaMagica.addAttrezzo(chiave);
		assertEquals("evaihc", stanzaMagica.getAttrezzo("evaihc").getNome());
	}
	
	@Test  
	public void testAddAttrezzo_GetPeso(){
		Attrezzo chiave = new Attrezzo("chiave", 3);
		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica");
		for(int i = 0; i < 3; i++)
			stanzaMagica.addAttrezzo(new Attrezzo("attrezzo"+i, i));
		stanzaMagica.addAttrezzo(chiave);
		assertEquals(6, stanzaMagica.getAttrezzo("evaihc").getPeso());
	}
	
	/* addAttrezzo - FINE */

}
