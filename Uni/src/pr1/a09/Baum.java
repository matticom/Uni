package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;

public class Baum extends Pflanze {

	public Baum(double MAX_HEIGHT, double GROW_FACTOR) {
		super(MAX_HEIGHT, GROW_FACTOR);
	}

	@Override
	public void draw(Graphics g) {
		drawStem(g);
		drawBranches(g);
		if (height > 20) {
			drawLeaves(g);
		}
	}

	private void drawStem(Graphics g) {
		g.setColor(createColor(139, 90, 43));
		g.fillRect(-20, 0, 40, 250);
	}

	private void drawBranches(Graphics g) {
		g.fillPolygon(new int[] { -100, -90, -5, -20 }, new int[] { -100, -100, 0, 10 }, 4);
		g.fillPolygon(new int[] { 90, 100, 20, 0 }, new int[] { -100, -100, 10, 10 }, 4);
		g.fillRect(50, -50, 80, 5);
		g.fillRect(-100, -30, 60, 5);
		g.fillRect(-140, -80, 60, 5);
		g.fillRect(-60, -110, 5, 60);
		g.fillRect(70, -130, 5, 60);
		g.fillRect(30, -80, 5, 60);
	}

	private void drawLeaves(Graphics g) {
		g.setColor(createColor(0, 153, 0));
		int x, y;
		double leavesRadius = 3 * (height/30);
//		System.out.println("Blätterradius: " + blaetterRadius);
		double density = height * 2;
//		System.out.println("Dichte: " + dichte);
		for (int radius = 0; radius < 160; radius += 5) {
			for (double angle = 0; angle < Math.PI * 2; angle += 2*Math.PI / density) {
				x = (int) (0 + radius * Math.cos(angle));
				y = (int) (80 + radius * Math.sin(angle));
				g.fillOval((int) (-leavesRadius / 2 - x), (int) (-leavesRadius / 2 - y), (int) (leavesRadius), (int) (leavesRadius));
			}
		}
	}

	@Override
	public void changeTimeTo(double timeValue) {
		double change = timeValue - time;
		time = timeValue;
//		System.out.println("aktuelle Höhe: " + height);
		if (timeValue < 4) {
			return;
		}
		if (change >= 0) {
			waechst();
		}
		if (change < 0) {
			gehtEin();
		}

	}

	private Color createColor(int R, int G, int B) {
		float[] HSBArray = new float[3];
		Color.RGBtoHSB(R, G, B, HSBArray);
		return Color.getHSBColor(HSBArray[0], HSBArray[1], HSBArray[2]);
	}
}
