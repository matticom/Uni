package pr2.a12;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.ResourceBundle;

import static pr2.a12.GuiElementsGenerator.*;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import pr2.a12.AaPCEventPrinter;
import pr2.a12.Controller;

public class GuiMenuBar extends JMenuBar implements PropertyChangeListener {
	
	protected JMenu file;
	protected JMenu smiley;
	protected JMenuItem save;
	protected JMenuItem load;
	protected JMenuItem exit;
	protected JCheckBox smile;
	protected JMenu head;
	protected JMenuItem incRadius;
	protected JMenuItem decRadius;
	protected JMenu eyes;
	protected JMenuItem rotLeft;
	protected JMenuItem rotRight;
	protected JMenuItem pleased; 
	protected JMenuItem sad;
	protected JMenuItem reset;
	protected JSeparator separator1;
	protected JSeparator separator2;
	
	protected ResourceBundle resBundle;
	
	protected Controller controller;
	protected SmileyModel smileyModel;
	protected AaPCEventPrinter eventPrinter;
	protected Locale locale;
	
	
	public GuiMenuBar(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyMenu", new Locale("en_EN"));
		this.controller = controller;
		this.smileyModel = smileyModel;
		this.eventPrinter = eventPrinter;
		createMenuElements();
	}
	
	protected void createMenuElements() {
		file = createMenu(this, resBundle.getString(StrConst.MB_FILE), StrConst.MB_FILE, 'f');
		smiley = createMenu(this, resBundle.getString(StrConst.MB_SMILEY), StrConst.MB_SMILEY, 's');
		save = createMenuItem(file, StrConst.MB_SAVE, controller, eventPrinter, resBundle.getString(StrConst.MB_SAVE), null, 'v');
		load = createMenuItem(file, StrConst.MB_LOAD, controller, eventPrinter, resBundle.getString(StrConst.MB_LOAD), null, 'l');
		exit = createMenuItem(file, StrConst.MB_EXIT, controller, eventPrinter, resBundle.getString(StrConst.MB_EXIT), null, 'x');
		smile = createMenuItemCheckBox(smiley, StrConst.MB_SMILE, controller, eventPrinter, resBundle.getString(StrConst.MB_SMILE), null, 'm');
		head = createSubMenu(smiley, StrConst.MB_HEAD, resBundle.getString(StrConst.MB_HEAD), null, 'h');
		incRadius = createMenuItem(head, StrConst.MB_H_INC, controller, eventPrinter, resBundle.getString(StrConst.MB_H_INC), null, 'i');
		decRadius = createMenuItem(head, StrConst.MB_H_DEC, controller, eventPrinter, resBundle.getString(StrConst.MB_H_DEC), null, 'd');
		eyes = createSubMenu(smiley, StrConst.MB_EYES, resBundle.getString(StrConst.MB_EYES), null, 'y');
		rotLeft = createMenuItem(eyes, StrConst.MB_E_ROT_LEFT, controller, eventPrinter, resBundle.getString(StrConst.MB_E_ROT_LEFT), null, 't');
		rotRight = createMenuItem(eyes, StrConst.MB_E_ROT_RIGHT, controller, eventPrinter, resBundle.getString(StrConst.MB_E_ROT_RIGHT), null, 'g');
		separator1 = new JSeparator();
		smiley.add(separator1);
		pleased = createMenuItem(smiley, StrConst.MB_PLEASED, controller, eventPrinter, resBundle.getString(StrConst.MB_PLEASED), null, 'p'); 
		sad = createMenuItem(smiley, StrConst.MB_SAD, controller, eventPrinter, resBundle.getString(StrConst.MB_SAD), null, 'a');
		separator2 = new JSeparator();
		smiley.add(separator2);
		reset = createMenuItem(smiley, StrConst.MB_RESET, controller, eventPrinter, resBundle.getString(StrConst.MB_RESET), null, 'r');
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (!e.getPropertyName().equals("MODEL_UPDATE")) {
			return;
		} else {
			smile.setSelected(smileyModel.isLaecheln());
		}
	}
}
