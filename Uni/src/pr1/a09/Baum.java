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
		g.setColor(ColorCreator.createColor(139, 90, 43));
		g.fillRect(getX()-20, getY()+0, 40, 250);
	}

	private void drawBranches(Graphics g) {
		g.fillPolygon(new int[] { getX() - 100, getX() - 90, getX() - 5, getX() - 20 }, 
						new int[] { getY() - 100, getY() - 100, getY() + 0, getY() + 10 }, 4);
		g.fillPolygon(new int[] { getX() + 90, getX() + 100, getX() + 20, getX() + 0 }, 
						new int[] { getY() - 100, getY() - 100, getY() + 10, getY() + 10 }, 4);
		g.fillRect(getX() + 50, getY() - 50, 80, 5);
		g.fillRect(getX() - 100, getY() - 30, 60, 5);
		g.fillRect(getX() - 140, getY() - 80, 60, 5);
		g.fillRect(getX() - 60, getY() - 110, 5, 60);
		g.fillRect(getX() + 70, getY() - 130, 5, 60);
		g.fillRect(getX() + 30, getY() - 80, 5, 60);
	}

	private void drawLeaves(Graphics g) {
		g.setColor(ColorCreator.createColor(0, 153, 0));
		int relX, relY;
		double leavesRadius = 3 * (height/30);
//		System.out.println("Blätterradius: " + blaetterRadius);
		double density = height * 2;
//		System.out.println("Dichte: " + dichte);
		for (int radius = 0; radius < 160; radius += 5) {
			for (double angle = 0; angle < Math.PI * 2; angle += 2*Math.PI / density) {
				relX = (int) (0 + radius * Math.cos(angle));
				relY = (int) (80 + radius * Math.sin(angle));
				g.fillOval((int) (-leavesRadius / 2 - relX + getX()), (int) (-leavesRadius / 2 - relY + getY()), (int) (leavesRadius), (int) (leavesRadius));
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
}
