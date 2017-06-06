package aud.a05;

import java.util.ArrayList;
import java.util.List;

/** Eine Klasse, die Knoten eines Graphen repräsentiert
 * 
 * @author ripphausen
 * @version 1.0
 */
public class Vertex {
	private int id;
	private VisitStatus visitStatus;
	private int distance;
	private Vertex predecessors;
	

	public Vertex(int id) {
		this.id = id;
		visitStatus = VisitStatus.NOT_VISIT;
		distance = Integer.MAX_VALUE;
	}
	
	public int getId() {
		return id;
	}
			
	public VisitStatus getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(VisitStatus visitStatus) {
		this.visitStatus = visitStatus;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Vertex getPredecessors() {
		return predecessors;
	}
	
	public void setPredecessors(Vertex v) {
		predecessors = v;
	}
	
	public String toString() {
		return new Integer(id).toString();
	}
}