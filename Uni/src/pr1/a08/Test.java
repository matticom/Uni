package pr1.a08;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class Test {
	public static void main(String[] args) {
		DirtyPainter dp = new DirtyPainter();
		double timeValue = 0;
		RotatingPoint rotatingPoint = new RotatingPoint(20, 20, 200, timeValue);
		RotatingPoint rotatingPoint2 = new RotatingPoint(20, 20, 200, timeValue);
		RotatingPoint rotatingPoint3 = new RotatingPoint(20, 20, 200, timeValue);
		RotatingPoint rotatingPoint4 = new RotatingPoint(20, 20, 200, timeValue);
		dp.add(rotatingPoint);
		dp.add(rotatingPoint2);
		dp.add(rotatingPoint3);
		dp.add(rotatingPoint4);
		
		while (true) {
			timeValue += Math.PI/6;
			rotatingPoint.changeTimeTo(timeValue);
			rotatingPoint2.changeTimeTo(timeValue+Math.PI*2/4);
			rotatingPoint3.changeTimeTo(timeValue+Math.PI*4/4);
			rotatingPoint4.changeTimeTo(timeValue+Math.PI*6/4);
			dp.showDrawingAfterWaiting(300);
		}
	}
}
