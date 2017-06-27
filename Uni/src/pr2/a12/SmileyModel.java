package pr2.a12;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Locale;

public class SmileyModel {
	private final PropertyChangeSupport pChangeSupport;
	
	protected int x;
	protected int y;
	protected int kopfRadius;
	protected int augenKopfProzent;
	protected double augapfelWinkel;
	protected boolean laecheln;
	protected Locale locale;
	
	public SmileyModel() {
		pChangeSupport = new PropertyChangeSupport(this);
		kopfRadius = 200;
		augenKopfProzent = 20;
		augapfelWinkel = 0;
		laecheln = false;
		locale = Locale.US;
		x = 75;
		y = 50;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
		generateAndFirePropertyChangeEvent();
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
	
	public void setPleased() {
		laecheln = true;
		augapfelWinkel = 0;
		generateAndFirePropertyChangeEvent();
	}
	
	public void setSad() {
		laecheln = false;
		augapfelWinkel = 90;
		generateAndFirePropertyChangeEvent();
	}
	
	public void decreaseHead() {
		if (kopfRadius > 5) {
			kopfRadius = kopfRadius-2;
		}
		generateAndFirePropertyChangeEvent();
	}
	
	public void increaseHead() {
		if (kopfRadius < 400) {
			kopfRadius = kopfRadius+2;
		}
		generateAndFirePropertyChangeEvent();
	}
	
	public void rotateEyesLeft() {
		augapfelWinkel = augapfelWinkel-5;
		generateAndFirePropertyChangeEvent();
	}
	
	public void rotateEyesRight() {
		augapfelWinkel = augapfelWinkel+5;
		generateAndFirePropertyChangeEvent();
	}
	
	public void setDefaultSmiley() {
		kopfRadius = 200;
		augenKopfProzent = 20;
		augapfelWinkel = 0;
		laecheln = false;
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
		PropertyChangeEvent e = new PropertyChangeEvent(this, "MODEL_UPDATE", 0, 1);
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
