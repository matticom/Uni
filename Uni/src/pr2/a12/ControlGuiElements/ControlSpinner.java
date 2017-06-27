package pr2.a12.ControlGuiElements;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class ControlSpinner extends JSpinner {

protected JComponent parent;
	
	public ControlSpinner(int x, int y, int width, int height,
			ChangeListener controller, ChangeListener aaPCEventListener, String actionCommand, 
			Double startWert, Double minWert, Double maxWert, Double schrittWeite, JComponent parent) {
		super(new SpinnerNumberModel(startWert,minWert,maxWert,schrittWeite));
		addChangeListener(controller);
		addChangeListener(aaPCEventListener);
		setBounds(x, y, width, height);
		setName(actionCommand);
		this.parent = parent;
		parent.add(this);
	}
}
