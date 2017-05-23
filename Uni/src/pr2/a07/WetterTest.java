package pr2.a07;

import schimkat.berlin.lernhilfe2017ss.event.Timer;

public class WetterTest {
	public static void main(String[] args) {
		
		WetterModel wm1 = new WetterModel("Wettermodel1");
		WetterModel wm2 = new WetterModel("Wettermodel2");
		
		WetterEmpfangsZentrale wez1 = new WetterEmpfangsZentrale(wm1);
		WetterEmpfangsZentrale wez2 = new WetterEmpfangsZentrale(wm2);
		
		WetterAnsicht wa1m1 = new WetterAnsicht(wm1);
		WetterAnsicht wa2m1 = new WetterAnsicht(wm1);
		WetterAnsicht wa1m2 = new WetterAnsicht(wm2);
		WetterAnsicht wa2m2 = new WetterAnsicht(wm2);
		
		wm1.addPropertyChangeListener(wa1m1);
		wm1.addPropertyChangeListener(wa2m1);
		wm2.addPropertyChangeListener(wa1m2);
		wm2.addPropertyChangeListener(wa2m2);
		
		
		Timer sonnigesHoch = new Timer(10000, 0);
		sonnigesHoch.setActionCommand(pr2.a07e.Wetterzustand.SONNIG.toString());
		sonnigesHoch.addActionListener(wez1);
		sonnigesHoch.addActionListener(wez2);
		
		Timer truebesWetter = new Timer(10000, 2000);
		truebesWetter.setActionCommand(pr2.a07e.Wetterzustand.BEDECKT.toString());
		truebesWetter.addActionListener(wez1);
		truebesWetter.addActionListener(wez2);
		
		Timer fastBlauerHimmel = new Timer(10000, 4000);
		fastBlauerHimmel.setActionCommand(pr2.a07e.Wetterzustand.WOLKIG.toString());
		fastBlauerHimmel.addActionListener(wez1);
		fastBlauerHimmel.addActionListener(wez2);
		
		Timer nass = new Timer(10000, 6000);
		nass.setActionCommand(pr2.a07e.Wetterzustand.REGEN.toString());
		nass.addActionListener(wez1);
		nass.addActionListener(wez2);
		
		Timer blitz = new Timer(10000, 8000);
		blitz.setActionCommand(pr2.a07e.Wetterzustand.GEWITTER.toString());
		blitz.addActionListener(wez1);
		blitz.addActionListener(wez2);
		
		sonnigesHoch.start();
		truebesWetter.start();
		fastBlauerHimmel.start();
		nass.start();
		blitz.start();
}
}
