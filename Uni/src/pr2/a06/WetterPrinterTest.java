package pr2.a06;

import pr2.a06.util.Wetterzustand;
import schimkat.berlin.lernhilfe2017ss.event.Timer;

public class WetterPrinterTest {

	public static void main(String[] args) {
			WetterPrinter wetterMacher = new WetterPrinter();
			WetterMelder wetterMelder = new WetterMelder();
			WetterMelder wetterMelder2 = new WetterMelder();
			
			Timer sonnigesHoch = new Timer(10000, 0);
			sonnigesHoch.setActionCommand(Wetterzustand.SONNIG);
			sonnigesHoch.addActionListener(wetterMacher);
			sonnigesHoch.addActionListener(wetterMelder);
			sonnigesHoch.addActionListener(wetterMelder2);
			Timer truebesWetter = new Timer(10000, 2000);
			truebesWetter.setActionCommand(Wetterzustand.BEDECKT);
			truebesWetter.addActionListener(wetterMacher);
			truebesWetter.addActionListener(wetterMelder);
			truebesWetter.addActionListener(wetterMelder2);
			Timer fastBlauerHimmel = new Timer(10000, 4000);
			fastBlauerHimmel.setActionCommand(Wetterzustand.WOLKIG);
			fastBlauerHimmel.addActionListener(wetterMacher);
			fastBlauerHimmel.addActionListener(wetterMelder);
			fastBlauerHimmel.addActionListener(wetterMelder2);
			Timer nass = new Timer(10000, 6000);
			nass.setActionCommand(Wetterzustand.REGEN);
			nass.addActionListener(wetterMacher);
			nass.addActionListener(wetterMelder);
			nass.addActionListener(wetterMelder2);
			Timer blitz = new Timer(10000, 8000);
			blitz.setActionCommand(Wetterzustand.GEWITTER);
			blitz.addActionListener(wetterMacher);
			blitz.addActionListener(wetterMelder);
			blitz.addActionListener(wetterMelder2);
			
			sonnigesHoch.start();
			truebesWetter.start();
			fastBlauerHimmel.start();
			nass.start();
			blitz.start();
	}
}
