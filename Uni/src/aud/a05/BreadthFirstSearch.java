package aud.a05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aud.a03.Queue;
import aud.a03.QueueOverflow;
import aud.a03.QueueUnderflow;

public class BreadthFirstSearch {

	protected Queue<Vertex> queue;
	protected Graph<Vertex, Edge<Vertex>> graph;
	protected Vertex startVertex;
	
	private BreadthFirstSearch(Graph<Vertex, Edge<Vertex>> graph, int startId) throws QueueOverflow, QueueUnderflow {
		this.graph = graph;
		queue = new Queue<Vertex>(100);
		initializeBFS(startId);
		breadthSearchAlgorithms();
	}
	
	protected void initializeBFS(int startId) throws QueueOverflow {
		startVertex = graph.getVertex(startId);
		startVertex.setVisitStatus(VisitStatus.NEIGHBOURS_NOT_VISIT);
		startVertex.setDistance(0);
		queue.enqueue(startVertex);
		// die anderen Vertices werden autom. beim Instanziieren initialisiert
	}
	
	protected void breadthSearchAlgorithms() throws QueueUnderflow, QueueOverflow {
		while (queue.isNotEmpty()) {
			Vertex currentVertex = queue.dequeue();
			for (Vertex neighbour: graph.getNeighbours(currentVertex)) {
				if (neighbour.getVisitStatus() == VisitStatus.NOT_VISIT) {
					neighbour.setVisitStatus(VisitStatus.NEIGHBOURS_NOT_VISIT);
					neighbour.setDistance(currentVertex.getDistance()+1);
					neighbour.setPredecessors(currentVertex);
					queue.enqueue(neighbour);
				}
			}
			currentVertex.setVisitStatus(VisitStatus.ALL_VISIT);
		}
	}
	
	public static int getShortestDistanceBetween(int startVertexId, int otherVertexId, Graph<Vertex, Edge<Vertex>> graph) throws QueueOverflow, QueueUnderflow {
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, startVertexId);
		return bfs.graph.getVertex(otherVertexId).getDistance();
	}
	
	public static List<Integer> getShortestWayBetween(int vertexId1, int vertexId2, Graph<Vertex, Edge<Vertex>> graph) throws QueueOverflow, QueueUnderflow {
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, vertexId1);
		List<Integer> verticesPath = new ArrayList<Integer>();
		
		if (vertexId1 == vertexId2) {
			verticesPath.add(vertexId1);
			return verticesPath;
		}
		
		Vertex startVertex = bfs.graph.getVertex(vertexId1);
		Vertex endVertex = bfs.graph.getVertex(vertexId2);
		Vertex predecessor = endVertex.getPredecessors();
		
		if (predecessor == null) {
			verticesPath.add(Integer.MAX_VALUE);
			return verticesPath;
		}
		verticesPath.add(endVertex.getId());
		
		while (!predecessor.equals(startVertex)){
			verticesPath.add(predecessor.getId());
			predecessor = predecessor.getPredecessors();
		}
		// predecessor == startVertex
		verticesPath.add(predecessor.getId());
		Collections.reverse(verticesPath);
		return verticesPath;
	}
	
}
