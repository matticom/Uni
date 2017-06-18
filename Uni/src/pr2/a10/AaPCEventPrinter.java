package pr2.a10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintWriter;
import java.time.Instant;

public class AaPCEventPrinter implements ActionListener, PropertyChangeListener {

	private long start;
	
	public AaPCEventPrinter() {
		start = Instant.now().toEpochMilli();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		long timeStamp = Instant.now().toEpochMilli()-start;
		PrintWriter out = new PrintWriter(System.out, true);
		out.printf("SmileyModel wurde geändert um %10d[ms]\n", timeStamp);
		
	}
}
