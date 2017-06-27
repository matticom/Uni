package pr2.a12.ControlGuiElements;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ControlMenuItem extends JMenuItem {
	
protected JMenu parent;
	
	public ControlMenuItem(JMenu menu, String actionCmd, ActionListener actionListener, 
			ActionListener actionListener2, String miText, ImageIcon icon, int shortKey) {
		super(miText);	
		setActionCommand(actionCmd);
		setIcon(icon);
		addActionListener(actionListener);
		addActionListener(actionListener2);
		if (shortKey > 0) {
			setMnemonic(shortKey);
		}
		this.parent = menu;
		parent.add(this);
	}
}
