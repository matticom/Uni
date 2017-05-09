package pr2.a05;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

public class TreePrinter {

	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out, int width, boolean skipLeafs) {
				
	}
	
	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out, int width) {
		
	}
	
	public static void writeTreeBinary(QadTree tree, String path) {
		
	}	
}
