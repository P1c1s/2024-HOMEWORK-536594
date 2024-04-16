package it.uniroma3.diadia;

//DA RIVEDERE SE ELIMINARE IMPORT -> SCANNER
import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
//import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione = new String(); 
		Scanner scannerDiLinee; //SERVE DAVVERO?
		
		this.io = new IOConsole();
		this.io.mostraMessaggioLn(MESSAGGIO_BENVENUTO+"\n", "green");

		do {
			io.mostraMessaggio("Comando: ", "purple");
			istruzione = io.leggiRiga("yellow");
			io.mostraMessaggioLn(" ");
			//io.mostraMessaggio(" "); //per andare a capo, da rivedere non mi piace
			io.cancellaSchermo();
		}
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome() == null) {
			io.mostraMessaggio("Inserire un comando");
			return false;
		}	
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggioLn("Comando sconosciuto!", "red");
		
		if (this.partita.vinta()) {
			io.mostraMessaggioLn("Hai vinto!", "green");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		io.mostraMessaggioLn("Lista comandi", "whitebold");
		for(int i=0; i< elencoComandi.length; i++)
			io.mostraMessaggio(elencoComandi[i] + "     ", "white");
		io.mostraMessaggioLn("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggioLn("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggioLn("Direzione inesistente", "red");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio("Stanza corrente: ", "whitebold");
		io.mostraMessaggioLn(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa: ", "whitebold");
		io.mostraMessaggioLn(partita.getGiocatore().getBorsa().toString() + "\n");

	}

	

	/**
	 * 
	 * Posa
	 */
	private void posa(String nomeAttrezzo) {
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			if(this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo)!=null && 
					this.partita.getStanzaCorrente().addAttrezzo(attrezzo))
				io.mostraMessaggioLn("Attrezzo posato nella stanza", "green");
			else
				io.mostraMessaggioLn("Errore", "red");
		}
		else
			io.mostraMessaggioLn("Attrezzo non posato nella stanza", "red");
	}
			
	
	/**
	 * 
	 * Prendi
	 */
	private void prendi(String nomeAttrezzo) {
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			if(this.partita.getStanzaCorrente().removeAttrezzo(attrezzo) && 
					this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo))
				io.mostraMessaggioLn("Attrezzo aiggiunto nella borsa", "green");
			else
				io.mostraMessaggioLn("Errore", "red");
		}
		else
			io.mostraMessaggioLn("Attrezzo non presente nella stanza", "red");
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}