package pr1.a03;

import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class Hypothenuse {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DirtyFileWriter dfw = new DirtyFileWriter(new File("./data/Hypothenuse.txt"));
		PrintWriter out = new PrintWriter(dfw, true);
		printHypothenuse(4, 4, 6, 2, out);
		out.println();
		testHypothenuse(7, 2, out);
		out.flush();
		out.close();
	}

	public static double hypothenuse(double k1, double k2) {

		return Math.hypot(k1, k2);
	}

	public static void printHypothenuse(double k1, double k2, int width, int precision, PrintWriter out) {

		out.printf("%" + width + "." + precision + "f", Math.hypot(k1, k2));
	}

	public static void testHypothenuse(int width, int precision, PrintWriter out) {

		for (int k1 = 0; k1 <= 10; k1++) {
//			out.printf("%" + width + "d", k1);

			for (int k2 = 1; k2 <= 10; k2++) {
				if (k1 == 20) {
					out.printf("%" + width + "d", k2);
				} else {
					printHypothenuse(k1, k2, width, precision, out);
				}
			}
			out.println();
		}
	}

}
