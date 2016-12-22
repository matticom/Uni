package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;

public class Blume extends Pflanze {

	public Blume(double MAX_HEIGHT, double GROW_FACTOR) {
		super(MAX_HEIGHT, GROW_FACTOR);
	}

	@Override
	public void draw(Graphics g) {
		drawFlowerStem(g);
		drawBloom(g);
		if (height > 20) {
			drawBloomLeaves(g);
		}
	}

	@Override
	public void changeTimeTo(double timeValue) {
		double dayLightDuration = 12 * Math.sin(Math.PI * timeValue/20 - Math.PI/4) + 12;
		if (timeValue < 4) {
			return;
		}
		if (Math.cos(Math.PI * timeValue/20 - Math.PI/4) >= 0) {
			waechst();
		} else {
			gehtEin();
		}
	}

	private void drawBloomLeaves(Graphics g) {
		int relX, relY;
		double radius = (height-7)*1;
		double blaetterRadius = (height-10)*1.2;
		for (double angle = 0; angle <= Math.PI * 1.75; angle += Math.PI / 4) {
			relX = (int) (0 + radius * Math.cos(angle));
			relY = (int) (0 + radius * Math.sin(angle));
			g.setColor(Color.ORANGE);
			g.fillOval((int)(-blaetterRadius/2 - relX + getX()), (int)(-blaetterRadius/2 - relY + getY()), (int)(blaetterRadius), (int)(blaetterRadius));
		}
	}

	private void drawBloom(Graphics g) {
		double bluetenRadius = height * 0.7;
		g.setColor(Color.YELLOW);
		g.fillOval((int)(-bluetenRadius/2 + getX()), (int)(-bluetenRadius/2) + getY(), (int)(bluetenRadius), (int)(bluetenRadius));
	}

	private void drawFlowerStem(Graphics g) {
		g.setColor(new Color(154,205,50));
		g.fillRect(-2 + getX(), 0 + getY(), 4, 150);
	}
}
