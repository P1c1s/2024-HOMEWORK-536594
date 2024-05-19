package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	private IO io;

	public ComandoPrendi(IO io) {
		this.io = io;
	}


	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		if(attrezzo != null) {
			if(partita.getStanzaCorrente().removeAttrezzo(attrezzo) && 
					partita.getGiocatore().getBorsa().addAttrezzo(attrezzo))
				io.mostraMessaggioLn("Attrezzo [" + this.nomeAttrezzo + "] aggiunto nella borsa", "green");
			else
				io.mostraMessaggioLn("Errore", "red");
		}
		else
			io.mostraMessaggioLn("Attrezzo [" + this.nomeAttrezzo + "] non presente nella stanza.", "red");
	}

	@Override
	public void setParametro(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}

}
