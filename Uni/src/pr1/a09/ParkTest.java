package pr1.a09;

import java.util.ArrayList;
import java.util.Collection;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class ParkTest {

	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		
		Collection<Pflanze> pflanzenList = new ArrayList<Pflanze>();
		pflanzenList = fillPflanzenList(pflanzenList);

		int[][] pflanzenPosition = new int[pflanzenList.size()][2];
		pflanzenPosition = setPflanzenPositions(pflanzenPosition);
		
		Park park = new Park(pflanzenList, pflanzenPosition, new Schnee(), new Sonne());
		painter.add(park);

		double time = 0;
		int counter = 0;
		int forward = 0;
		int backward = 0;

		while (true) {
			counter++;
			int intDiv = counter / 25;

			if (intDiv % 2 == 0) {
				time = forward++;
				backward = 24;
			} else {
				time = backward--;
				forward = 0;
			}
			park.changeTimeTo(time);
//			System.out.println(time);
			painter.showDrawingAfterWaiting(500);
		}
	}

	private static int[][] setPflanzenPositions(int[][] positionArray) {
		for (int i = 0; i < positionArray.length; i++) {
			positionArray[i][0] = (int) (Math.random() * 1000 + 150);
			positionArray[i][1] = (int) (Math.random() * 700 + 300);
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
