package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private Attrezzo[] attrezzi;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoBorsa;
	private int pesoMax;


	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
		this.attrezzi = new TreeMap<String, Attrezzo>();
		this.numeroAttrezzi = 0;
		this.pesoBorsa = 0;

	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;

	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		if(this.pesoBorsa + attrezzo.getPeso() > this.pesoMax)
			return false;
		if(this.attrezzi.containsKey(attrezzo.getNome()))
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoBorsa += attrezzo.getPeso();
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public int getPeso() {
		return this.pesoBorsa;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		if(nomeAttrezzo != null && this.attrezzi.containsKey(nomeAttrezzo))
			attrezzo = this.attrezzi.get(nomeAttrezzo);
		return attrezzo;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		if(nomeAttrezzo != null) {
			attrezzo = this.attrezzi.remove(nomeAttrezzo);
			if(attrezzo != null)
				this.pesoBorsa -= attrezzo.getPeso();
		}
		return attrezzo;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append("\n");
			//s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.attrezzi.values());
		return s;
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPesoCompareTo(){
		Set<Attrezzo> s = new TreeSet<>();
		s.addAll(this.attrezzi.values());
		List<Attrezzo> l = new ArrayList<>();
		
		l.addAll(s);
		return l;
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
	}

	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}

	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> a2p = new TreeMap<>();
		//il for e' stato inserito successivamente all'esercizio 2 (nell'esercizio 3)
		for(Attrezzo a : this.attrezzi.values()){
			if(a2p.containsKey(a.getPeso())) {
				a2p.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo>  s =new HashSet<Attrezzo>();
				s.add(a);
				a2p.put(a.getPeso(), s);
			}
		}
		return a2p;
	}
}
