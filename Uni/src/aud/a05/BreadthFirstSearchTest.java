package aud.a05;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import aud.a03.QueueOverflow;
import aud.a03.QueueUnderflow;

public class BreadthFirstSearchTest {
		
	private List<MyVertex> pathList;
	private int shortestDistance;
	private Graph<MyVertex, Edge<MyVertex>> graph8_Directed;
	private Graph<MyVertex, Edge<MyVertex>> graph20_Directed;
	private Graph<MyVertex, Edge<MyVertex>> graph20_Undirected;
	
	@Before
	public void setUp() {
		String graph8File = "./src/aud/a05/GraphBeispiele/graph8.txt";
		String graph20File = "./src/aud/a05/GraphBeispiele/graph20.txt";
		graph8_Directed = GraphLesen.FileToGraph(graph8File, true);
		graph20_Directed = GraphLesen.FileToGraph(graph20File, true);
		graph20_Undirected = GraphLesen.FileToGraph(graph20File, false);
	}
	
	@Test
	public void testGraph8DirectedWithStart0() throws QueueOverflow, QueueUnderflow {
		System.out.println("Breitensuche: graph8.txt als gerichteter Graph mit Startknoten 0\n"
				+ "------------------------------------------------------------------\n");
		for(int i = 0; i < 9; i++) {
			printShortestDistanceBetween(0, i, graph8_Directed);
		}
		setUp();
		printPathBetween(0, 3, graph8_Directed);
	}
	
	@Test
	public void testGraph8DirectedWithStart8() throws QueueOverflow, QueueUnderflow {
		System.out.println("Breitensuche: graph8.txt als gerichteter Graph mit Startknoten 8\n"
				+ "------------------------------------------------------------------\n");
		for(int i = 0; i < 9; i++) {
			printShortestDistanceBetween(8, i, graph8_Directed);
		}
		setUp();
		printPathBetween(8, 1, graph8_Directed);
	}
	
	@Test
	public void testGraph20DirectedWithStart0() throws QueueOverflow, QueueUnderflow {
		System.out.println("Breitensuche: graph20.txt als gerichteter Graph mit Startknoten 0\n"
				+ "------------------------------------------------------------------\n");
		for(int i = 0; i < 8; i++) {
			printShortestDistanceBetween(0, i, graph20_Directed);
		}
		setUp();
		printPathBetween(0, 5, graph20_Directed);
	}
	
	@Test
	public void testGraph20UndirectedWithStart0() throws QueueOverflow, QueueUnderflow {
		System.out.println("Breitensuche: graph20.txt als ungerichteter Graph mit Startknoten 0\n"
				+ "--------------------------------------------------------------------\n");
		for(int i = 0; i < 8; i++) {
			printShortestDistanceBetween(0, i, graph20_Undirected);
		}
		setUp();
		printPathBetween(0, 7, graph20_Undirected);
	}
	
	public static void printShortestDistanceBetween(int startVertexId, int otherVertexId, Graph<MyVertex, Edge<MyVertex>> graph) throws QueueOverflow, QueueUnderflow {
		int shortestD = BreadthFirstSearch.getShortestDistanceBetween(startVertexId, otherVertexId, graph);
		System.out.printf("Die kürzeste Distanz zwischen Knoten %d und Knoten %d beträgt:    ", startVertexId, otherVertexId);

		if (shortestD == Integer.MAX_VALUE) {
			System.out.printf("Es gibt keinen Weg\n");
		} else {
			System.out.printf("%d\n", shortestD);
		}
		System.out.printf("Der Vorgänger von Knoten %d ist:%33s", graph.getVertex(otherVertexId).getId(), "");

		if (graph.getVertex(otherVertexId).getPredecessors() == null) {
			System.out.printf("Es gibt keinen Vorgänger\n\n");
		} else {
			System.out.printf("%d\n\n", graph.getVertex(otherVertexId).getPredecessors().getId());
		}
		
	}

	public static void printPathBetween(int vertexId1, int vertexId2, Graph<MyVertex, Edge<MyVertex>> graph) throws QueueOverflow, QueueUnderflow {
		List<MyVertex> pathList = BreadthFirstSearch.getShortestPathBetween(vertexId1, vertexId2, graph);
		System.out.printf("Der Weg von Knoten %d nach Knoten %d: %28s", vertexId1, vertexId2, "");
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
