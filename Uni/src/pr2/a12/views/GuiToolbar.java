package pr2.a12.views;

import static pr2.a12.utils.ColorUtil.convertFxColorToAwtColor;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import pr2.a12.AaPCEventPrinter;
import pr2.a12.Controller;
import pr2.a12.SmileyModel;
import pr2.a12.StrConst;
import pr2.a12.controlGuiElements.ControlButton;

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

	protected final Color BG_COLOR;

	public GuiToolbar(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyToolBar", locale);
		BG_COLOR = convertFxColorToAwtColor(javafx.scene.paint.Color.DARKTURQUOISE);
		this.smileyModel = smileyModel;
		this.controller = controller;
		this.eventPrinter = eventPrinter;
		setBackground(BG_COLOR);
		addButtons();
	}

	protected void addButtons() {
		left = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_LEFT,
				new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_LEFT))), BG_COLOR, this);
		up = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_UP,
				new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_UP))), BG_COLOR, this);
		down = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_DOWN,
				new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_DOWN))), BG_COLOR, this);
		right = new ControlButton("", 0, 0, 0, 0, controller, eventPrinter, StrConst.BTN_RIGHT,
				new ImageIcon(this.getClass().getResource(resBundle.getString(StrConst.BTN_RIGHT))), BG_COLOR, this);
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

	public void setSmileyModel(SmileyModel smileyModel) {
		this.smileyModel = smileyModel;
	}
	
	
}
