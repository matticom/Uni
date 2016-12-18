package pr1.a08;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class RotatingPoint extends Point implements ChangingWithTime, Drawable{

	protected int r;
	protected double time;
	protected final int x0 = 400;
	protected final int y0 = 250;
		
	public RotatingPoint(int x, int y, int r, double time) {
		super(x, y);
		this.r = r;
		this.time = time;
	}

	@Override
	public void changeTimeTo(double timeValue) {
		x = (int)(x0 + r * Math.cos(timeValue));
		y = (int)(y0 + r * Math.sin(timeValue));
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-4, y-4, 8, 8);
	}

	public int getR() {
		return r;
	}

	public double getTime() {
		return time;
	}
	
	
}
