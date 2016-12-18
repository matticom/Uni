package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;

public class Blume extends Pflanze {

	public Blume(double MAX_HEIGHT, double GROW_FACTOR) {
		super(MAX_HEIGHT, GROW_FACTOR);
	}

	@Override
	public void draw(Graphics g) {
		drawBlumenstil(g);
		drawBluete(g);
		if (height > 20) {
			drawBluetenBlaetter(g);
		}
	}

	@Override
	public void changeTimeTo(double timeValue) {
		double change = timeValue - time;
		time = timeValue;
//		System.out.println("aktuelle Höhe: " + height);
		if (timeValue < 4 || timeValue > 20) {
			return;
		}
		if (change >= 0) {
			waechst();
		}
		if (change < 0) {
			gehtEin();
		}
	}

	private void drawBluetenBlaetter(Graphics g) {
		int x, y;
		double radius = (height-7)*1;
		double blaetterRadius = (height-10)*1.2;
		for (double angle = 0; angle <= Math.PI * 1.75; angle += Math.PI / 4) {
			x = (int) (0 + radius * Math.cos(angle));
			y = (int) (0 + radius * Math.sin(angle));
			g.setColor(Color.ORANGE);
			g.fillOval((int)(-blaetterRadius/2 - x), (int)(-blaetterRadius/2 - y), (int)(blaetterRadius), (int)(blaetterRadius));
		}
	}

	private void drawBluete(Graphics g) {
		double bluetenRadius = height * 0.7;
		g.setColor(Color.YELLOW);
		g.fillOval((int)(-bluetenRadius/2), (int)(-bluetenRadius/2), (int)(bluetenRadius), (int)(bluetenRadius));
	}

	private void drawBlumenstil(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(-2, 0, 4, 150);
	}
}
