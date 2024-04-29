package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "guarda"};
	
	private IO io;
	
	public ComandoAiuto(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggioLn("Lista comandi", "whitebold");
		for(int i=0; i< elencoComandi.length; i++)
			io.mostraMessaggio(elencoComandi[i] + "     ", "white");
		io.mostraMessaggioLn("\n");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
