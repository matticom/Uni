package pr1.a04;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class FirstInput {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		scannerAusprobieren();
	}
	
	public static void scannerAusprobieren() {
		
		String intNumbers = "3 3 4 4 5 6 6 7 7";
		String doubleNumbers = "3.1 3.2 4.3 4.4 5.5 6.6 6.7 7.8 7.9";
		String mixedNumbers = "1 1.3 2 3.3 4 5.5";
		
		Scanner inInt = new Scanner(intNumbers);
		Scanner inDouble = new Scanner(doubleNumbers);
		Scanner inMixed = new Scanner(mixedNumbers);
		
		// Aufgabe 4. Vorübung a
		scanToConsole(inInt);
		scanToConsole(inDouble);
		scanToConsole(inMixed);
		inInt.close();
		inDouble.close();
		inMixed.close();
				
		// Aufgabe 4. Vorübung b
		Scanner inDatei = new Scanner(new DirtyFileReader("./data/testfiles/zahlen01.txt"));
		scanToConsole(inDatei);
		inDatei.close();
		
		// Aufgabe 4.a 
		Scanner inCountSumOf = new Scanner(mixedNumbers);
		System.out.println("Summe (als Integer Cast) von mixedNumbers ist " + countSumOf(inCountSumOf));
		inCountSumOf.close();
		
		// Aufgabe 4.a 
		System.out.println("Summe (als Integer Cast) von zahlen01 ist " + countSumOf("./data/testfiles/zahlen01.txt"));
		
		// Aufgabe 4.a
		Scanner inPrint = new Scanner(new DirtyFileReader("./data/testfiles/zahlen01.txt"));
		PrintWriter out = new PrintWriter(System.out, true);
		printNumbersFrom(inPrint, 6, 1, out);
		inPrint.close();
		
		// Aufgabe 4.b.1
		Scanner in1 = new Scanner(new DirtyFileReader("./data/Aufgabe3cTeil1.txt"));
		printNumbersFrom(in1, 9, 1, out);
		in1.close();
		Scanner in2 = new Scanner(new DirtyFileReader("./data/Aufgabe3cTeil2.txt"));
		printNumbersFrom(in2, 9, 1, out);
		in2.close();
		Scanner in3 = new Scanner(new DirtyFileReader("./data/Hypothenuse.txt"));
		printNumbersFrom(in3, 9, 2, out);
		in3.close();
		out.close();
		
		// Aufgabe 4.b.2
		copyNumberFile("./data/testfiles/zahlen01.txt", "./data/testfiles/zahlen02.txt", 9, 2);
	}
	
	public static void scanToConsole(Scanner in) {
		int counter = 0;	
		while(in.hasNext()) {
			counter++;
			System.out.println(counter + ". Zahl: " + scanNextNumber(in));
		}
		System.out.println();
	}
	
	public static int countSumOf(Scanner in) {
		double sum = 0;
		while(in.hasNext()) {
			sum += scanNextNumber(in);
		}
		return (int) sum;	
	}
	
	public static int countSumOf(String  filename) {
		DirtyFileReader dfr = new DirtyFileReader(filename);
		Scanner inDatei = new Scanner(dfr);
		int sum = countSumOf(inDatei);
		inDatei.close();
		dfr.close();
		return sum;
	}
	
	public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out) {
		int counter = 0;
		while(in.hasNext()) {
			counter++;
			out.printf("%" + width + "." + precision + "f", scanNextNumber(in));
			if (counter % 10 == 0) {
				out.println();
			}
		}
		out.println();
		out.println();
	}
	
	public static double scanNextNumber(Scanner in) {
		double retValue = 0;
		if (in.hasNextInt()) {
			retValue = (double) in.nextInt();
		}
		else if (in.hasNextDouble()) {
			retValue =  in.nextDouble();
		} 
		return retValue;
	}
	
	public static void copyNumberFile(String sourceFilename, String destinationFilename, int width, int precision) {
		PrintWriter out = new PrintWriter(new DirtyFileWriter(destinationFilename), true);
		printNumbersFrom(new Scanner(new DirtyFileReader(sourceFilename)), width, precision, out);
	}
}
