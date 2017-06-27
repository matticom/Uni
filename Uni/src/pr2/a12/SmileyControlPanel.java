package pr2.a12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

public class SmileyControlPanel extends JPanel  implements PropertyChangeListener {
	
	protected JButton traurigButtuon;
	protected JButton zufriedenButton;
	protected JLabel gemuetsLabel;
	protected JCheckBox laechelnCheckBox;
	protected JLabel laechelnLabel;
	protected JSpinner augenwinkelSpinner;
	protected JLabel augenwinkelLabel;
	protected JTextField augenRadiusTF;
	protected JLabel augenRadiusLabel;
	protected JTextField kopfRadiusTF;
	protected JLabel kopfRadiusLabel;
		
	protected Controller controller;
	protected SmileyModel smileyModel;
	protected AaPCEventPrinter eventPrinter;
	
	protected final int X_START = 20;
	protected final int HEIGHT = 20;
	protected final int LABEL_WIDTH = 270;
	protected final int BUTTON_WIDTH = 100;
	protected final int TEXTFIELD_WIDTH = 50;
	protected final int CHECKBOX_WIDTH = 90;
	
	
	public SmileyControlPanel(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		this.controller = controller;
		this.smileyModel = smileyModel;
		this.eventPrinter = eventPrinter;
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
		kopfRadiusTF.setText(String.valueOf(smileyModel.getKopfRadius()));
		augenRadiusTF.setText(String.valueOf(smileyModel.getAugenKopfProzent()));
		augenwinkelSpinner.getModel().setValue(Double.valueOf(smileyModel.getAugapfelWinkel()));
		laechelnCheckBox.setSelected(smileyModel.isLaecheln());
	}
	
	protected void createGuiElements() {
		kopfRadiusLabel = createLabel("Kopfradius [Pixel]", X_START, 50, LABEL_WIDTH, HEIGHT, this);
		kopfRadiusTF = createTextField("", X_START, 80, TEXTFIELD_WIDTH, HEIGHT, controller, eventPrinter, StrConst.TF_HEAD_RADIUS, this);
		augenRadiusLabel = createLabel("Augenradius als Anteil von Kopfradius [%]", X_START, 120, LABEL_WIDTH, HEIGHT, this);
		augenRadiusTF = createTextField("", X_START, 150, TEXTFIELD_WIDTH, HEIGHT, controller, eventPrinter, StrConst.TF_EYE_RADIUS, this);
		augenwinkelLabel = createLabel("Winkel [°]", X_START, 190, LABEL_WIDTH, HEIGHT, this);
		augenwinkelSpinner = createSpinner("AUGENWINKEL_SPINNER", X_START, 220, TEXTFIELD_WIDTH, HEIGHT, controller, eventPrinter, StrConst.SPIN_EYE_ANGLE, 0.0, 0.0, 360.0, 5.0, this);
		laechelnCheckBox = createCheckBox("lächeln", X_START, 265, CHECKBOX_WIDTH, HEIGHT, Color.GREEN, controller, eventPrinter, StrConst.CB_SMILE, this);
		gemuetsLabel = createLabel("Gütszustand", X_START, 300, LABEL_WIDTH, HEIGHT, this);
		zufriedenButton = createButton("Zufrieden", X_START, 330, BUTTON_WIDTH, HEIGHT, controller, eventPrinter, StrConst.BTN_STFY, this);
		traurigButtuon = createButton("Traurig", X_START+100, 330, BUTTON_WIDTH, HEIGHT, controller, eventPrinter, StrConst.BTN_SAD, this);
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
