package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.*;
import java.util.Scanner;

import org.junit.Test;

public class IOSimulatorTest {

	@Test
	public void testLetturaComando_prova() {
		String comando = new String("prova");
		IOSimulator ioSim = new IOSimulator(comando);
		ioSim.leggiRiga();
		assertEquals("prova", ioSim.getComando());
	}

	@Test
	public void testLetturaComando_fine() {
		String comando = new String("fine");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Grazie di aver giocato!", ioSim.getMessaggio(3));
	}

	@Test
	public void testComandoGuarda() {
		String comando = new String("guarda\nfine");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Borsa: ", ioSim.getMessaggio(5));
	}
	
	@Test
	public void testComandoVaiNord_Vittoria() {
		String comando = new String("vai nord");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("vai nord", ioSim.getComando());
		assertEquals("Hai vinto!", ioSim.getMessaggio(4));
	}
	

	@Test
	public void testComandoNonvalido_corri() {
		String comando = new String("corri\nfine");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Comando non valido.", ioSim.getMessaggio(3));
	}
	
	@Test
	public void testVaiSud_AulaN10() {
		String comando = new String("vai sud\nvai nord\nvai nord");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Aula N10", ioSim.getMessaggio(3));
	}

	@Test
	public void testComandoPrendiOsso_Aggiunto() {
		String comando = new String("prendi osso\nvai nord");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Attrezzo [osso] aggiunto nella borsa", ioSim.getMessaggio(3));
	}
	
	@Test
	public void testComandoPosaOsso_Posato() {
		String comando = new String("prendi osso\nposa osso\nvai nord\n");
		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Attrezzo [osso] posato nella stanza", ioSim.getMessaggio(6));
	}

	@Test
	public void testComandoVai_CFUesauriti() {
		String comando = new String("");
		for(int i = 0; i < 20; i++)
			if(i % 2 == 0)
				comando += "vai sud\n";
			else
				comando += "vai nord\n";
		comando += "vai nord";

		IOSimulator ioSim = new IOSimulator(comando);
		DiaDia diadiaTest = new DiaDia();
		diadiaTest.gioca(ioSim);
		assertEquals("Hai esaurito i CFU.", ioSim.getMessaggio(61));
	}
}