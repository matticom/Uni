package pr1.a03;

import java.io.File;
import java.io.PrintWriter;
import pr1.a02.Schachbrett;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class TestSchachbrett
{
	public static void main(String[] args) {
		
		printSchachbrett("./data/Schachbrett.txt", true);
	}

	public static void printSchachbrett(String filename, boolean isReverse) {
		
		DirtyFileWriter dfw = new DirtyFileWriter(new File(filename));
		PrintWriter out = new PrintWriter(dfw, true);
		
		if (isReverse) {
			Schachbrett.printSchachbrettReverse(out);
		} else {
			Schachbrett.printSchachbrett(out);
		}
		out.close();
		dfw.close();
	}
}
