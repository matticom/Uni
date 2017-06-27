package pr2.a12.ControlGuiElements;

import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JMenu;

public class ControlMenuCheckBox extends JCheckBox {
	
	protected JMenu parent;
	
	public ControlMenuCheckBox (JMenu menu, String actionCmd, ItemListener controller, 
			ItemListener aaPCEventListener, String miText, ImageIcon icon, int shortKey) {
		super(miText);
		addItemListener(controller);
		addItemListener(aaPCEventListener);
	
		setActionCommand(actionCmd);
		setIcon(icon);
		if (shortKey > 0) {
			setMnemonic(shortKey);
		}
		this.parent = menu;
		parent.add(this);
	}
}
