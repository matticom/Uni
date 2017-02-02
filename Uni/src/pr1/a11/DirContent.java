package pr1.a11;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DirContent {

	public static void printAll(File path) {
		checkInputAndPrintFullParentPath(path);
		List<File>[] dirsAndFilesList = sortOutDirsAndFiles(path);
		List<File> dirList = dirsAndFilesList[1];
		List<File> fileList = dirsAndFilesList[0];
		for (File file: fileList) {
			printFile(file);
		}
		for (File file: dirList) {
			printSubDir(file);
		}
	}
	
	public static void printFilesOnly(File path) {
		checkInputAndPrintFullParentPath(path);
		List<File> fileList = sortOutDirsAndFiles(path)[1];
		for (File file: fileList) {
			printFile(file);
		}
	}
	
	public static void printDirsOnly(File path) {
		checkInputAndPrintFullParentPath(path);
		List<File> dirList = sortOutDirsAndFiles(path)[0];
		for (File file: dirList) {
			printSubDir(file);
		}
	}
	
	public static void test(File[] paths) {
		for (File file : paths) {
			printAll(file);
			printFilesOnly(file);
			printDirsOnly(file);
		}
	}
	
	public static void pathArgumentTest(File path) {
		if (!path.exists()) {
			throw new IllegalArgumentException("Verzeichnis oder Datei existiert nicht");
		}
	}
	
	public static List<File>[] sortOutDirsAndFiles(File path) {
		List<File>[] filesAndDirsLists = new List[2];
		List<File> filesList = new ArrayList<File>();
		List<File> dirsList = new ArrayList<File>();
		for (File file: path.listFiles()) {
			if (file.isDirectory()) {
				dirsList.add(file);
			} else {
				filesList.add(file);
			}
		}
		filesAndDirsLists[0] = filesList;
		filesAndDirsLists[1] = dirsList;
		return filesAndDirsLists;
	}
	
	public static void checkInputAndPrintFullParentPath(File path) {
		try {
			pathArgumentTest(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printParentDir(path);
	}
	
	public static void printAll(String path) {
		printAll(new File(path));
	}
	
	private static void printParentDir(File file) {
		System.out.printf("Verzeichnis\t %s\n\n", file.getPath());
	}
	
	private static void printSubDir(File file) {
		System.out.printf("Unterverzeichnis\t %s\n", file.getName());
	}
	
	private static void printFile(File file) {
		System.out.printf("Datei\t\t\t %s\n", file.getName());
	}
	
}
