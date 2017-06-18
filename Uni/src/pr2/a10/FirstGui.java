package pr2.a10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class FirstGui {
	public static void main(String[] args) throws InterruptedException {
		SmileyModel smileyModel = new SmileyModel();
		FirstSmileyPanel smileyView = new FirstSmileyPanel(smileyModel);
		FirstSmileyPanel smileyView2 = new FirstSmileyPanel(smileyModel);
		AaPCEventPrinter printer = new AaPCEventPrinter();
		smileyModel.addPropertyChangeListener(printer);
		JFrame jFrame1 = new JFrame("Smiley1");
		jFrame1.setSize(new Dimension(1000, 1000));
		JFrame jFrame2 = new JFrame("Smiley2");
		jFrame2.setSize(new Dimension(1000, 1000));
		smileyModel.addPropertyChangeListener(smileyView);
		smileyModel.addPropertyChangeListener(smileyView2);
		int kopfRadius = 400;
		int augenKopfProzent = 20;
		double augapfelWinkel = 0;
		boolean laecheln = false;
		Container con1 = jFrame1.getContentPane();
		Container con2 = jFrame2.getContentPane();
		con1.add(smileyView, BorderLayout.CENTER);
		con2.add(smileyView2, BorderLayout.CENTER);
		jFrame1.setVisible(true);
		jFrame2.setVisible(true);
		int i = 0;
		int j = 0;
		while (true) {
			j = i % 100;
			i++;
			if (j == 0) {
				kopfRadius = 400;
				smileyModel.setPosition(0, 0);
			}
			smileyModel.setAugapfelWinkel(augapfelWinkel);
			augapfelWinkel += Math.PI/6;
			smileyModel.setLaecheln(laecheln);
			laecheln = !laecheln;
			smileyModel.setKopfRadius(kopfRadius);
			kopfRadius -= 3;
			if (j == 20) {
				smileyModel.setPosition(100, 100);
				augenKopfProzent = 13;
				smileyModel.setAugenKopfProzent(augenKopfProzent);
			}
			if (j == 30) {
				augenKopfProzent = 20;
				smileyModel.moveRelativ(50, 50);
				smileyModel.setAugenKopfProzent(augenKopfProzent);
			}
			Thread.sleep(500);
		}
		
	}
}
