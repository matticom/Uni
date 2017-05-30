package pr1.a09;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class ParkTest {

	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		Park park = new Park();
		painter.add(park);
		int time = 0;

		while (true) {
			park.changeTimeTo(time++);
			painter.showDrawingAfterWaiting(250);
		}
	}

	

}
