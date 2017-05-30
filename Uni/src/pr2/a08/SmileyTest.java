package pr2.a08;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class SmileyTest {
	public static void main(String[] args) {
		Smiley smiley = new Smiley();
		DirtyPainter dp = new DirtyPainter();
		int kopfRadius = 400;
		int augenKopfProzent = 20;
		double augapfelWinkel = 0;
		boolean laecheln = false;
		dp.add(smiley);
		dp.showDrawing();
		int i = 0;
		int j = 0;
		while (true) {
			j = i % 100;
			i++;
			if (j == 0) {
				kopfRadius = 400;
				smiley.setPosition(0, 0);
			}
			smiley.setAugapfelWinkel(augapfelWinkel);
			augapfelWinkel += Math.PI/6;
			smiley.setLaecheln(laecheln);
			laecheln = !laecheln;
			smiley.setKopfRadius(kopfRadius);
			kopfRadius -= 3;
			if (j == 20) {
				smiley.setPosition(100, 100);
				augenKopfProzent = 13;
				smiley.setAugenKopfProzent(augenKopfProzent);
				System.out.println("augenKopfProzent = 13");
			}
			if (j == 30) {
				augenKopfProzent = 20;
				smiley.moveRelativ(50, 50);
				smiley.setAugenKopfProzent(augenKopfProzent);
				System.out.println("augenKopfProzent = 20");
			}
			System.out.println(i);
			
			dp.showDrawingAfterWaiting(200);
		}
	}
}
