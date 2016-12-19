package pr1.a08;

import java.awt.Color;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class RotatingPoint extends Point implements ChangingWithTime, Drawable{

	protected int r;
	protected double time;
	protected int x0;
	protected int y0;
		
	public RotatingPoint(int x0, int y0, int r, double time) {
		super(0, 0);
		this.x0 = x0;
		this.y0 = y0;
		this.r = r;
		this.time = time;
		
	}

	@Override
	public void changeTimeTo(double timeValue) {
		int xRotation = (int)(x0 + r * Math.cos(timeValue));
		int yRotation = (int)(y0 + r * Math.sin(timeValue));
		moveAbs(xRotation, yRotation);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(getX()-4, getY()-4, 8, 8);
		g.setColor(Color.BLACK);
		g.fillOval(x0-4, y0-4, 8, 8);
		g.drawLine((int)(x0-r/2) - 100, y0, (int)(x0+r/2) + 100, y0);
		g.drawLine(x0, (int)(y0-r/2) - 100, x0, (int)(y0+r/2) + 100);
		g.drawOval(x0-r, y0-r, 2*r, 2*r);
	}

	public int getR() {
		return r;
	}

	public double getTime() {
		return time;
	}
	
	
}
