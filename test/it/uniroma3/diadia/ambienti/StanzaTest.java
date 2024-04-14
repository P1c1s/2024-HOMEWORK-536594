package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaTest {
	
	
	/* addAttrezzo - INIZIO */
	
	@Test  
	public void testAddAttrezzo_StanzaVuotaAttrezzoAggiunto(){
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Stanza aulaN1 = new Stanza("Aula N1");
		assertTrue(aulaN1.addAttrezzo(calamaio));
	}
	
	@Test  
	public void testAddAttrezzo_StanzaNonVuotaAttrezzoAggiunto(){
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Attrezzo penna = new Attrezzo("calamaio", 1);
		Stanza aulaN1 = new Stanza("Aula N1");
		aulaN1.addAttrezzo(calamaio);
		assertTrue(aulaN1.addAttrezzo(penna));
	}
	
	@Test  
	public void testAddAttrezzo_StanzaPienaAttrezzoNonInseribile(){
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Stanza aulaN1 = new Stanza("Aula N1");
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(aulaN1.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertFalse(aulaN1.addAttrezzo(calamaio));
	}
	
	/* addAttrezzo - FINE */
	
	/* hasAttrezzo - INIZIO */
	
	@Test
	public void testHasAttrezzo_StanzaVuotaAssente() {
		Stanza aulaN1 = new Stanza("Aula N1");
		assertFalse(aulaN1.hasAttrezzo("calamaio"));
	}

	@Test
	public void testHasAttrezzo_StanzaUnAttrezzoAssente() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Stanza aulaN1 = new Stanza("Aula N1");
		aulaN1.addAttrezzo(calamaio);
		assertFalse(aulaN1.hasAttrezzo("pennino"));
	}
	
	@Test
	public void testHasAttrezzo_StanzaUnAttrezzoPresente() {
		Attrezzo calamaio = new Attrezzo("calamaio", 1);
		Stanza aulaN1 = new Stanza("Aula N1");
		aulaN1.addAttrezzo(calamaio);
		assertTrue(aulaN1.hasAttrezzo("calamaio"));
	}

	@Test
	public void testHasAttrezzo_StanzaPienaAttrezzoInTesta() {
		Stanza aulaN1 = new Stanza("Aula N1");
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(aulaN1.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertTrue(aulaN1.hasAttrezzo("attrezzo0"));
	}
	
	@Test
	public void testHasAttrezzo_StanzaPienaAttrezzoInMezzo() {
		Stanza aulaN1 = new Stanza("Aula N1");
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(aulaN1.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertTrue(aulaN1.hasAttrezzo("attrezzo5"));
	}
	
	
	@Test
	public void testHasAttrezzo_StanzaPienaAttrezzoInMezzo1() {
		Stanza aulaN1 = new Stanza("Aula N1");
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(aulaN1.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertTrue(aulaN1.hasAttrezzo("attrezzo5"));
	}
	
	@Test
	public void testHasAttrezzo_StanzaPienaAttrezzoInCoda() {
		Stanza aulaN1 = new Stanza("Aula N1");
		int i = 0;
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		while(aulaN1.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertTrue(aulaN1.hasAttrezzo("attrezzo8"));
	}
	
	/* hasAttrezzo - FINE */
	
	/* testGetAttrezzo -INIZIO */
	
	@Test
	public void testGetAttrezzo_StanzaVuotaAssente() {
		Stanza aulaN1 = new Stanza("Aula N1");
		assertNull(aulaN1.getAttrezzo("calamaio"));
	}

	@Test
	public void testGetAttrezzo_StanzaUnAtrezzoPresente() {
		Stanza aulaN1 = new Stanza("Aula N1");
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		aulaN1.addAttrezzo(attrezzo);
		assertEquals(attrezzo, aulaN1.getAttrezzo("attrezzo0"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaPienaAttrezzoInCoda() {
		Stanza aulaN1 = new Stanza("Aula N1");
		Attrezzo attrezzo = new Attrezzo("attrezzo"+0, 0);
		int i = 0;
		while(aulaN1.addAttrezzo(attrezzo)) {
			i++;
			attrezzo = new Attrezzo("attrezzo"+i, i);
		}
		assertNotNull(aulaN1.getAttrezzo("attrezzo"+9));
	}
	
	@Test
    public void testGetAttrezzo_StanzaPienaAttrezzoInCodaALTRO() {
        Stanza aulaN1 = new Stanza("Aula N1");

        Attrezzo attrezzo1 = new Attrezzo("gg", 1);
        Attrezzo attrezzo2 = new Attrezzo("rg", 2);
        Attrezzo attrezzo3 = new Attrezzo("tg", 1);
        Attrezzo attrezzo4 = new Attrezzo("yg", 1);
        Attrezzo attrezzo5 = new Attrezzo("ug", 1);
        Attrezzo attrezzo6 = new Attrezzo("ig", 1);
        Attrezzo attrezzo7 = new Attrezzo("og", 1);
        Attrezzo attrezzo8 = new Attrezzo("pg", 1);
        Attrezzo attrezzo9 = new Attrezzo("fg", 1);
        Attrezzo attrezzo10 = new Attrezzo("sg", 1);

        aulaN1.addAttrezzo(attrezzo1);
        aulaN1.addAttrezzo(attrezzo2);
        aulaN1.addAttrezzo(attrezzo3);
        aulaN1.addAttrezzo(attrezzo4);
        aulaN1.addAttrezzo(attrezzo5);
        aulaN1.addAttrezzo(attrezzo6);
        aulaN1.addAttrezzo(attrezzo7);
        aulaN1.addAttrezzo(attrezzo8);
        aulaN1.addAttrezzo(attrezzo9);
        aulaN1.addAttrezzo(attrezzo10);

        assertEquals(attrezzo10, aulaN1.getAttrezzo("sg"));
	}
	
	/* testGetAttrezzo - FINE */
	
	/* testGetStanzaAdiancente - INZIO */
	
	@Test
	public void testGetStanzaAdiacente_StanzaIsolata() {
		Stanza aulaN18 = new Stanza("Aula N18");
		assertNull(aulaN18.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_DirezioneErrata() {
		Stanza aulaN18 = new Stanza("Aula N18");
		Stanza aulaN17 = new Stanza("Aula N17");
		aulaN18.impostaStanzaAdiacente("sud", aulaN17);
		assertNull(aulaN18.getStanzaAdiacente("nord"));
	}
	
	/* testGetStanzaAdiancente - FINE */
	
	/* testImpostaStanzaAdiancente - INIZIO */
	
	@Test
	public void testImpostaStanzaAdiacente_StanzaIsolata() {
		Stanza aulaN18 = new Stanza("Aula N18");
		Stanza aulaN17 = new Stanza("Aula N17");
		aulaN18.impostaStanzaAdiacente("nord", aulaN17);
		assertEquals(aulaN17, aulaN18.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_UnaStanzaAdiancente() {
		Stanza aulaN18 = new Stanza("Aula N18");
		Stanza aulaN17 = new Stanza("Aula N17");
		Stanza aulaN16 = new Stanza("Aula N16");
		aulaN18.impostaStanzaAdiacente("nord", aulaN17);
		aulaN18.impostaStanzaAdiacente("est", aulaN16);
		assertEquals(aulaN16, aulaN18.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_StanzaPiena() {
		Stanza aulaN18 = new Stanza("Aula N18");
		Stanza aulaN17 = new Stanza("Aula N17");
		Stanza aulaN16 = new Stanza("Aula N16");
		Stanza aulaN15 = new Stanza("Aula N15");
		Stanza aulaN14 = new Stanza("Aula N14");
		aulaN18.impostaStanzaAdiacente("nord", aulaN17);
		aulaN18.impostaStanzaAdiacente("sud", aulaN16);
		aulaN18.impostaStanzaAdiacente("est", aulaN15);
		aulaN18.impostaStanzaAdiacente("ovest", aulaN14);
		assertEquals(aulaN17, aulaN18.getStanzaAdiacente("nord"));
		assertEquals(aulaN16, aulaN18.getStanzaAdiacente("sud"));
		assertEquals(aulaN15, aulaN18.getStanzaAdiacente("est"));
		assertEquals(aulaN14, aulaN18.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_StanzaSovrascrittura() {
		Stanza aulaN18 = new Stanza("Aula N18");
		Stanza aulaN17 = new Stanza("Aula N17");
		Stanza aulaN16 = new Stanza("Aula N13");
		aulaN18.impostaStanzaAdiacente("nord", aulaN17);
		aulaN18.impostaStanzaAdiacente("nord", aulaN16);
		assertEquals(aulaN16, aulaN18.getStanzaAdiacente("nord"));
	}
	
	/* testImpostaStanzaAdiancente - START */
	
	
	@Test
	public void testRemoveAttrezzo() {
		//fail("Not yet implemented");
	}
	
	/* testGetAttrezzo -INIZIO */
	

}
