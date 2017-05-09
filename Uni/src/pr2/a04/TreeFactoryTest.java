package pr2.a04;
import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

public class TreeFactoryTest {

	public static void main(String[] args) {
		QadTree myTree = TreeFactory.createTree("./listen/tree-02_back.txt");
		myTree.showInGUI(300, 300, 200, 700);
		TreeFactory.buildTree().showInGUI(600, 300, 150, 400);
	}
}
