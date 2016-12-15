package pr1.a09;

import java.util.ArrayList;
import java.util.Collection;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class ParkTest {

	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		
		Collection<Pflanze> pflanzenList = new ArrayList<Pflanze>();
		pflanzenList = fillPflanzenList(pflanzenList);

		int[][] positionArray = new int[pflanzenList.size()][2];
		positionArray = setPflanzenPositions(positionArray);
		
		Park park = new Park(pflanzenList, positionArray, new Schnee(), new Sonne());
		painter.add(park);

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

			park.changeTimeTo(time);
			System.out.println(time);

			painter.showDrawingAfterWaiting(500);
		}
	}

	private static int[][] setPflanzenPositions(int[][] positionArray) {
		for (int i = 0; i < positionArray.length; i++) {
			positionArray[i][0] = (int) (Math.random() * 1200 + 100);
			positionArray[i][1] = (int) (Math.random() * 700 + 100);
		}
		return positionArray;
	}
	
	private static Collection<Pflanze> fillPflanzenList(Collection<Pflanze> pflanzenList) {
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		return pflanzenList;
	}

}
