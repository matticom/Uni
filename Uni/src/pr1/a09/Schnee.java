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
			time = ++timeValue;
		} else {
			time = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		drawSnowFlakes(g);
	}
	
	private void drawSnowFlakes(Graphics g) {
		if (time != 0) {
			for (double density = 1; density < 500 / time; density++) {
				int x = (int) (Math.random() * 1500);
				int y = (int) (Math.random() * 1400);
				g.fillOval(x, y, 4, 4);
			}
		}
	}

}
