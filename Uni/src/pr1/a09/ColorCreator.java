package pr1.a09;

import java.awt.Color;

public class ColorCreator {

	public static Color createColor(int R, int G, int B) {
		float[] HSBArray = new float[3];
		Color.RGBtoHSB(R, G, B, HSBArray);
		return Color.getHSBColor(HSBArray[0], HSBArray[1], HSBArray[2]);
	}
}
