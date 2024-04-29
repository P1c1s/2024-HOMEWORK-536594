package it.uniroma3.diadia;

//DA RIVEDERE SE ELIMINARE IMPORT -> SCANNER
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
//import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IO io) {
		String istruzione = new String(); 
		
		io.mostraMessaggioLn(MESSAGGIO_BENVENUTO+"\n", "green");

		do {
			io.mostraMessaggio("Comando: ", "purple");
			istruzione = io.leggiRiga("yellow");
			io.mostraMessaggioLn(" ");
			io.cancellaSchermo();
		}
		while (!processaIstruzione(istruzione, io));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IO io) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggioLn("Hai vinto!", "green");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggioLn("Hai esaurito i CFU.", "red");
		return this.partita.isFinita();
	}   		

	
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca(io);
	}
}