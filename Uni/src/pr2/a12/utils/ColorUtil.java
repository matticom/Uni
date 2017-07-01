package pr2.a12.utils;

public class ColorUtil {

	public static java.awt.Color convertFxColorToAwtColor(javafx.scene.paint.Color fx) {
		return new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());
	}
}
