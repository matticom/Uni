package pr2.a12;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import pr2.a12.ControlGuiElements.ControlButton;

public class GuiToolbar extends JToolBar {
	
	ControlButton up;
	ControlButton down;
	ControlButton right;
	ControlButton left;
	
	protected Controller controller;
	protected AaPCEventPrinter eventPrinter;
	
	public GuiToolbar(Controller controller, AaPCEventPrinter eventPrinter) {
		this.controller = controller;
		this.eventPrinter = eventPrinter;
		addButtons();
	}

	protected void addButtons() {
		left = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_LEFT, new ImageIcon(this.getClass().getResource("/images/arrow-left-3.png")), this);
		up = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_UP, new ImageIcon(this.getClass().getResource("/images/arrow-up-3.png")), this);
		down = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_DOWN, new ImageIcon(this.getClass().getResource("/images/arrow-down-3.png")), this);
		right = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_RIGHT, new ImageIcon(this.getClass().getResource("/images/arrow-right-3.png")), this);
	}


}
