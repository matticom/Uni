package pr2.a06;

import pr2.a06.util.Wetterzustand;
import schimkat.berlin.lernhilfe2017ss.event.Timer;

public class WetterPrinterTest {

	public static void main(String[] args) {
		
			WetterPrinter wetterMacher = new WetterPrinter();
			WetterMelder wetterMelder = new WetterMelder();
			
			Timer sonnigesHoch = new Timer(10000, 0);
			sonnigesHoch.setActionCommand(Wetterzustand.SONNIG);
			sonnigesHoch.addActionListener(wetterMacher);
			sonnigesHoch.addActionListener(wetterMelder);
			
			Timer truebesWetter = new Timer(10000, 2000);
			truebesWetter.setActionCommand(Wetterzustand.BEDECKT);
			truebesWetter.addActionListener(wetterMacher);
			truebesWetter.addActionListener(wetterMelder);
			
			Timer fastBlauerHimmel = new Timer(10000, 4000);
			fastBlauerHimmel.setActionCommand(Wetterzustand.WOLKIG);
			fastBlauerHimmel.addActionListener(wetterMacher);
			fastBlauerHimmel.addActionListener(wetterMelder);
			
			Timer nass = new Timer(10000, 6000);
			nass.setActionCommand(Wetterzustand.REGEN);
			nass.addActionListener(wetterMacher);
			nass.addActionListener(wetterMelder);
			
			Timer blitz = new Timer(10000, 8000);
			blitz.setActionCommand(Wetterzustand.GEWITTER);
			blitz.addActionListener(wetterMacher);
			blitz.addActionListener(wetterMelder);
			
			sonnigesHoch.start();
			truebesWetter.start();
			fastBlauerHimmel.start();
			nass.start();
			blitz.start();
		while (true) {}
	}
}
