package pr2.a12.controlGuiElements;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class ControlSubMenu extends JMenu {
	
	protected JMenu parent;

	public ControlSubMenu(JMenu menu, String miName, String miText,	ImageIcon icon, int shortKey) {
		super(miText);
		setIcon(icon);
		setName(miName);
		if (shortKey > 0) {
			setMnemonic(shortKey);
		}
		this.parent = menu;
		parent.add(this);
	}
}
