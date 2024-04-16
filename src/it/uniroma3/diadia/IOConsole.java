package it.uniroma3.diadia;

import java.util.Scanner;
//Java program to implement the associate array 
import java.io.*; 
import java.util.*; 
import java.util.HashMap;

public class IOConsole {

	public static String customColor(String color) {  
		Map<String, String> map = new HashMap<String, String>();
		map.put("black", "\033[0;30m");
		map.put("red", "\033[0;31m");
		map.put("green", "\033[0;32m");
		map.put("yellow", "\033[0;33m");
		map.put("blue", "\033[0;34m");
		map.put("blue", "fdemo");
		map.put("purple", "\033[0;35m");
		map.put("cyan", "\033[0;36m");
		map.put("white", "\033[0;37m");
		
		map.put("blackbold", "\033[0;30m");
		map.put("redbold", "\033[0;31m");
		map.put("greenbold", "\033[0;32m");
		map.put("yellowbold", "\033[0;33m");
		map.put("bluebold", "\033[0;34m");
		map.put("bluebold", "fdemo");
		map.put("purplebold", "\033[0;35m");
		map.put("cyanbold", "\033[0;36m");
		map.put("whitebold", "\033[1;37m");
		
		map.put("reset", "\u001B[0m");
		
		return map.get(color);
	}
	
	public void mostraMessaggio(String msg) {
		System.out.print(msg);
	}
	
	public void mostraMessaggioLn(String msg) {
		System.out.println(msg);
	}
	
	public void mostraMessaggio(String msg, String color) {
		System.out.print(customColor(color) + msg + customColor("white"));
	}
	
	public void mostraMessaggioLn(String msg, String color) {
		System.out.println(customColor(color) + msg + customColor("white"));
	}
	
	public void cancellaSchermo() {
		   System.out.print("\033[H\033[2J");  
		   System.out.flush();  
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close(); // DA RIVEDERE
		return riga;
	}
	
	public String leggiRiga(String color) {
		System.out.println(customColor(color));
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close(); //DA RIVEDERE
		return riga;
	}
	
	
}