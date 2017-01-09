package pr1.a10;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

public class TestStringUtil {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		String[] testStrings = StringUtil.createTestStrings01();
		for(String testString : testStrings) {
			out.printf("Der zu untersuchende String: '%s'\n", testString);
			out.printf("Anzahl der Groﬂbuchstaben: %d \n", StringUtil.countUpperCaseChar(testString));
			out.printf("Anzahl der Whitespacezeichen: %5.2f %%\n", StringUtil.getRatioWhitespaceToAll(testString));
			out.println();
		}
		out.println("\n\n\nDer String in der Datei: '");
		
		Scanner in = new Scanner(new DirtyFileReader("./data/StringUtilTestText.txt"));
		while(in.hasNextLine()) {
			out.println(in.nextLine());
		}
		in.close();
		out.println("'");
		out.printf("Anzahl der Groﬂbuchstaben in der Datei: %d \n", StringUtil.countUpperCaseChar(new File("./data/StringUtilTestText.txt")));
		out.printf("Anzahl der Whitespacezeichen in der Datei: %5.2f %%\n", StringUtil.getRatioWhitespaceToAll(new File("./data/StringUtilTestText.txt")));
		out.println();
	}

}
