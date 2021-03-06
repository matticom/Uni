package pr2.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

public class Controller implements ActionListener, ItemListener, ChangeListener {

	protected SmileyModel smileyModel;

	public Controller(SmileyModel smileyModel) {
		this.smileyModel = smileyModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case StrConst.BTN_STFY:
			smileyModel.setPleased();
			break;
		case StrConst.BTN_SAD:
			smileyModel.setSad();
			break;
		case StrConst.TF_EYE_RADIUS:
			smileyModel.setAugenKopfProzent(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		case StrConst.TF_HEAD_RADIUS:
			smileyModel.setKopfRadius(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (!(e.getSource() instanceof JCheckBox)) {
			return;
		} else if (!(((JCheckBox) e.getSource()).getActionCommand().equals(StrConst.CB_SMILE))) {
			return;
		} else if (e.getStateChange() == ItemEvent.SELECTED) {
			smileyModel.setLaecheln(true);
		} else {
			smileyModel.setLaecheln(false);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (!(e.getSource() instanceof JSpinner)) {
			return;
		} else if (!((JSpinner) e.getSource()).getName().equals(StrConst.SPIN_EYE_ANGLE)) {
			return;
		} else {
			smileyModel.setAugapfelWinkel((Double) (((JSpinner) e.getSource()).getModel().getValue()));
		}
	}
}
