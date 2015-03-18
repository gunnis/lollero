import java.util.Scanner;
public class Salasana {

	private static final Scanner lukija = new Scanner(System.in);
	public static void main(String[] args) {

	System.out.println("Anna salasana:");
	String jono = lukija.nextLine();
	
	tutkiPituus(jono);
	onko2Kirjainta(jono);
	onkoEriKokoisia(jono);
	onkoNumeroa(jono);
	onkoErikoisia(jono);
	onkoSkandeja(jono);
	onkoV�lily�ntej�(jono);	
	}
	
	public static void tutkiPituus(String jono) {
		if (jono.length() < 6 || jono.length() > 8) 
			System.out.println("Oltava 6-8 merkki� pitk�");
	}
	
	public static void onko2Kirjainta(String jono) {
		int kirjLKM = 0;
		for (int i = 0; i < jono.length(); i++) {
			char c = jono.charAt(i);
			if (Character.isLetter(c))
			 kirjLKM++;
		}
		if (kirjLKM < 2) 
			System.out.println("Oltava v�hint��n 2 kirjainta");		
}
	
	public static void onkoEriKokoisia(String jono) {
		int isoja = 0;
		int pieni� = 0;
		for (int i = 0; i < jono.length(); i++) {
			char c = jono.charAt(i);
			if (Character.isUpperCase(c)) 
				isoja++;
			if (Character.isLowerCase(c))
				pieni�++;
		}
		if (isoja == 0 || pieni� == 0)
			System.out.println("Oltava isoja sek� pieni� kirjaimia");
	}
	
	public static void onkoNumeroa(String jono) {
		int numeroita = 0;
		for (int i = 0; i < jono.length(); i++) {
			char c = jono.charAt(i);
			if (Character.isDigit(c))
			  numeroita++;
		}
		if (numeroita == 0)
			System.out.println("Oltava v�hint��n 1 numero");
		
		char alku = jono.charAt(0);
		if (Character.isDigit(alku))
			System.out.println("Numero ei saa olla ensimm�isen�");
		
		char loppu = jono.charAt(jono.length()-1);
		if (Character.isDigit(loppu))
			System.out.println("Numero ei saa olla viimeisen�");	
	}
	
	public static void onkoErikoisia(String jono) {
		int erikois = 0;
		for (int i = 0; i < jono.length(); i++) {
			char c = jono.charAt(i);
			if (!Character.isLetterOrDigit(c))
			  erikois++;
		}
		if (erikois == 0)
			System.out.println("V�hint��n 1 erikoismerkki");
		
		char alku = jono.charAt(0);
		if (!Character.isLetterOrDigit(alku))
			System.out.println("Erikoismerkki ei saa olla ensimm�isen�");
		
		char loppu = jono.charAt(jono.length()-1);
		if (!Character.isLetterOrDigit(loppu))
			System.out.println("Erikoismerkki ei saa olla viimeisen�");	
	}
	
	public static void onkoSkandeja(String jono) {
		int skandit = 0;
			for (int i = 0; i < jono.length(); i++) {
			char c = jono.charAt(i);
			if (c == '�' || c == '�' || c == '�' || c == '�' || c == '�' || c == '�')
		      skandit++;
		}
		if (skandit > 0)
		   System.out.println("Ei saa sis�lt�� skandeja");		
	}
		
	public static void onkoV�lily�ntej�(String jono) {
		int v�lej� = 0;
		for (int i = 0; i < jono.length(); i++) {
			char c = jono.charAt(i);
			if (Character.isWhitespace(c))
				v�lej�++;
		}
		if (v�lej� > 0)
		System.out.println("Ei saa olla v�lily�ntej�");	
	}
}