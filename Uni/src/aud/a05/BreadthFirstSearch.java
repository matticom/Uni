package aud.a05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BreadthFirstSearch {

	protected Queue<MyVertex> queue;
	protected Graph<MyVertex, Edge<MyVertex>> graph;
	protected MyVertex startVertex;
	
	private BreadthFirstSearch(Graph<MyVertex, Edge<MyVertex>> graph, int startId) {
		this.graph = graph;
		queue = new LinkedList<MyVertex>();
		initializeBFS(startId);
		breadthSearchAlgorithms();
	}
	
	protected void initializeBFS(int startId) {
		startVertex = graph.getVertex(startId);
		startVertex.setVisitStatus(VisitStatus.NEIGHBOURS_NOT_VISIT);
		startVertex.setDistance(0);
		queue.add(startVertex);
		// die anderen Vertices werden autom. beim Instanziieren initialisiert
	}
	
	protected void breadthSearchAlgorithms() {
		while (!queue.isEmpty()) {
			MyVertex currentVertex = queue.remove();
			for (MyVertex neighbour: graph.getNeighbours(currentVertex)) {
				if (neighbour.getVisitStatus() == VisitStatus.NOT_VISIT) {
					neighbour.setVisitStatus(VisitStatus.NEIGHBOURS_NOT_VISIT);
					neighbour.setDistance(currentVertex.getDistance()+1);
					neighbour.setPredecessors(currentVertex);
					queue.add(neighbour);
				}
			}
			currentVertex.setVisitStatus(VisitStatus.ALL_VISIT);
		}
	}
	
	public static int getShortestDistanceBetween(int startVertexId, int otherVertexId, Graph<MyVertex, Edge<MyVertex>> graph) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, startVertexId);
		return bfs.graph.getVertex(otherVertexId).getDistance();
	}
	
	public static List<MyVertex> getShortestPathBetween(int vertexId1, int vertexId2, Graph<MyVertex, Edge<MyVertex>> graph) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, vertexId1);
		List<MyVertex> verticesPath = new ArrayList<MyVertex>();
		
		if (vertexId1 == vertexId2) {
			verticesPath.add(bfs.graph.getVertex(vertexId1));
			return verticesPath;
		}
		
		MyVertex startVertex = bfs.graph.getVertex(vertexId1);
		MyVertex endVertex = bfs.graph.getVertex(vertexId2);
		MyVertex predecessor = endVertex.getPredecessors();
		
		if (predecessor == null) {
			verticesPath.add(new MyVertex(Integer.MAX_VALUE));
			return verticesPath;
		}
		verticesPath.add(endVertex);
		
		while (!predecessor.equals(startVertex)){
			verticesPath.add(predecessor);
			predecessor = predecessor.getPredecessors();
		}
		// predecessor == startVertex
		verticesPath.add(predecessor);
		Collections.reverse(verticesPath);
		return verticesPath;
	}
	
}
