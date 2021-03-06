package pr2.a12;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.swing.JOptionPane;

import pr2.a12.exceptions.FileHasNotBeenChosenException;
import pr2.a12.utils.AppPropertiesFileStoring;
import pr2.a12.utils.AppStateSerialization;

public class SmileyModel implements Serializable {
	protected transient PropertyChangeSupport propertyChangeSupport;
	
	protected int x;
	protected int y;
	protected int kopfRadius;
	protected int augenKopfProzent;
	protected double augapfelWinkel;
	protected boolean laecheln;
	protected Locale locale;
		
//	protected AppPropertiesFileStoring propLoadSave;
	
	public SmileyModel() {
		propertyChangeSupport = new PropertyChangeSupport(this);
		kopfRadius = 200;
		augenKopfProzent = 20;
		augapfelWinkel = 0;
		laecheln = false;
		locale = new Locale("es_ES");
		x = 75;
		y = 50;
	}
	
	public Locale getLocale() {
		return locale;
	}
		
	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

	public void setPropertyChangeSupport(PropertyChangeSupport pChangeSupport) {
		this.propertyChangeSupport = pChangeSupport;
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
	
	public void setAllFields(String[] fields) {
		x = Integer.parseInt(fields[0]);
		y = Integer.parseInt(fields[1]);
		kopfRadius = Integer.parseInt(fields[2]);
		augenKopfProzent = Integer.parseInt(fields[3]);
		augapfelWinkel = Double.parseDouble(fields[4]);
		laecheln = Boolean.parseBoolean(fields[5]);
		locale = new Locale(fields[6]);
		generateAndFirePropertyChangeEvent();
	}
	
	protected void generateAndFirePropertyChangeEvent() {
		PropertyChangeEvent e = new PropertyChangeEvent(this, "MODEL_UPDATE", 0, 1);
		firePropertyChangeEvent(e);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		propertyChangeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		propertyChangeSupport.removePropertyChangeListener(l);
	}

	protected void firePropertyChangeEvent(PropertyChangeEvent e) {
		propertyChangeSupport.firePropertyChange(e);
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
	
	public String[] getAllFields() {
		return new String[]{	String.valueOf(x), 
								String.valueOf(y), 
								String.valueOf(kopfRadius),
								String.valueOf(augenKopfProzent), 
								String.valueOf(augapfelWinkel), 
								String.valueOf(laecheln), 
								locale.toString()
							};
	}
	
//	public void saveProps() {
//		if (propLoadSave == null) {
//			propLoadSave = new AppPropertiesFileStoring(this);
//		}
//		propLoadSave.saveProperties();
//	}
//	
//	public void loadProps() {
//		if (propLoadSave == null) {
//			propLoadSave = new AppPropertiesFileStoring(this);
//		}
//		propLoadSave.loadProperties();
//	}
	
}
