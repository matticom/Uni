package pr2.a12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.ResourceBundle;

import static pr2.a11.GuiElementsGenerator.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

import pr2.a12.ControlGuiElements.ControlButton;
import pr2.a12.ControlGuiElements.ControlCheckBox;
import pr2.a12.ControlGuiElements.ControlLabel;
import pr2.a12.ControlGuiElements.ControlSpinner;
import pr2.a12.ControlGuiElements.ControlTextField;

public class SmileyControlPanel extends JPanel  implements PropertyChangeListener {
	
	protected ControlButton traurigButtuon;
	protected ControlButton zufriedenButton;
	protected ControlLabel gemuetsLabel;
	protected ControlCheckBox laechelnCheckBox;
	protected ControlLabel laechelnLabel;
	protected ControlSpinner augenwinkelSpinner;
	protected ControlLabel augenwinkelLabel;
	protected ControlTextField augenRadiusTF;
	protected ControlLabel augenRadiusLabel;
	protected ControlTextField kopfRadiusTF;
	protected ControlLabel kopfRadiusLabel;
		
	protected Controller controller;
	protected SmileyModel smileyModel;
	protected AaPCEventPrinter eventPrinter;
	
	protected final int X_START = 20;
	protected final int HEIGHT = 20;
	protected final int LABEL_WIDTH = 270;
	protected final int BUTTON_WIDTH = 100;
	protected final int TEXTFIELD_WIDTH = 60;
	protected final int CHECKBOX_WIDTH = 90;
	
	protected Locale locale;
	protected ResourceBundle resBundle;
	
	public SmileyControlPanel(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		this.controller = controller;
		this.smileyModel = smileyModel;
		this.eventPrinter = eventPrinter;
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyControlPanel", locale);
		configPanel();
		createGuiElements();
		updateInputElements();
	}
		
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (!e.getPropertyName().equals("MODEL_UPDATE")) {
			return;
		} else {
			updateInputElements();
		}
		
	}
	
	protected void configPanel() {
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(280, 500));
		setLayout(null);
	}
	
	protected void updateInputElements() {
		locale = smileyModel.getLocale();
		resBundle = ResourceBundle.getBundle("pr2.resourcesI18N.smileyControlPanel", locale);
		
		kopfRadiusTF.setText(String.valueOf(smileyModel.getKopfRadius()));
		augenRadiusTF.setText(String.valueOf(smileyModel.getAugenKopfProzent()));
		augenwinkelSpinner.getModel().setValue(Double.valueOf(smileyModel.getAugapfelWinkel()));
		laechelnCheckBox.setSelected(smileyModel.isLaecheln());
		
		kopfRadiusLabel.setText(resBundle.getString(StrConst.LBL_HEAD_RADIUS));
		augenRadiusLabel.setText(resBundle.getString(StrConst.LBL_EYE_RADIUS));
		augenwinkelLabel.setText(resBundle.getString(StrConst.LBL_EYE_ANGLE));
		laechelnCheckBox.setText(resBundle.getString(StrConst.CB_SMILE));
		gemuetsLabel.setText(resBundle.getString(StrConst.LBL_MOOD));
		zufriedenButton.setText(resBundle.getString(StrConst.BTN_STFY));
		traurigButtuon.setText(resBundle.getString(StrConst.BTN_SAD));
	}
	
	protected void createGuiElements() {
		kopfRadiusLabel = new ControlLabel(resBundle.getString(StrConst.LBL_HEAD_RADIUS), X_START, 50, LABEL_WIDTH, HEIGHT, this);
		kopfRadiusTF = new ControlTextField("", X_START, 80, TEXTFIELD_WIDTH, HEIGHT, controller, eventPrinter, StrConst.TF_HEAD_RADIUS, this);
		augenRadiusLabel = new ControlLabel(resBundle.getString(StrConst.LBL_EYE_RADIUS), X_START, 120, LABEL_WIDTH, HEIGHT, this);
		augenRadiusTF = new ControlTextField("", X_START, 150, TEXTFIELD_WIDTH, HEIGHT, controller, eventPrinter, StrConst.TF_EYE_RADIUS, this);
		augenwinkelLabel = new ControlLabel(resBundle.getString(StrConst.LBL_EYE_ANGLE), X_START, 190, LABEL_WIDTH, HEIGHT, this);
		augenwinkelSpinner = new ControlSpinner(X_START, 220, TEXTFIELD_WIDTH, HEIGHT, controller, eventPrinter, StrConst.SPIN_EYE_ANGLE, 0.0, -3600.0, 3600.0, 5.0, this);
		laechelnCheckBox = new ControlCheckBox(resBundle.getString(StrConst.CB_SMILE), X_START, 265, CHECKBOX_WIDTH, HEIGHT, Color.GREEN, controller, eventPrinter, StrConst.CB_SMILE, this);
		gemuetsLabel = new ControlLabel(resBundle.getString(StrConst.LBL_MOOD), X_START, 300, LABEL_WIDTH, HEIGHT, this);
		zufriedenButton = new ControlButton(resBundle.getString(StrConst.BTN_STFY), X_START, 330, BUTTON_WIDTH, HEIGHT, controller, eventPrinter, StrConst.BTN_STFY, null, this);
		traurigButtuon = new ControlButton(resBundle.getString(StrConst.BTN_SAD), X_START+100, 330, BUTTON_WIDTH, HEIGHT, controller, eventPrinter, StrConst.BTN_SAD, null, this);
	}

	public void setActionListener(ActionListener l) {
		traurigButtuon.addActionListener(l);
		zufriedenButton.addActionListener(l);
		augenRadiusTF.addActionListener(l);
		kopfRadiusTF.addActionListener(l);
	}
	
	public void removeActionListener(ActionListener l) {
		traurigButtuon.removeActionListener(l);
		zufriedenButton.removeActionListener(l);
		augenRadiusTF.removeActionListener(l);
		kopfRadiusTF.removeActionListener(l);
	}
	
	public void setItemListener(ItemListener l) {
		laechelnCheckBox.addItemListener(l);
	}
	
	public void removeItemListener(ItemListener l) {
		laechelnCheckBox.removeItemListener(l);
	}
	
	public void setChangeListener(ChangeListener l) {
		augenwinkelSpinner.getModel().addChangeListener(l);
	}
	
	public void removeChangeListener(ChangeListener l) {
		augenwinkelSpinner.getModel().removeChangeListener(l);
	}
}
