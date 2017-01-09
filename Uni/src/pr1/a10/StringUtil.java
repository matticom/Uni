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
		// Große Umlaute
		testStrings[1] = "große Übung";
		// Sonderzeichen mit Großbuchstaben
		testStrings[2] = "123ß?+#ñÑ+ñ-";
		// Sonderzeichen innerhalb UTF-16
		testStrings[3] = "\u0A03";
		// String mit "besonderen" Whitespace
		testStrings[4] = "Hallo		 hallo \r\n";
		// Weitere Whitespace-Escapesequenzen
		testStrings[5] = "\b\n\r\t\f\u000B";
		return testStrings;
	}

	public static int countUpperCaseChar(File textfile) {
		return countUpperCaseChar(getStringOfTextFile(textfile));
	}

	public static double getRatioWhitespaceToAll(File textfile) {
		return getRatioWhitespaceToAll(getStringOfTextFile(textfile));
	}

	private static String getStringOfTextFile(File textfile) {
		Scanner in = new Scanner(new DirtyFileReader(textfile));
		StringBuilder sb = new StringBuilder();
		while(in.hasNextLine()) {
			if (sb.length() > 0) {
				sb.append("\n");
			}
			sb.append(in.nextLine());
		}
		in.close();
		return sb.toString();
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
