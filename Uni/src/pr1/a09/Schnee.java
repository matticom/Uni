package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;

import pr1.a08.ChangingWithTime;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Schnee implements ChangingWithTime, Drawable {

	protected double time;

	@Override
	public void changeTimeTo(double timeValue) {
		if (timeValue < 6) {
			time = timeValue;
		} else {
			time = 100;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		if (time != 100) {

			for (double dichte = 1; dichte < 500 / time; dichte++) {
				int x = (int) (Math.random() * 1500);
				int y = (int) (Math.random() * 1000);
				g.fillOval(x, y, 4, 4);
			}
		}
	}

}
