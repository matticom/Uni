package pr1.a11;

import java.io.File;
import java.io.PrintWriter;

public class DirContent {

	public static void printAll(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		if (!path.isDirectory() || !path.exists()) {
			throw new IllegalArgumentException("Verzeichnis existiert nicht oder ist eine Datei");
		}
		
		printParentDir(out, path);
		for (File file: path.listFiles()) {
			if (file.isDirectory()) {
				printSubDir(out, file);
			} else {
				printFile(out, file);
			}
		}
		out.println();
		out.println();
	}
	
	public static void printFilesOnly(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		if (!path.isDirectory() || !path.exists()) {
			throw new IllegalArgumentException("Verzeichnis existiert nicht oder ist eine Datei");
		}
		
		printParentDir(out, path);
		for (File file: path.listFiles()) {
			if (!file.isDirectory()) {
				printFile(out, file);
			}
		}
		out.println();
		out.println();
	}
	
	public static void printDirsOnly(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		if (!path.isDirectory() || !path.exists()) {
			throw new IllegalArgumentException("Verzeichnis existiert nicht oder ist eine Datei");
		}
		
		printParentDir(out, path);
		for (File file: path.listFiles()) {
			if (file.isDirectory()) {
				printSubDir(out, file);
			}
		}
		out.println();
		out.println();
	}
	
	public static void test(File[] paths) {
		for (File file : paths) {
			printAll(file);
			printFilesOnly(file);
			printDirsOnly(file);
		}
	}
	
	public static void printAll(String path) {
		printAll(new File(path));
	}
	
	private static void printParentDir(PrintWriter out, File file) {
		out.printf("Verzeichnis\t %s\n\n", file.getPath());
	}
	
	private static void printSubDir(PrintWriter out, File file) {
		out.printf("Unterverzeichnis\t %s\n", file.getName());
	}
	
	private static void printFile(PrintWriter out, File file) {
		out.printf("Datei\t\t\t %s\n", file.getName());
	}
	
}
