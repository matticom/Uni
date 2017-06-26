package aud.a05;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class BreadthFirstSearchTest {
		
	private Graph<MyVertex, Edge<MyVertex>> graph8_Directed;
	private Graph<MyVertex, Edge<MyVertex>> graph20_Directed;
	private Graph<MyVertex, Edge<MyVertex>> graph20_Undirected;
	
	/**
     * 	Methode zur Bereitstellung neu initialiserter Graphen (aus Datei gelesen)
     */
	@Before
	public void setUp() {
		String graph8File = "./src/aud/a05/GraphBeispiele/graph8.txt";
		String graph20File = "./src/aud/a05/GraphBeispiele/graph20.txt";
		graph8_Directed = GraphLesen.FileToGraph(graph8File, true);
		graph20_Directed = GraphLesen.FileToGraph(graph20File, true);
		graph20_Undirected = GraphLesen.FileToGraph(graph20File, false);
	}
	
	
	/**
     * Testmethode für Graph 8, gerichtet mit Startpunkt 0
     */
	@Test
	public void testGraph8DirectedWithStart0() {
		System.out.println("Breitensuche: graph8.txt als gerichteter Graph mit Startknoten 0\n"
				+ "------------------------------------------------------------------\n");
		//	Ausgabe der kürzesten Distanz von 0 zu jedem Knoten im Graph (max. bis zum Knoten 8)
		for(int i = 0; i < 9; i++) {
			printShortestDistanceBetween(0, i, graph8_Directed);
		}
		setUp();
		printPathBetween(0, 3, graph8_Directed);
	}
	
	/**
     * Testmethode für Graph 8, gerichtet mit Startpunkt 8
     */
	@Test
	public void testGraph8DirectedWithStart8() {
		System.out.println("Breitensuche: graph8.txt als gerichteter Graph mit Startknoten 8\n"
				+ "------------------------------------------------------------------\n");
		for(int i = 0; i < 9; i++) {
			printShortestDistanceBetween(8, i, graph8_Directed);
		}
		setUp();
		printPathBetween(8, 1, graph8_Directed);
	}
	
	/**
     * Testmethode für Graph 20, gerichtet mit Startpunkt 0
     */
	@Test
	public void testGraph20DirectedWithStart0() {
		System.out.println("Breitensuche: graph20.txt als gerichteter Graph mit Startknoten 0\n"
				+ "------------------------------------------------------------------\n");
		for(int i = 0; i < 8; i++) {
			printShortestDistanceBetween(0, i, graph20_Directed);
		}
		setUp();
		printPathBetween(0, 5, graph20_Directed);
	}
	
	/**
     * Testmethode für Graph 20, ungerichtet mit Startpunkt 0
     */
	@Test
	public void testGraph20UndirectedWithStart0() {
		System.out.println("Breitensuche: graph20.txt als ungerichteter Graph mit Startknoten 0\n"
				+ "--------------------------------------------------------------------\n");
		for(int i = 0; i < 8; i++) {
			printShortestDistanceBetween(0, i, graph20_Undirected);
		}
		setUp();
		printPathBetween(0, 7, graph20_Undirected);
	}
	
	/**
     * Testmethode, ob die Queue eine Exception würft, wenn sie leer ist
     */
	@Test (expected = NoSuchElementException.class)
	public void testQueueEmptyException() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.remove();
	}
	
	/**
     * Methode zur Ausgabe der kürzesten Distanz vom Startknoten zu jedem anderen Knoten im Graph
     * und zur Ausgabe des Vorgängers von jedem Knoten
     * @param startVertexId - Startknoten
     * @param otherVertexId - beliebiger Knoten im Graph
     * @param graph - zu durchsuchender Graph
     */
	public static void printShortestDistanceBetween(int startVertexId, int otherVertexId, Graph<MyVertex, Edge<MyVertex>> graph) {
		int shortestD = BreadthFirstSearch.getShortestDistanceBetween(startVertexId, otherVertexId, graph);
		System.out.printf("Die kürzeste Distanz zwischen Knoten %d und Knoten %d beträgt:    ", startVertexId, otherVertexId);
		//	Ausgabe der kürzesten Distanz
		if (shortestD == Integer.MAX_VALUE) {
			System.out.printf("Es gibt keinen Weg\n");
		} else {
			System.out.printf("%d\n", shortestD);
		}
		System.out.printf("Der Vorgänger von Knoten %d ist:%33s", graph.getVertex(otherVertexId).getId(), "");
		//	Ausgabe der jeweiligen Vorgänger
		if (graph.getVertex(otherVertexId).getPredecessors() == null) {
			System.out.printf("Es gibt keinen Vorgänger\n\n");
		} else {
			System.out.printf("%d\n\n", graph.getVertex(otherVertexId).getPredecessors().getId());
		}
	}

	/**
     * Methode zur Ausgabe des kürzestmöglichen Pfades von einem Startknoten zu 
     * einem anderen, beliebigen Knoten im Graph 
     * @param vertexId1
     * @param vertexId2
     * @param graph
     */
	public static void printPathBetween(int vertexId1, int vertexId2, Graph<MyVertex, Edge<MyVertex>> graph) {
		List<MyVertex> pathList = BreadthFirstSearch.getShortestPathBetween(vertexId1, vertexId2, graph);
		System.out.printf("Der Weg von Knoten %d nach Knoten %d: %28s", vertexId1, vertexId2, "");
		//Iteration durch die Pfadliste + Fallunterscheidung
		for (MyVertex v : pathList) {
			int value = v.getId();
			if (value == vertexId2) {
				System.out.printf("%d", value);
			} else if (value == Integer.MAX_VALUE) {
				System.out.printf("Es gibt keinen Weg");
			} else {
				System.out.printf("%d -> ", value);
			}
		}
		System.out.println("\n\n\n");
	}
}
