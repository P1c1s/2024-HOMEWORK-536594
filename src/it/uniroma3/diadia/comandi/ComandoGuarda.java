package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Stanza corrente: ", "whitebold");
		io.mostraMessaggioLn(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa: ", "whitebold");
		io.mostraMessaggioLn(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("CFU: ", "whitebold");
		io.mostraMessaggioLn(partita.getGiocatore().getCfu() + "\n");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
