package pr2.a12;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import pr2.a12.ControlGuiElements.ControlButton;

public class GuiToolbar extends JToolBar implements PropertyChangeListener {
	
	protected ControlButton up;
	protected ControlButton down;
	protected ControlButton right;
	protected ControlButton left;
	
	protected ResourceBundle resBundle;
	protected Locale locale;
	
	protected Controller controller;
	protected AaPCEventPrinter eventPrinter;
	protected SmileyModel smileyModel;
	
	public GuiToolbar(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyToolBar", locale);
		this.smileyModel = smileyModel;
		this.controller = controller;
		this.eventPrinter = eventPrinter;
		addButtons();
	}

	protected void addButtons() {
		left = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_LEFT, new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_LEFT))), this);
		up = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_UP, new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_UP))), this);
		down = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_DOWN, new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_DOWN))), this);
		right = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_RIGHT, new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_RIGHT))), this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (!e.getPropertyName().equals("MODEL_UPDATE")) {
			return;
		} else {
			updateToolbarElements();
		}
	}
	
	protected void updateToolbarElements() {
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyToolBar", locale);
		
		left.setIcon(new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_LEFT))));
		up.setIcon(new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_UP))));
		down.setIcon(new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_DOWN))));
		right.setIcon(new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_RIGHT))));
	}
}
