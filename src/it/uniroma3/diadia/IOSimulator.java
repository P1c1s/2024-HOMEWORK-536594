package it.uniroma3.diadia;
import java.util.Scanner;

public class IOSimulator implements IO {

	private Scanner scannerDiLinee; 
	private String[] messaggio = new String[100];
	private String comando;
	private int messaggioCorrente;
	
	public IOSimulator(String comando) {
		this.scannerDiLinee = new Scanner(comando);
		this.messaggioCorrente = 0;
	}

	@Override
	public String leggiRiga() {
		if(this.scannerDiLinee.hasNext())
			comando = this.scannerDiLinee.nextLine();
		return comando;
	}
	
	@Override
	public String leggiRiga(String colore) {
		if(this.scannerDiLinee.hasNext())
			comando = this.scannerDiLinee.nextLine();
		return comando;
	}

	
	public String getMessaggio(int messaggioCorrente){
		return this.messaggio[messaggioCorrente];
	}
	
	
	public String getComando(){
		return this.comando;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggio[this.messaggioCorrente] = messaggio;
		this.messaggioCorrente+=1;
	}
	
	@Override
	public void mostraMessaggioLn(String messaggio) {
		this.messaggio[this.messaggioCorrente] = messaggio;
		this.messaggioCorrente+=1;		
	}

	@Override
	public void mostraMessaggio(String messaggio, String colore) {
		this.messaggio[this.messaggioCorrente] = messaggio;
		this.messaggioCorrente+=1;
	}

	@Override
	public void mostraMessaggioLn(String messaggio, String colore) {
		this.messaggio[this.messaggioCorrente] = messaggio;
		this.messaggioCorrente+=1;
	}

	@Override
	public void cancellaSchermo() {
		// TODO Auto-generated method stub
	}

}
