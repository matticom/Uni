package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;

public class Baum extends Pflanze {

	public Baum(double MAX_HEIGHT, double GROW_FACTOR) {
		super(MAX_HEIGHT, GROW_FACTOR);
	}

	@Override
	public void draw(Graphics g) {
		drawStamm(g);
		drawAeste(g);
		if (height > 20) {
			drawBlaetter(g);
		}
	}

	private void drawStamm(Graphics g) {
		g.setColor(createColor(139, 90, 43));
		g.fillRect(-20, 0, 40, 250);
	}

	private void drawAeste(Graphics g) {
		g.fillPolygon(new int[] { -100, -90, -5, -20 }, new int[] { -100, -100, 0, 10 }, 4);
		g.fillPolygon(new int[] { 90, 100, 20, 0 }, new int[] { -100, -100, 10, 10 }, 4);
		g.fillRect(50, -50, 80, 5);
		g.fillRect(-100, -30, 60, 5);
		g.fillRect(-140, -80, 60, 5);
		g.fillRect(-60, -110, 5, 60);
		g.fillRect(70, -130, 5, 60);
		g.fillRect(30, -80, 5, 60);
	}

	private void drawBlaetter(Graphics g) {
		g.setColor(Color.GREEN);
		int x, y;
		double dichte = 1 + (height - 20) *5;
		double blaetterRadius = 2;
		for (int radius = 0; radius < 160; radius += 1) {
			for (double angle = 0; angle < Math.PI * 2; angle += Math.PI / (dichte + radius / 50 * Math.pow(-1, radius))) {
				x = (int) (0 + radius * Math.cos(angle));
				y = (int) (80 + radius * Math.sin(angle));
				g.fillOval((int) (-blaetterRadius / 2 - x), (int) (-blaetterRadius / 2 - y), (int) (blaetterRadius), (int) (blaetterRadius));
			}
		}
	}

	@Override
	public void changeTimeTo(double timeValue) {
		double change = timeValue - time;
		time = timeValue;
		System.out.println("aktuelle Höhe: " + height);
		if (timeValue < 4) {
//			height = 0;
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
