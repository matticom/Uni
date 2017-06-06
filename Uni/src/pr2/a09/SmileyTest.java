package pr2.a09;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class SmileyTest {
	public static void main(String[] args) {
		SmileyModel smileyModel = new SmileyModel();
		SmileyView smileyView = new SmileyView(smileyModel);
		SmileyView smileyView2 = new SmileyView(smileyModel);
		DirtyPainter dp = new DirtyPainter();
		DirtyPainter dp2 = new DirtyPainter();
		smileyModel.addPropertyChangeListener(smileyView);
		smileyModel.addPropertyChangeListener(smileyView2);
		int kopfRadius = 400;
		int augenKopfProzent = 20;
		double augapfelWinkel = 0;
		boolean laecheln = false;
		dp.add(smileyView);
		dp2.add(smileyView2);
		dp.showDrawing();
		dp2.showDrawing();
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
				System.out.println("augenKopfProzent = 13");
			}
			if (j == 30) {
				augenKopfProzent = 20;
				smileyModel.moveRelativ(50, 50);
				smileyModel.setAugenKopfProzent(augenKopfProzent);
				System.out.println("augenKopfProzent = 20");
			}
			System.out.println(i);
			
			dp.showDrawingAfterWaiting(200);
			dp2.showDrawingAfterWaiting(200);
		}
	}
}
