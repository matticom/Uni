package pr2.a05;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import pr2.a04.TreeFactory;
import schimkat.berlin.lernhilfe2015ss.tree.QadTree;
import schimkat.berlin.lernhilfe2015ss.tree.QadTreeWalker;

public class TreePrinterTest {

	public static void main(String[] args) {
		QadTree myTree = TreeFactory.createTree("./listen/baum2.txt");
		PrintWriter pw = new PrintWriter(System.out, true);
		Iterator<TreeNode> inorderIter = QadTreeWalker.inorderIterator(myTree);
		Iterator<TreeNode> postorderIter = QadTreeWalker.postorderIterator(myTree);
		Iterator<TreeNode> preorderIter = QadTreeWalker.preorderIterator(myTree);
		System.err.println("\nStart\n");
		pw.println("Inorder Iterator: ");
		TreePrinter.printTree(inorderIter, pw);
		pw.println("\n\nPostorder Iterator: ");
		TreePrinter.printTree(postorderIter, pw);
		pw.println("\n\nPreorder Iterator: ");
		TreePrinter.printTree(preorderIter, pw);
	}

}
