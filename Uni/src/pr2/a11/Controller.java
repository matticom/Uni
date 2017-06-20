package pr2.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Controller implements ActionListener, ItemListener {
	
	protected SmileyModel smileyModel;
	
	
	public Controller(SmileyModel smileyModel) {
		this.smileyModel = smileyModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case"ZUFRIEDEN_BUTTON":
			smileyModel.setPleased();
			break;
		case"TRAURIG_BUTTON":
			smileyModel.setSad();
			break;
		case"INPUT_AUGENWINKEL_JTEXTFIELD":
			smileyModel.setAugapfelWinkel(Double.parseDouble(((JTextField)e.getSource()).getText()));
			break;
		case"INPUT_AUGENRADIUS_JTEXTFIELD":
			smileyModel.setAugenKopfProzent(Integer.parseInt(((JTextField)e.getSource()).getText()));
			break;
		case"INPUT_KOPFRADIUS_JTEXTFIELD":
			smileyModel.setKopfRadius(Integer.parseInt(((JTextField)e.getSource()).getText()));
			break;
		} 
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (!(e.getSource() instanceof JCheckBox)) {
			return;
		} else if (!(((JCheckBox)e.getSource()).getActionCommand().equals("LAECHELN_CHECKBOX"))){
			return;
		} else if (e.getStateChange() == ItemEvent.SELECTED){
			smileyModel.setLaecheln(true);
		} else {
			smileyModel.setLaecheln(false);
		}
	}
}
