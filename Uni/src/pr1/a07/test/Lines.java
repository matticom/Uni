package pr1.a07.test;

import java.awt.Color;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Lines implements Drawable{
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawLine(60, 70, 1000, 700);
		g.setColor(Color.BLUE);
		g.drawLine(600, 705, 10, 705);
		g.setColor(Color.ORANGE);
		g.drawLine(305, 0, 305, 900);
	}
}
