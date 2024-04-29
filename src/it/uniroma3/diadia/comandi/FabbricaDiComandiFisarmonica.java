package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	
	private IO io;
	
	public FabbricaDiComandiFisarmonica(IO io) {
		this.io = io;
	}
	
	public Comando costruisciComando(String istruzione) {
		
		String[] app = istruzione.split(" ");
		String nomeComando = null;
		String parametro = null;

		if(app.length == 0)
			nomeComando = "";
		else if(app[0] != "") {
			if(app.length == 2 ) {
				nomeComando = app[0];
				parametro = app[1];
			}
			else
				nomeComando = app[0];
		}
		
		Comando comando = null;
		
		if (nomeComando == null)
			comando = new ComandoNonValido(this.io);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(this.io);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(this.io);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(this.io);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(this.io);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(this.io);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(this.io);
		else comando = new ComandoNonValido(this.io);
		
		comando.setParametro(parametro);
		
		return comando;
	}
	
}
