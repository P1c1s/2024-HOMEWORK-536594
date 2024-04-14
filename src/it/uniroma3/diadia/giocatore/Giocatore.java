package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		if(cfu <= 20 && cfu >= 0)
			this.cfu = cfu;		
	}	

	public void setBorsa(Borsa borsa){
		this.borsa = borsa;
	}
	
	public Borsa getBorsa(){
		return this.borsa;
	}
	

}
