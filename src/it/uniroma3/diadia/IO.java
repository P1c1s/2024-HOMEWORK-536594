package it.uniroma3.diadia;

public interface IO {
	public void mostraMessaggio(String messaggio);
	public void mostraMessaggioLn(String messaggio);
	public void mostraMessaggio(String messaggio, String colore);
	public void mostraMessaggioLn(String messaggio, String colore);
	public String leggiRiga();
	public String leggiRiga(String colore);
	public void cancellaSchermo();
}
