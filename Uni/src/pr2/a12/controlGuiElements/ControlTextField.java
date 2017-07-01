package pr2.a12.controlGuiElements;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class ControlTextField extends JTextField {

	protected JComponent parent;
	
	public ControlTextField(String tfText, int x, int y, int width, int height,
			ActionListener controller, ActionListener aaPCEventListener, String actionCommand, JComponent parent) {
		super(tfText);
		addActionListener(controller);
		addActionListener(aaPCEventListener);
		setActionCommand(actionCommand);
		setBounds(x, y, width, height);
		this.parent = parent;
		parent.add(this);
	}
}
