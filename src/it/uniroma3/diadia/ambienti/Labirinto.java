package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	
	public Labirinto() {
		creaStanze();
	}
	
    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo passepartout = new Attrezzo("passepartout",5);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza stanzaMagica = new StanzaMagica("Stanza Magica");
		Stanza aulaN6 = new StanzaBuia("Aula N6", "lasterna");
		Stanza aulaN13 = new StanzaBloccata("Aula N13", "passepartout", "nord");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("nord", aulaN6);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN6.impostaStanzaAdiacente("sud", aulaN11);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("nord", aulaN13);
		aulaN13.impostaStanzaAdiacente("sud", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		aulaN10.impostaStanzaAdiacente("sud", stanzaMagica);
		stanzaMagica.impostaStanzaAdiacente("nord", aulaN10);
		biblioteca.impostaStanzaAdiacente("sud", atrio);


        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN6.addAttrezzo(passepartout);

        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;  
    }

    public Stanza getStanzaIniziale(){
    	return this.stanzaIniziale;
    }
    
    public Stanza getStanzaFinale(){
    	return this.stanzaFinale;
    }

    
}
