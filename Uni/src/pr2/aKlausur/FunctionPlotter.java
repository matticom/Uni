package pr2.aKlausur;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FunctionPlotter extends JPanel {
	protected Function fct;

	public FunctionPlotter(Function fct) {
		this.fct = fct;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGitter(g);
		drawFunction(g);
	}
	
	protected void drawGitter(Graphics g) {
		g.setColor(Color.GRAY);
		for (int x = 0; x <= 500; x = x+25) {
			g.drawLine(x, 0, x, 600);
		}
		
		for (int y = 0; y <= 600; y = y+25) {
			g.drawLine(0, y, 500, y);
		}
		g.setColor(Color.BLACK);
		g.drawLine(0, 400, 500, 400);
	}
	
	protected void drawFunction(Graphics g) {
		g.setColor(Color.RED);
		for(int x = 0; x < 500; x++) {
			int y1 = 400-fct.value(x);
			int y2 = 400-fct.value(x+1);
			System.out.println("WertePaar ( " + x + " , " + y1 + " )");
			g.drawLine(x, y1, x, y2);
		}
	}	
}
