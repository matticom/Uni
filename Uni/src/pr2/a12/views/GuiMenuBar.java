package pr2.a12.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenuBar;
import javax.swing.JSeparator;

import pr2.a12.AaPCEventPrinter;
import pr2.a12.Controller;
import pr2.a12.SmileyModel;
import pr2.a12.StrConst;
import pr2.a12.controlGuiElements.ControlMenu;
import pr2.a12.controlGuiElements.ControlMenuCheckBox;
import pr2.a12.controlGuiElements.ControlMenuItem;
import pr2.a12.controlGuiElements.ControlSubMenu;

public class GuiMenuBar extends JMenuBar implements PropertyChangeListener {
	
	protected ControlMenu file;
	protected ControlMenu smiley;
	protected ControlMenu language;
	protected ControlMenuItem save;
	protected ControlMenuItem load;
	protected ControlMenuItem exit;
	protected ControlMenuCheckBox smile;
	protected ControlSubMenu head;
	protected ControlMenuItem incRadius;
	protected ControlMenuItem decRadius;
	protected ControlSubMenu eyes;
	protected ControlMenuItem rotLeft;
	protected ControlMenuItem rotRight;
	protected ControlMenuItem pleased; 
	protected ControlMenuItem sad;
	protected ControlMenuItem reset;
	protected JSeparator separator1;
	protected JSeparator separator2;
	protected ControlMenuItem english;
	protected ControlMenuItem german;
	protected ControlMenuItem spanish;
	
	protected ResourceBundle resBundle;
	
	protected Controller controller;
	protected SmileyModel smileyModel;
	protected AaPCEventPrinter eventPrinter;
	protected Locale locale;
	
	
	public GuiMenuBar(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyMenu", locale);
		this.controller = controller;
		this.smileyModel = smileyModel;
		this.eventPrinter = eventPrinter;
		createMenuElements();
	}
	
	protected void createMenuElements() {
		file = new ControlMenu(this, resBundle.getString(StrConst.MB_FILE), StrConst.MB_FILE, 'f');
		smiley = new ControlMenu(this, resBundle.getString(StrConst.MB_SMILEY), StrConst.MB_SMILEY, 's');
		language = new ControlMenu(this, resBundle.getString(StrConst.MB_LANG), StrConst.MB_LANG, 'u');
		save = new ControlMenuItem(file, StrConst.MB_SAVE, controller, eventPrinter, resBundle.getString(StrConst.MB_SAVE), null, 'v');
		load = new ControlMenuItem(file, StrConst.MB_LOAD, controller, eventPrinter, resBundle.getString(StrConst.MB_LOAD), null, 'l');
		exit = new ControlMenuItem(file, StrConst.MB_EXIT, controller, eventPrinter, resBundle.getString(StrConst.MB_EXIT), null, 'x');
		smile = new ControlMenuCheckBox(smiley, StrConst.MB_SMILE, controller, eventPrinter, resBundle.getString(StrConst.MB_SMILE), null, 'm');
		head = new ControlSubMenu(smiley, StrConst.MB_HEAD, resBundle.getString(StrConst.MB_HEAD), null, 'h');
		incRadius = new ControlMenuItem(head, StrConst.MB_H_INC, controller, eventPrinter, resBundle.getString(StrConst.MB_H_INC), null, 'i');
		decRadius = new ControlMenuItem(head, StrConst.MB_H_DEC, controller, eventPrinter, resBundle.getString(StrConst.MB_H_DEC), null, 'd');
		eyes = new ControlSubMenu(smiley, StrConst.MB_EYES, resBundle.getString(StrConst.MB_EYES), null, 'y');
		rotLeft = new ControlMenuItem(eyes, StrConst.MB_E_ROT_LEFT, controller, eventPrinter, resBundle.getString(StrConst.MB_E_ROT_LEFT), null, 't');
		rotRight = new ControlMenuItem(eyes, StrConst.MB_E_ROT_RIGHT, controller, eventPrinter, resBundle.getString(StrConst.MB_E_ROT_RIGHT), null, 'g');
		separator1 = new JSeparator();
		smiley.add(separator1);
		pleased = new ControlMenuItem(smiley, StrConst.MB_PLEASED, controller, eventPrinter, resBundle.getString(StrConst.MB_PLEASED), null, 'p'); 
		sad = new ControlMenuItem(smiley, StrConst.MB_SAD, controller, eventPrinter, resBundle.getString(StrConst.MB_SAD), null, 'a');
		separator2 = new JSeparator();
		smiley.add(separator2);
		reset = new ControlMenuItem(smiley, StrConst.MB_RESET, controller, eventPrinter, resBundle.getString(StrConst.MB_RESET), null, 'r');
		english = new ControlMenuItem(language, StrConst.MB_EN, controller, eventPrinter, resBundle.getString(StrConst.MB_EN), null, 'h');
		german = new ControlMenuItem(language, StrConst.MB_DE, controller, eventPrinter, resBundle.getString(StrConst.MB_DE), null, 'n');
		spanish = new ControlMenuItem(language, StrConst.MB_ES, controller, eventPrinter, resBundle.getString(StrConst.MB_ES), null, 'a');
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (!e.getPropertyName().equals("MODEL_UPDATE")) {
			return;
		} else {
			updateMenuElements();
		}
	}
	
	protected void updateMenuElements() {
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyMenu", locale);
		smile.setSelected(smileyModel.isLaecheln());
		
		file.setText(resBundle.getString(StrConst.MB_FILE));
		smiley.setText(resBundle.getString(StrConst.MB_SMILEY));
		language.setText(resBundle.getString(StrConst.MB_LANG));
		save.setText(resBundle.getString(StrConst.MB_SAVE));
		load.setText(resBundle.getString(StrConst.MB_LOAD));
		exit.setText(resBundle.getString(StrConst.MB_EXIT));
		smile.setText(resBundle.getString(StrConst.MB_SMILE));
		head.setText(resBundle.getString(StrConst.MB_HEAD));
		incRadius.setText(resBundle.getString(StrConst.MB_H_INC));
		decRadius.setText(resBundle.getString(StrConst.MB_H_DEC));
		eyes.setText(resBundle.getString(StrConst.MB_EYES));
		rotLeft.setText(resBundle.getString(StrConst.MB_E_ROT_LEFT));
		rotRight.setText(resBundle.getString(StrConst.MB_E_ROT_RIGHT));
		pleased.setText(resBundle.getString(StrConst.MB_PLEASED));
		sad.setText(resBundle.getString(StrConst.MB_SAD));
		reset.setText(resBundle.getString(StrConst.MB_RESET));
		english.setText(resBundle.getString(StrConst.MB_EN));
		german.setText(resBundle.getString(StrConst.MB_DE));
		spanish.setText(resBundle.getString(StrConst.MB_ES));
	}

	public void setSmileyModel(SmileyModel smileyModel) {
		this.smileyModel = smileyModel;
	}
}
