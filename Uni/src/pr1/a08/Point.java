package pr1.a08;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void moveAbs(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveRel(int dx, int dy) {
		x += dx;
		y += dy;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]"; 
	}
	
	
	
	
}
