package pr1.a07;

import java.awt.Color;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Gitter implements Drawable {

	protected final int RANGE_X_MIN = 0;
	protected final int RANGE_Y_MIN = 0;
	protected final int RANGE_X_MAX = 1000;
	protected final int RANGE_Y_MAX = 1000;

	protected int dx;
	protected int dy;
	
	protected Color color;

	public Gitter() {
		this(100, 100, Color.YELLOW);
	}

	public Gitter(Gitter gitter) {
		this(gitter.dx, gitter.dy, gitter.color);
	}
	
	public Gitter(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		color = Color.YELLOW;
	}
	
	public Gitter(int dx, int dy, Color color) {
		this(dx, dy);
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		drawGrid(g);
	}
	
	private void drawGrid(Graphics g) {
		for (int position = RANGE_X_MIN; position <= RANGE_X_MAX; position += dx) {
			g.drawLine(position, RANGE_Y_MIN, position, RANGE_Y_MAX);
		}
		for (int position = RANGE_Y_MIN; position <= RANGE_Y_MAX; position += dy) {
			g.drawLine(RANGE_X_MIN, position, RANGE_X_MAX, position);
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
}
