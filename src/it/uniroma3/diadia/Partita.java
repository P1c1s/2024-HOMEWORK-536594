package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {



	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;

	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		giocatore = new Giocatore();
		//labirinto.creaStanze();
		this.finita = false;
	}

	public Labirinto getLabirinto(){
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}


	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.getLabirinto().setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
	

}

//package it.uniroma3.diadia;
//
//import it.uniroma3.diadia.ambienti.Labirinto;
//import it.uniroma3.diadia.ambienti.Stanza;
//import it.uniroma3.diadia.giocatore.Giocatore;
//
///**
// * Questa classe modella una partita del gioco
// *
// * @author  docente di POO
// * @see Stanza
// * @version base
// */
//
//public class Partita {
//
////	private Stanza stanzaCorrente;
////	private Stanza stanzaVincente;
////	private boolean finita;
////	private Labirinto labirinto;
////	private Giocatore giocatore;
////	
////	public Partita(){
////		this.finita = false;
////		this.giocatore = new Giocatore();
////		this.labirinto = new Labirinto();
////		this.labirinto.creaStanze();
////		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
////		this.stanzaVincente = this.labirinto.getStanzaFinale();
////	}
////	
//	private Labirinto labirinto;
//	private Giocatore giocatore;
//	private boolean finita;
//
//	public Partita(Labirinto labirinto){
//		this.labirinto = labirinto;
//		giocatore = new Giocatore();
//		//labirinto.creaStanze();
//		this.finita = false;
//	}
//
//	public void setLabirinto(Labirinto labirinto) {
//		this.labirinto = labirinto;
//	}
//
//
////
////	public Stanza getStanzaVincente() {
////		return this.stanzaVincente;
////	}
////
////	public void setStanzaCorrente(Stanza stanzaCorrente) {
////		this.stanzaCorrente = stanzaCorrente;
////	}
////
////	public Stanza getStanzaCorrente() {
////		return this.stanzaCorrente;
////	}
////	
//	public Giocatore getGiocatore() {
//		return this.giocatore;
//	}
//	
//	public Labirinto getLabirinto(){
//			return this.labirinto;
//	}
//	
//	public boolean giocatoreIsVivo() {
//		return (this.giocatore.getCfu() > 0);
//	}
//	
//	/**
//	 * Restituisce vero se e solo se la partita e' stata vinta
//	 * @return vero se partita vinta
//	 */
//	public boolean vinta() {
//		return this.getStanzaCorrente() == this.getStanzaVincente();
//	}
//
//	/**
//	 * Restituisce vero se e solo se la partita e' finita
//	 * @return vero se partita finita
//	 */
//	public boolean isFinita() {
//		return finita || vinta() || (this.giocatore.getCfu() == 0);
//	}
//
//	/**
//	 * Imposta la partita come finita
//	 *
//	 */
//	public void setFinita() {
//		this.finita = true;
//	}
//
////	public int getCfu() {
////		return this.cfu;
////	}
//
////	public void setCfu(int cfu) {
////		this.cfu = cfu;		
////	}	
//}
