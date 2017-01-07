package pr1.a10;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

public class StringUtil {

	public static int countUpperCaseChar(String s) {
		int numbersOfUpperCaseChar = 0;
		for (int pos = 0; pos < s.length(); pos++) {
			if (Character.isUpperCase(s.charAt(pos))) {
				numbersOfUpperCaseChar++;
			}
		}
		return numbersOfUpperCaseChar;
	}

	public static double getRatioWhitespaceToAll(String s) {
		if (s.length() > 0) {
			int numbersOfWhiteSpaceChar = countWhiteSpaceChar(s);
			return 100.0 * numbersOfWhiteSpaceChar / s.length();
		} else {
			return 0;
		}
	}

	public static String[] createTestStrings01() {
		String[] testStrings = new String[6];
		// Kein String
		testStrings[0] = "";
		// Groﬂe Umlaute
		testStrings[1] = "groﬂe ‹bung";
		// Sonderzeichen mit Groﬂbuchstaben
		testStrings[2] = "123ﬂ?+#Ò—+Ò-";
		// Sonderzeichen innerhalb UTF-16
		testStrings[3] = "\u0A03";
		// String mit "besonderen" Whitespace
		testStrings[4] = "Hallo		 hallo \r\n";
		// Weitere Whitespace-Escapesequenzen
		testStrings[5] = "\b\n\r\t\f\u000B";
		return testStrings;
	}

	public static int countUpperCaseChar(File textfile) {
		List<String> linesAsStringList = getLinesOfTextFileAsListOfStrings(textfile);
		int numbersOfUpperCaseChar = 0;
		for (String line : linesAsStringList) {
			numbersOfUpperCaseChar += countUpperCaseChar(line);
		}
		return numbersOfUpperCaseChar;
	}

	public static double getRatioWhitespaceToAll(File textfile) {
		List<String> linesAsStringList = getLinesOfTextFileAsListOfStrings(textfile);
		int numbersOfWhitespaceChar = 0;
		int numbersOfAllChar = 0;
		for (String line : linesAsStringList) {
			numbersOfAllChar += line.length();
			numbersOfWhitespaceChar += countWhiteSpaceChar(line);
		}
		return 100.0 * numbersOfWhitespaceChar / numbersOfAllChar;
	}

	private static List<String> getLinesOfTextFileAsListOfStrings(File textfile) {
		Scanner in = new Scanner(new DirtyFileReader(textfile));
		List<String> linesAsStringList = new ArrayList<String>();
		while(in.hasNextLine()) {
			linesAsStringList.add(in.nextLine());
		}
		in.close();
		return linesAsStringList;
	}

	private static int countWhiteSpaceChar(String s) {
		int numbersOfWhiteSpaceChar = 0;
		for (int pos = 0; pos < s.length(); pos++) {
			if (Character.isWhitespace(s.charAt(pos))) {
				numbersOfWhiteSpaceChar++;
			}
		}
		return numbersOfWhiteSpaceChar;
	}
}
