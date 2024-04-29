package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabbricDiComandiFisarmonicaTest {

	/* testComando* - INIZIO */
	
	@Test
	public void testComandoNonValido() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoVai = factory.costruisciComando("scappa");
		assertEquals(null, comandoVai.getNome());
	}
	
	@Test
	public void testComandoVai() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoVai = factory.costruisciComando("vai");
		assertEquals("vai", comandoVai.getNome());
	}

	@Test
	public void testComandoPrendi() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoPrendi = factory.costruisciComando("prendi");
		assertEquals("prendi", comandoPrendi.getNome());
	}
	
	@Test
	public void testComandoPosa() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoPosa = factory.costruisciComando("posa");
		assertEquals("posa", comandoPosa.getNome());
	}
	
	/* testComando* - FINE */
	
	
	/* testParametro* - INIZIO */
	
	@Test
	public void testParametroVai_senzaDirezione() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoVai = factory.costruisciComando("vai");
		assertEquals(null, comandoVai.getParametro());
	}
	
	@Test
	public void testParametroVai_DirezioneNord() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoVai = factory.costruisciComando("vai nord");
		assertEquals("nord", comandoVai.getParametro());
	}
	
	@Test
	public void testParametroPrendi_senzaAttrezzo() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoPrendi = factory.costruisciComando("prendi");
		assertEquals(null, comandoPrendi.getParametro());
	}
	
	@Test
	public void testParametroPrendi_attrezzoCalamaio() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoPrendi = factory.costruisciComando("prendi calamaio");
		assertEquals("calamaio", comandoPrendi.getParametro());
	}
	
	public void testParametroPosa_senzaAttrezzo() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoPosa = factory.costruisciComando("posa");
		assertEquals(null, comandoPosa.getParametro());
	}
	
	@Test
	public void testParametroPosa_attrezzoCalamio() {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(null);
		Comando comandoPosa = factory.costruisciComando("posa calamaio");
		assertEquals("calamaio", comandoPosa.getParametro());
	}
	
	/* testParametro* - INIZIO */
	
	
}
