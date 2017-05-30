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
		while (true) {
			i++;
			smiley.setAugapfelWinkel(augapfelWinkel);
			augapfelWinkel += Math.PI/6;
			smiley.setLaecheln(laecheln);
			laecheln = !laecheln;
			smiley.setKopfRadius(kopfRadius);
			kopfRadius -= 2;
			if (i == 20) {
				augenKopfProzent = 10;
				smiley.setAugenKopfProzent(augenKopfProzent);
				System.out.println("augenKopfProzent = 10");
			}
			if (i == 30) {
				augenKopfProzent = 20;
				smiley.setAugenKopfProzent(augenKopfProzent);
				System.out.println("augenKopfProzent = 20");
			}
			System.out.println(i);
			dp.showDrawingAfterWaiting(200);
		}
	}
}
