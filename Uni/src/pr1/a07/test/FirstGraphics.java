package pr1.a07.test;

import java.awt.Color;
import java.awt.Graphics;

import pr1.a07.Gitter;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class FirstGraphics implements Drawable{
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillArc(55, 120, 805, 605, 0, 165);
		g.setColor(Color.PINK);
		g.drawRect(250, 350, 150, 550);
		g.setColor(Color.MAGENTA);
		g.draw3DRect(505, 505, 305, 405, true);
		Gitter gitterFein = new Gitter(25, 25, Color.LIGHT_GRAY);
		gitterFein.draw(g);
		Gitter gitterGrob = new Gitter(100, 100, Color.BLACK);
		gitterGrob.draw(g);
	}
}
