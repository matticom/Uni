package pr2.a12.ControlGuiElements;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class ControlButton extends JButton {

	protected JComponent parent;
	
	public ControlButton(String buttonText, int x, int y, int width, int height,
			ActionListener controller, ActionListener aaPCEventListener, String actionCommand, 
			ImageIcon icon, JComponent parent) {
		super(buttonText);
		if (width != 0 && height != 0) {
			setBounds(x, y, width, height);
		}
		addActionListener(controller);
		addActionListener(aaPCEventListener);
		setActionCommand(actionCommand);
		setIcon(icon);
		this.parent = parent;
		parent.add(this);
	}
}
