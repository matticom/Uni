package pr1.a01;

import java.io.PrintWriter;

public class MoreMethods {

	public static void main(String[] args) {

		PrintWriter out = new PrintWriter(System.out, true);
		
		// Aufgabe a
		printAlphabet(out, false);
		printAlphabet(out, true);
		
		// Aufgabe b
		String alphabet = createAlphabet(true); 
		out.println(alphabet);
		alphabet = createAlphabet(false); 
		out.println(alphabet);
		
		// Aufgabe c
		printAlphabet(out, alphabet, true); 
		printAlphabet(out, alphabet, false); 
		
		// Aufgabe d
		printAlphabetAufgabeD(out, true);
		out.println();
		printAlphabetAufgabeD(out, false);
		out.println();
		
		// Aufgabe e
		String charSerie = createCharSeries('1', 12); 
		out.print(charSerie);
		out.flush();
		charSerie = createCharSeries('a', 60); 
		out.print(charSerie);
		out.flush();
		
		// Aufgabe f
		createCharSeries(out, '1', 40);
		createCharSeries(out, 'A', 3);
			
		
	}

	public static void printAlphabet(PrintWriter out, boolean smallLetters) {

		char start = 'A';
		char ende = 'Z';

		if (smallLetters) {
			start = 'a';
			ende = 'z';	
		}

		for (char i = start; i <= ende; i++) {
			
			out.print(i);
			
			if (i != ende) {
				out.print(" ");
			}
			
			out.flush();
		}
		
		out.println("");
	}
	
	public static String createAlphabet(boolean smallLetters) {
		
		char start = 'A';
		char ende = 'Z';
		
		String alphabet = "";

		if (smallLetters) {
			start = 'a';
			ende = 'z';	
		}

		for (char i = start; i <= ende; i++) {
			
			alphabet += i;
			
			if (i != ende) {
				alphabet += " ";
			}
			
		}
		
		return alphabet;
	}
	
	public static void printAlphabet(PrintWriter out, String alphabet, boolean smallLetters) {
		
		out.println(createAlphabet(smallLetters));
	}
	
	public static void printAlphabetAufgabeD(PrintWriter out, boolean smallLetters) {
		
		FirstMethods.printText(out, createAlphabet(smallLetters));
	}
	
	public static String createCharSeries(char startChar, int anzahl) {
		
		String charSerie = "";
		
		boolean lastPosition = true;
		int endChar = startChar + anzahl-1;
		
		if (anzahl % 10 == 0)
			lastPosition = false;
		
		int nextPosition;
		
		
		for(char i = startChar; i <= endChar; i++) {
			
			nextPosition = i - startChar+1; 
			charSerie += i;
			
			if (nextPosition % 10 == 0) {
				charSerie += "\n";
			}
			
		}
		
		if (lastPosition)
			charSerie += "\n";
		
		return charSerie;
	}

	public static void createCharSeries(PrintWriter out, char startChar, int anzahl) {
		
		String charSerie = createCharSeries(startChar, anzahl); 
		out.print(charSerie);
		out.flush();
	}
	

}
