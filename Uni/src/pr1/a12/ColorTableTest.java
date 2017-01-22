package pr1.a12;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class ColorTableTest {

	public static void main(String[] args) {
		String[] fxColorNames = {"BISQUE", "BLACK", "CHARTREUSE", "CORAL", "CRIMSON", "DARKORCHID",
								"DARKSEAGREEN", "DEEPPINK", "GOLD", "LIGHTBLUE", "MEDIUMPURPLE", 
								"MIDNIGHTBLUE", "POWDERBLUE", "SILVER", "STEELBLUE", "TEAL"};
		DirtyPainter dp = new DirtyPainter();
		ColorTable colorTable = new ColorTable(fxColorNames);
		dp.add(colorTable);
		dp.showDrawing();
	}
	// Die Color-fx Klasse hat static final Konstanten von der  
	// Methodenverbundklasse aber keine Klassenmethoden
	// Es sind statische Factories vorhanden von Bauplanklassen
	// fx-Color ist immutable wegen: public final class Color
}
