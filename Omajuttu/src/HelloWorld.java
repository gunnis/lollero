import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class HelloWorld {
	
	private static final Scanner lukija = new Scanner(System.in);

	//public static void main(String[] args) {

//	String systeemi = "";	
//	System.out.println("Sy�t� Systeemin nimi");
//	systeemi = lukija.nextLine();
	
//	System.out.println("Etsit systeemi� " + systeemi);
	

		

//	System.out.println(content);
	
//	}
	
	    public static void main(String[] args) throws Exception {

	        URL nettisivu = new URL("http://gunni.arkku.net/index2.htm");
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(nettisivu.openStream()));

	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            System.out.println(inputLine);
	        in.close();
	    }


}
