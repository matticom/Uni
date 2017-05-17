package pr2.a06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.time.Instant;

public class WetterPrinter implements ActionListener {

	private long start;
	
	public WetterPrinter() {
		Instant startTime = Instant.now();
		start = startTime.toEpochMilli();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.printf("Wetternachricht um %10d[ms]: %12s\n", e.getWhen()-start, e.getActionCommand());
	}

}
