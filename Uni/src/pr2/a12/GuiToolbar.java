package pr2.a12;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class GuiToolbar extends JToolBar {
	
	public GuiToolbar() {
		addButtons(this);
	}

	protected void addButtons(JToolBar toolBar) {
	    JButton button = new JButton("Hallo");
	    toolBar.add(button);

	    button = new JButton("Hallo2");
	    toolBar.add(button);
	}


}
