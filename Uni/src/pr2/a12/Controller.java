package pr2.a12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

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
		case StrConst.MB_PLEASED:
		case StrConst.BTN_STFY:
			smileyModel.setPleased();
			break;
		case StrConst.MB_SAD:
		case StrConst.BTN_SAD:
			smileyModel.setSad();
			break;
		case StrConst.TF_EYE_RADIUS:
			smileyModel.setAugenKopfProzent(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		case StrConst.TF_HEAD_RADIUS:
			smileyModel.setKopfRadius(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		case StrConst.MB_E_ROT_LEFT:
			smileyModel.rotateEyesLeft();
			break;
		case StrConst.MB_E_ROT_RIGHT:
			smileyModel.rotateEyesRight();
			break;
		case StrConst.MB_H_DEC:
			smileyModel.decreaseHead();
			break;
		case StrConst.MB_H_INC:
			smileyModel.increaseHead();
			break;
		case StrConst.MB_RESET:
			smileyModel.setDefaultSmiley();
			break;
		case StrConst.MB_EN:
			smileyModel.setLocale(Locale.US);
			break;
		case StrConst.MB_DE:
			smileyModel.setLocale(Locale.GERMANY);
			break;
		case StrConst.MB_ES:
			smileyModel.setLocale(new Locale("es_ES"));
			break;
		case StrConst.BTN_DOWN:
			smileyModel.moveRelativ(0, 5);
			break;
		case StrConst.BTN_LEFT:
			smileyModel.moveRelativ(-5, 0);
			break;
		case StrConst.BTN_RIGHT:
			smileyModel.moveRelativ(5, 0);
			break;
		case StrConst.BTN_UP:
			smileyModel.moveRelativ(0, -5);
			break;
		case StrConst.MB_EXIT:
			System.exit(0);
			break;
		case StrConst.MB_SAVE:
			smileyModel.saveProps();
			break;
		case StrConst.MB_LOAD:
			smileyModel.loadProps();
			break;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (!(e.getSource() instanceof JCheckBox)) {
			return;
		} else if (!(((JCheckBox) e.getSource()).getActionCommand().equals(StrConst.CB_SMILE)) 
				&& !(((JCheckBox) e.getSource()).getActionCommand().equals(StrConst.MB_SMILE))) {
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
