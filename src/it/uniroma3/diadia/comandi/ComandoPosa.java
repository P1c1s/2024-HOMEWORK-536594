package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private IO io;
	
	public ComandoPosa(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
		if(attrezzo!=null) {
			if(partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo) != null && 
				partita.getStanzaCorrente().addAttrezzo(attrezzo))
				io.mostraMessaggioLn("Attrezzo [" + this.nomeAttrezzo + "] posato nella stanza", "green");
			else
				io.mostraMessaggioLn("Errore", "red");
		}
		else
			io.mostraMessaggioLn("Attrezzo [" + this.nomeAttrezzo  + "] non presente nella borsa.", "red");
		
	}

	@Override
	public void setParametro(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
		
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}

}
