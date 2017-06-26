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
	
	
	/**
     * Vollständiger Konstruktor für ein Breitensuche-Objekt
     * @param graph - mit Knoten und der dazugehörigen Kante
     * @param startId - Id des Startknotens
     */
	protected BreadthFirstSearch(Graph<MyVertex, Edge<MyVertex>> graph, int startId) {
		this.graph = graph;
		//Queue zum (Zwischen-)Speichern der Knoten
		queue = new LinkedList<MyVertex>();
		initializeBFS(startId);
		breadthSearchAlgorithms();
	}
	
	 /**
     * Methode zum Initialisieren einer Breitensuche, wobei der Startknoten festgelegt wird
     * Der Status des Startknoten wird als "Nachbar noch nicht besucht" festgelegt, die Distanz des 
     * Kknotens zu sich selbst ist 0
     * @param startId - Id des Startknoten, von dem die Breitensuche durchgeführt wird
     */
	protected void initializeBFS(int startId) {
		startVertex = graph.getVertex(startId);
		startVertex.setVisitStatus(VisitStatus.NEIGHBOURS_NOT_VISIT);
		startVertex.setDistance(0);
		queue.add(startVertex);
		// die anderen Vertices werden autom. beim Instanziieren initialisiert
	}
	
	/**
     * Methode zur Durchführung Breitensuchenalgorithmus auf dem gegebenen Graphen
     */
	protected void breadthSearchAlgorithms() {
		while (!queue.isEmpty()) {
			//Der aktuell betrachtete Knoten wird aus der Queue entfernt
			MyVertex currentVertex = queue.remove();
			//Iteration durch alle Nachbarn des entfernten Knotens
			for (MyVertex neighbour: graph.getNeighbours(currentVertex)) {
				//Aktionen für noch nicht besuchte Knoten
				if (neighbour.getVisitStatus() == VisitStatus.NOT_VISIT) {
					neighbour.setVisitStatus(VisitStatus.NEIGHBOURS_NOT_VISIT);
					neighbour.setDistance(currentVertex.getDistance()+1);
					neighbour.setPredecessors(currentVertex);
					queue.add(neighbour);
				}
			}
			//Alle Nachbarn des aktuell betrachteten Knotens sind besucht worden
			currentVertex.setVisitStatus(VisitStatus.ALL_VISIT);
		}
	}
	
	 /**
     * Methode zum Ermitteln der kürzesten Distanz zwischen zwei Knoten in einem gegebenen Graphen
     * @param startVertexId - Startknoten
     * @param otherVertexId - Endknoten
     * @param graph - Graph, in dem die Distanzermittlung durchgeführt wird
     * @return - Rückgabe der Distanz
     */
	public static int getShortestDistanceBetween(int startVertexId, int otherVertexId, Graph<MyVertex, Edge<MyVertex>> graph) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, startVertexId);
		//getDistance aus der Klasse MyVertex
		return bfs.graph.getVertex(otherVertexId).getDistance();
	}
	
	/**
     * Methode zur Ermittlung des Pfades zwischen zwei Knoten
     * @param vertexId1 - Startknoten zur Ermittlung des Pfades zum weiteren Knoten
     * @param vertexId2 - beliebiger Knoten, bis zu dem der Pfad vom Startknoten aus ermittelt werden soll
     * @param graph - Graph in dem die Ermittlung des Pfades zwischen den beiden Knoten erfolgt
     * @return Liste mit den Knoten im Pfad
     */
	public static List<MyVertex> getShortestPathBetween(int vertexId1, int vertexId2, Graph<MyVertex, Edge<MyVertex>> graph) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, vertexId1);
		List<MyVertex> verticesPath = new ArrayList<MyVertex>();
		
		// 1.Fall: Knoten sind identisch, Distanz ist 0, daher hat Pfad nur 1 Element 
		if (vertexId1 == vertexId2) {
			verticesPath.add(bfs.graph.getVertex(vertexId1));
			return verticesPath;
		}
		
		MyVertex startVertex = bfs.graph.getVertex(vertexId1);
		MyVertex endVertex = bfs.graph.getVertex(vertexId2);
		MyVertex predecessor = endVertex.getPredecessors();
		
		//	2. Fall(gerichteter Graph): Wenn der (End-)Knoten im Graph nicht erreicht wurde, 
        //  also keine Vorgänger hat, dann nur Rückgabe einer neuen Knotens mit ID = Integer.MAX_VALUE
		//	(bedeutet, dass kein Weg existiert)
		if (predecessor == null) {
			verticesPath.add(new MyVertex(Integer.MAX_VALUE));
			return verticesPath;
		}
		verticesPath.add(endVertex);
		
		//	Rückwärts-Iteration bis der ermittelte Vorgänger (vom Endknoten aus) gleich 
        //	dem Startknoten ist - Vorgänger werden jeweils einer Liste hinzugefügt
		while (!predecessor.equals(startVertex)){
			verticesPath.add(predecessor);
			predecessor = predecessor.getPredecessors();
		}
		// predecessor == startVertex
		verticesPath.add(predecessor);
		//	da Liste in falscher Reihenfolge vorliegt, Umkehrung
		Collections.reverse(verticesPath);
		return verticesPath;
	}
	
}
