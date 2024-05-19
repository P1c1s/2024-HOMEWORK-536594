package it.uniroma3.diadia;

//DA RIVEDERE SE ELIMINARE IMPORT -> SCANNER
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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
	private IO io;

	public DiaDia(IO console, Labirinto labirinto) {
		this.io = console;
		this.partita = new Partita(labirinto);
	}
	
	public void gioca() {
		String istruzione; 
		//		Scanner scannerDiLinee;
		io.mostraMessaggioLn(MESSAGGIO_BENVENUTO+"\n", "green");
		do {
			io.mostraMessaggio("Comando: ", "purple");
			istruzione = io.leggiRiga("yellow");
			io.mostraMessaggioLn(" ");
			io.cancellaSchermo();

		}while (!processaIstruzione(istruzione, io) );

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
		IO console = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 3)
				.addStanzaVincente("Biblioteca")
				.addStanza("Aula N1")
				.addStanza("Aula Campus")
				.addAttrezzo("metaldetector", 3)
				.addAdiacenza("Atrio", "Aula N1", "sud")
				.addAdiacenza("Aula N1", "Atrio", "nord")
				.addAdiacenza("Atrio", "Aula Campus", "est")
				.addAdiacenza("Aula Campus", "Atrio", "ovest")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(console, labirinto);
		gioco.gioca();
	}
}