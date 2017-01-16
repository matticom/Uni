package pr1.a12;

import java.util.HashMap;
import java.util.Map;


public class Colors {

	private static java.awt.Color awtColor(javafx.scene.paint.Color c) {
		return new java.awt.Color((float)c.getRed(), (float)c.getGreen(), 
									(float)c.getBlue(), (float)c.getOpacity());
	}
	
	public static java.awt.Color createByName(String fxColorName) {
		return awtColor(javafx.scene.paint.Color.valueOf(fxColorName));
	}
	
	public static java.awt.Color[] createColorsByName(String[] fxColorNames) {
		java.awt.Color[] awtColor = new java.awt.Color[fxColorNames.length];
		for(int i = 0; i < fxColorNames.length; i++) {
			awtColor[i] = createByName(fxColorNames[i]);
		}
		return awtColor;
	}
	
	public static Map<String, java.awt.Color> createMapByName(String[] fxColorNames) {
		HashMap<String, java.awt.Color> colorMap = new HashMap();
		for(String fxColorName : fxColorNames) {
			colorMap.put(fxColorName, createByName(fxColorName));
		}
		return colorMap;
	}
}
