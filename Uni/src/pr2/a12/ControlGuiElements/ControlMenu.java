package pr2.a12.ControlGuiElements;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ControlMenu extends JMenu {
	
	protected JMenuBar parent;
	
	public ControlMenu(JMenuBar menuBar, String menuText, String menuName, int shortKey) {
		super(menuText);	
		setName(menuName);
		if (shortKey > 0)
			setMnemonic(shortKey);
		this.parent = menuBar;
		parent.add(this);
	}
}
