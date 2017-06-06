package aud.a05;

import java.util.List;

import aud.a03.QueueOverflow;
import aud.a03.QueueUnderflow;

public class GraphTest {

	public static void main(String[] args) throws QueueOverflow, QueueUnderflow {
		String graph = "./src/aud/a05/GraphBeispiele/graph8.txt";
		Graph<Vertex, Edge<Vertex>> graph8 = GraphLesen.FileToGraph(graph, false);
		System.out.println(graph8.toString());
		printShortestDistanceBetween(5, 8, graph8);
		graph8 = GraphLesen.FileToGraph(graph, false);
		printPathBetween(1, 8, graph8);
	}

	public static void printShortestDistanceBetween(int startVertexId, int otherVertexId, Graph<Vertex, Edge<Vertex>> graph) throws QueueOverflow, QueueUnderflow {
		int shortestD = BreadthFirstSearch.getShortestDistanceBetween(startVertexId, otherVertexId, graph);
		System.out.printf("Die kürzeste Distanz zwischen %d und %d beträgt:     ", startVertexId, otherVertexId);

		if (shortestD == Integer.MAX_VALUE) {
			System.out.printf("Es gibt keinen Weg!\n");
		} else {
			System.out.printf("%d\n", shortestD);
		}
		
	}

	public static void printPathBetween(int vertexId1, int vertexId2, Graph<Vertex, Edge<Vertex>> graph) throws QueueOverflow, QueueUnderflow {
		List<Integer> pathList = BreadthFirstSearch.getShortestWayBetween(vertexId1, vertexId2, graph);
		System.out.printf("Der Weg von %d nach %d:     ", vertexId1, vertexId2);
		for (Integer v : pathList) {
			int value = v.intValue();
			if (value == vertexId2) {
				System.out.printf("%d", value);
			} else if (value == Integer.MAX_VALUE) {
				System.out.printf("Es gibt keinen Weg!");
			} else {
				System.out.printf("%d -> ", value);
			}
		}
	}

}
