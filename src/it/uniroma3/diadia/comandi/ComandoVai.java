package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;

public class ComandoVai implements Comando {
	
	private String direzione;
	private IO io;
	
	public ComandoVai(IO io) {
		this.io = io;
	}
	
	/**
	* esecuzione del comando
	*/
	@Override 
	public void esegui(Partita partita) {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.direzione==null)
			io.mostraMessaggioLn("Dove vuoi andare?");
		else{
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				io.mostraMessaggioLn("Direzione inesistente", "red");
			else {
				partita.setStanzaCorrente(prossimaStanza);
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
				io.mostraMessaggioLn(partita.getStanzaCorrente().getNome());
			}
		}
	}

	@Override
	public void setParametro(String direzione) {
		this.direzione = direzione;
	}
	
	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
}