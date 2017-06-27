package pr2.a12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintWriter;
import java.time.Instant;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AaPCEventPrinter implements ActionListener, PropertyChangeListener, ItemListener, ChangeListener {

	private long start;

	public AaPCEventPrinter() {
		start = Instant.now().toEpochMilli();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long timeStamp = Instant.now().toEpochMilli() - start;
		PrintWriter out = new PrintWriter(System.out, true);
		out.printf("Nutzer ändert Smileyparameter um %10d[ms]: %12s\n", timeStamp, e.getActionCommand());
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		long timeStamp = Instant.now().toEpochMilli() - start;
		PrintWriter out = new PrintWriter(System.out, true);
		out.printf("SmileyModel wurde geändert um %13d[ms]\n", timeStamp);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof JCheckBox) {
			long timeStamp = Instant.now().toEpochMilli() - start;
			PrintWriter out = new PrintWriter(System.out, true);
			out.printf("Nutzer ändert Smileyparameter um %10d[ms]: %12s\n", timeStamp, ((JCheckBox) e.getSource()).getActionCommand());
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JSpinner) {
			long timeStamp = Instant.now().toEpochMilli() - start;
			PrintWriter out = new PrintWriter(System.out, true);
			out.printf("Nutzer ändert Smileyparameter um %10d[ms]: %12s\n", timeStamp, ((JSpinner) e.getSource()).getName());
		}
	}
}
