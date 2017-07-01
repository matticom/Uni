package pr2.a12.controlGuiElements;

import java.awt.Color;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class ControlCheckBox extends JCheckBox {

	protected JComponent parent;
	
	public ControlCheckBox (String cbText, int x, int y, int width, int height, Color background, 
			ItemListener controller, ItemListener aaPCEventListener, String actionCommand, JComponent parent) {
		super(cbText);
		addItemListener(controller);
		addItemListener(aaPCEventListener);
		setBackground(background);
		setFocusPainted(false);
		setBounds(x, y, width, height);
		setActionCommand(actionCommand);
		this.parent = parent;
		parent.add(this);
	}
}
