package pr2.a07;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class WetterModel {
	private final PropertyChangeSupport pChangeSupport = new PropertyChangeSupport(this);
	private List<pr2.a07e.Wetterzustand> wetterliste;
	private final String name;

	public WetterModel(String name) {
		wetterliste = new ArrayList<pr2.a07e.Wetterzustand>();
		this.name = name;
	}

	public pr2.a07e.Wetterzustand getWetterzustand() {
		if (wetterliste.size() > 0) {
			return wetterliste.get(wetterliste.size() - 1);
		} else {
			return null;
		}
	}

	public List<pr2.a07e.Wetterzustand> getWetterliste() {
		return wetterliste;
	}

	public void setWetter(pr2.a07e.Wetterzustand wetterzustand) {
		PropertyChangeEvent e = new PropertyChangeEvent(this, name, getWetterzustand(), wetterzustand);
		firePropertyChangeEvent(e);
		wetterliste.add(wetterzustand);
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
}
