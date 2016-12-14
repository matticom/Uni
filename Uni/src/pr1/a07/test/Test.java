package pr1.a07.test;

import java.awt.Color;

import pr1.a07.Gitter;
import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainterTest;

public class Test {

	public static void main(String[] args) {
//		DirtyPainterTest.main(null);
		
		// Zeichnen eigener Objekte
		DirtyPainter painter = new DirtyPainter();
//		painter.add(new FirstGraphics());
//		painter.add(new Lines());
		
		gitterTest(painter);
		painter.showDrawing();
	}
	
	private static void gitterTest(DirtyPainter painter) {
		// Gittertest
		Gitter standardGitter = new Gitter();
		painter.add(standardGitter);
		Gitter feinesRotesGitter = new Gitter(10, 10, Color.RED);
		painter.add(feinesRotesGitter);
		Gitter feinesBlauesGitter = new Gitter(feinesRotesGitter);
		feinesBlauesGitter.setColor(Color.BLUE);
		painter.add(feinesBlauesGitter);
		Gitter grobesGrauesGitter = new Gitter(355, 250);
		grobesGrauesGitter.setColor(Color.LIGHT_GRAY);
		painter.add(grobesGrauesGitter);
	}

}
