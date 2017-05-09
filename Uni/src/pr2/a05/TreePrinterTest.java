package pr2.a05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import pr2.a04.TreeFactory;
import schimkat.berlin.lernhilfe2015ss.tree.QadTree;
import schimkat.berlin.lernhilfe2015ss.tree.QadTreeWalker;

public class TreePrinterTest {

	public static void main(String[] args) {
		QadTree myTree = TreeFactory.createTree("./listen/tree-02.txt");
		PrintWriter consoleOut = new PrintWriter(System.out, true);
		Iterator<TreeNode> inorderIter = QadTreeWalker.inorderIterator(myTree);
		Iterator<TreeNode> postorderIter = QadTreeWalker.postorderIterator(myTree);
		Iterator<TreeNode> preorderIter = QadTreeWalker.preorderIterator(myTree);
		System.out.println("\nStart\n");
		consoleOut.println("Inorder Iterator: ");
		TreePrinter.printTree(inorderIter, consoleOut, 20, true);
		consoleOut.println("\n\nPostorder Iterator: ");
		TreePrinter.printTree(postorderIter, consoleOut, 20, true);
		consoleOut.println("\n\nPreorder Iterator: ");
		TreePrinter.printTree(preorderIter, consoleOut, 20, true);
		try (FileWriter fw = new FileWriter(new File("./listen/baum2.txt"))) {
			PrintWriter fileOut = new PrintWriter(fw, true);
			TreePrinter.printTree(myTree, fileOut, 20);
		} catch (IOException e) {
			System.out.println("Problem beim Öffnen der Datei zum Schreiben");
		}
	}
}
