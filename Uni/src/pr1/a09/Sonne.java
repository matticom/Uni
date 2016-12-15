package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;

import pr1.a08.ChangingWithTime;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Sonne implements ChangingWithTime, Drawable {

	protected double time;

	@Override
	public void changeTimeTo(double timeValue) {
		if (timeValue > 6) {
			time = timeValue;
		} else {
			time = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		if (time != 0) {
			int x = (int) ((time - 6) * 75);
			int y = (int) (100 * Math.cos(Math.PI * (time - 7) / 10));
			g.fillOval(x, y, 200, 200);
		}
	}
}
