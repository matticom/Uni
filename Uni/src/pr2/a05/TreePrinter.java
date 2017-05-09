package pr2.a05;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import schimkat.berlin.lernhilfe2015ss.tree.QadTree;
import schimkat.berlin.lernhilfe2015ss.tree.QadTreeWalker;

public class TreePrinter {

	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out) {
		while(iterator.hasNext()) {
			TreeNode tnode = iterator.next();
			System.out.println(tnode);
		}
	}
	
	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out, int width, boolean skipLeafs) {
		while (iterator.hasNext()) {
			TreeNode node = iterator.next();
			if (node.isLeaf() && skipLeafs) {
				continue;
			}
			out.printf("%-" + width + "s", node);
			if (node.getChildCount() == 0) {
				out.println();
				continue;
			}
			for (int i = 0; i < node.getChildCount(); i++) {
				out.printf("%-" + width + "s", node.getChildAt(i));
			}
			out.println(); 
		}
	}
	
	public static void printTree(QadTree tree, PrintWriter out, int width) {
		Iterator<TreeNode> preorderIter = QadTreeWalker.preorderIterator(tree);
		PrintWriter openFile = printRoot(preorderIter, tree, out);
		preorderIter = QadTreeWalker.preorderIterator(tree);
		printTree(preorderIter, openFile, width, true);
	}
	
	private static PrintWriter printRoot(Iterator<TreeNode> iterator, QadTree tree,  PrintWriter out) {
		while (iterator.hasNext()) {
			out.println(iterator.next());
			break;
		}
		return out;
	}
	
}
