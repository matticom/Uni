package pr2.a11;

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
import javax.swing.JTextField;

public class SmileyControlPanel extends JPanel  implements PropertyChangeListener {
	
	protected JButton traurigButtuon;
	protected JButton zufriedenButton;
	protected JLabel gemuetsLabel;
	protected JCheckBox laechelnCheckBox;
	protected JLabel laechelnLabel;
	protected JTextField augenwinkelTF;
	protected JLabel augenwinkelLabel;
	protected JTextField augenRadiusTF;
	protected JLabel augenRadiusLabel;
	protected JTextField kopfRadiusTF;
	protected JLabel kopfRadiusLabel;
		
	protected Controller controller;
	protected SmileyModel smileyModel;
	protected AaPCEventPrinter eventPrinter;
	
	
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
		augenwinkelTF.setText(String.valueOf(Math.round(10.0 * smileyModel.getAugapfelWinkel()) / 10.0));
		laechelnCheckBox.setSelected(smileyModel.isLaecheln());
	}
	
	protected void createGuiElements() {
		kopfRadiusLabel = createLabel("Kopfradius [Pixel]", 20, 50, 200, 20, this);
		kopfRadiusTF = createTextField("", 20, 80, 50, 20, controller, eventPrinter, "INPUT_KOPFRADIUS_JTEXTFIELD", this);
		augenRadiusLabel = createLabel("Augenradius als Anteil von Kopfradius [%]", 20, 120, 270, 20, this);
		augenRadiusTF = createTextField("", 20, 150, 50, 20, controller, eventPrinter, "INPUT_AUGENRADIUS_JTEXTFIELD", this);
		augenwinkelLabel = createLabel("Winkel [°]", 20, 190, 200, 20, this);
		augenwinkelTF = createTextField("Winkel in Grad", 20, 220, 50, 20, controller, eventPrinter, "INPUT_AUGENWINKEL_JTEXTFIELD", this);
		laechelnCheckBox = createCheckBox("lächeln", 20, 265, 70, 20, Color.GREEN, controller, eventPrinter, "LAECHELN_CHECKBOX", this);
		gemuetsLabel = createLabel("Gütszustand", 20, 300, 200, 20, this);
		zufriedenButton = createButton("Zufrieden", 20, 330, 100, 20, controller, eventPrinter, "ZUFRIEDEN_BUTTON", this);
		traurigButtuon = createButton("Traurig", 120, 330, 100, 20, controller, eventPrinter, "TRAURIG_BUTTON", this);
	}

	public void setActionListener(ActionListener l) {
		traurigButtuon.addActionListener(l);
		zufriedenButton.addActionListener(l);
		augenwinkelTF.addActionListener(l);
		augenRadiusTF.addActionListener(l);
		kopfRadiusTF.addActionListener(l);
	}
	
	public void removeActionListener(ActionListener l) {
		traurigButtuon.removeActionListener(l);
		zufriedenButton.removeActionListener(l);
		augenwinkelTF.removeActionListener(l);
		augenRadiusTF.removeActionListener(l);
		kopfRadiusTF.removeActionListener(l);
	}
	
	public void setItemListener(ItemListener l) {
		laechelnCheckBox.addItemListener(l);
	}
	
	public void removeItemListener(ItemListener l) {
		laechelnCheckBox.removeItemListener(l);
	}
}
