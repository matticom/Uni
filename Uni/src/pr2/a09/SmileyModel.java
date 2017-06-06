package pr2.a09;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SmileyModel {
	private final PropertyChangeSupport pChangeSupport = new PropertyChangeSupport(this);
	
	protected int x;
	protected int y;
	protected int kopfRadius;
	protected int augenKopfProzent;
	protected double augapfelWinkel;
	protected boolean laecheln;
	
	public SmileyModel() {
		kopfRadius = 200;
		augenKopfProzent = 20;
		augapfelWinkel = Math.PI/2;
		laecheln = false;
		x = 0;
		y = 0;
	}
	
	public void setKopfRadius(int kopfRadius) {
		this.kopfRadius = kopfRadius;
		generateAndFirePropertyChangeEvent();
	}

	public void setAugenKopfProzent(int augenKopfProzent) {
		this.augenKopfProzent = augenKopfProzent;
		generateAndFirePropertyChangeEvent();
	}

	public void setAugapfelWinkel(double augapfelWinkel) {
		this.augapfelWinkel = augapfelWinkel;
		generateAndFirePropertyChangeEvent();
	}

	public void setLaecheln(boolean laecheln) {
		this.laecheln = laecheln;
		generateAndFirePropertyChangeEvent();
	}
	
	public void moveRelativ(int dx, int dy) {
		x += dx;
		y += dy;
		generateAndFirePropertyChangeEvent();
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		generateAndFirePropertyChangeEvent();
	}
	
	public void generateAndFirePropertyChangeEvent() {
		PropertyChangeEvent e = new PropertyChangeEvent(this, "MODEL_UPDATE", null, null);
		firePropertyChangeEvent(e);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		pChangeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		pChangeSupport.removePropertyChangeListener(l);
	}

	protected void firePropertyChangeEvent(PropertyChangeEvent e) {
		pChangeSupport.firePropertyChange(e);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getKopfRadius() {
		return kopfRadius;
	}

	public int getAugenKopfProzent() {
		return augenKopfProzent;
	}

	public double getAugapfelWinkel() {
		return augapfelWinkel;
	}

	public boolean isLaecheln() {
		return laecheln;
	}
}
