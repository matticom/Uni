package pr2.a07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WetterEmpfangsZentrale implements ActionListener {
	WetterModel wetterModel;

	public WetterEmpfangsZentrale(WetterModel wetterModel) {
		this.wetterModel = wetterModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pr2.a07e.Wetterzustand wetterzustand = pr2.a07e.Wetterzustand.valueOf(e.getActionCommand());
		wetterModel.setWetter(wetterzustand);
	}

}
