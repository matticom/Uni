package pr2.a04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

public class TreeFactory {
	public static QadTree buildTree() {
		QadTree myTree = new QadTree("root");
		myTree.addChilds("root", new String[]{"A", "B", "C"});
		myTree.addChilds("A", new String[]{"A1", "A2"});
		myTree.addChilds("B", new String[]{"B1", "B2"});
		myTree.addChilds("C", new String[]{"C1", "C2"});
		myTree.addChild("A1", "A1a");
		myTree.addChild("B1", "B1a");
		myTree.addChild("C1", "C1a");
		return myTree;
	}
	
	public static QadTree createTree(String path) {
		String[] lines = readLines(path);
		QadTree tree = createTree(lines);
		return tree;
	}
	
	private static String[] readLines(String path) {
		try (FileReader reader = new FileReader(new File(path)); Scanner in = new Scanner(reader)){
			return createArray(in);
		} catch (NullPointerException e) {
			System.err.println("NP");
		} catch (FileNotFoundException e) {
			System.err.println("Datei " +  path + " nicht gefunden");
		} catch (IOException e1) {
			System.err.println("Problem bei close");
		}
		return null;
	}
	
	private static String[] createArray(Scanner in) {
		List<String> arrayList = new ArrayList<String>();
		while (in.hasNextLine()) {
			arrayList.add(in.nextLine());
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}
	
	private static QadTree createTree(String[] lines) {
		QadTree myTree = null;
		if (lines.length >= 1) {
			myTree = createTreeWithRootName(lines[0]);
		}
		for(int i = 1; i < lines.length; i++) {
			List<String> childrenList = new ArrayList<String>();
			String parent = extractSubTreeFromLine(childrenList, lines[i]);
			String[] children = childrenList.toArray(new String[childrenList.size()]);
			myTree.addChilds(parent, children);
		}
		return myTree;
	}
	
	private static QadTree createTreeWithRootName(String rootName) {
		Scanner in = new Scanner(rootName);
		QadTree myTree = new QadTree(in.next());
		in.close();
		return myTree;
	}
	
	private static String extractSubTreeFromLine(List<String> children, String line) {
		Scanner in = new Scanner(line);
		String parent = "";
		boolean isParent = true;
		while(in.hasNext()) {
			if (isParent) {
				parent = in.next();
				isParent = false;
			} else {
				children.add(in.next());
			}
		}
		in.close();
		return parent;
	}
}
