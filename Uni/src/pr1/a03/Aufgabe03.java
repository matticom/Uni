package pr1.a03;

import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class Aufgabe03
{

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		writeIntNumberFile("./data/Aufgabe3cTeil1.txt", 4444);
		writeIntNumberFile("./data/Aufgabe3cTeil2.txt", 4444, 10);
	}
	
	public static void writeIntNumberFile(String filename, int numberCount) {
		
		DirtyFileWriter dfw = new DirtyFileWriter(new File(filename));
		PrintWriter out = new PrintWriter(dfw, true);
		
		if (numberCount%2 != 0) {
			numberCount++;
		}
		
		int feldbreite = Integer.valueOf(numberCount).toString().length() + 4;
				
		for (int counter = 1; counter <= numberCount; counter++) {
			
			out.printf("%" + feldbreite + "d", numberCount);
			if ( counter % 10 == 0) {
				out.println();
			}	
		}
		out.flush();
		out.close();
		dfw.close();
	}
	
	public static void writeIntNumberFile(String filename, int numberCount, int width) {
		
		DirtyFileWriter dfw = new DirtyFileWriter(new File(filename));
		PrintWriter out = new PrintWriter(dfw, true);
		
		if (numberCount%2 != 0) {
			numberCount++;
		}
		
		int randomPosition = 0;
		double randomDouble = 0;
		
		for (int counter = 1; counter <= numberCount; counter++) {
			
			randomDouble = Math.random()*1000-500;
			randomPosition = (int)randomDouble;
			
			
			if (randomPosition % 2 == 0) {
				out.printf("%" + width + "d", randomPosition);
			} 
			else {
				out.printf("%" + width + ".2f", randomDouble);
			}
			
			if ( counter % 10 == 0) {
				out.println();
			}	
		}
		out.flush();
		out.close();
		dfw.close();
	}
}
