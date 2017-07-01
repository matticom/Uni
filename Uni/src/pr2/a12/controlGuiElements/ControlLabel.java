package pr2.a12.controlGuiElements;

import java.awt.Label;

import javax.swing.JComponent;

public class ControlLabel extends Label {

	protected JComponent parent;
	
	public ControlLabel(String LblText, int x, int y, int width, int height, 
			JComponent parent) {
		super(LblText);
		if (width != 0 && height != 0) {
			setBounds(x, y, width, height);
		}
		this.parent = parent;
		parent.add(this);
	}

}
