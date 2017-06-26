package aud.a05;

public class MyVertex extends Vertex {

	private VisitStatus visitStatus;
	private int distance;
	private MyVertex predecessors;
	
	/**
     * Konstruktor zum Instanziieren eines Knotens
     * Status ist noch nicht besucht, Distanz auf Maximum gesetzt
     * @param id - zugewiesene Id
     */
	public MyVertex(int id) {
		// Initialiserung der Knoten
		super(id);
		visitStatus = VisitStatus.NOT_VISIT;
		distance = Integer.MAX_VALUE;
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
	
	public MyVertex getPredecessors() {
		return predecessors;
	}
	
	public void setPredecessors(MyVertex v) {
		predecessors = v;
	}

}