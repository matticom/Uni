package pr1.a09;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class PflanzenTest {

	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		Blume blume = new Blume(40, 3);
		Baum baum = new Baum(110, 5);
		painter.add(baum);
		painter.add(blume);
		double time = 5;
		int counter = 0;
		int vorwaerts = 0;
		int rueckwarts = 0;

		while (true) {
			counter++;

			int intDiv = counter / 25;

			if (intDiv % 2 == 0) {
				time = vorwaerts++;
				rueckwarts = 24;
			} else {
				time = rueckwarts--;
				vorwaerts = 0;
			}

			baum.changeTimeTo(time);
			blume.changeTimeTo(time);
			System.out.println(time);

			painter.showDrawingAfterWaiting(500);
		}

	}

}
