package pr1.a12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public final class ColorTable implements Drawable {

	protected Map<String, Color> colorMap;
	protected String[] keySet;
	
	public ColorTable(String[] fxColorNames) {
		colorMap = Colors.createMapByName(fxColorNames);
		keySet = new String[colorMap.size()];
		keySet = colorMap.keySet().toArray(keySet);
	}

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < colorMap.size(); i++) {
			g.setColor(colorMap.get(keySet[i]));
			g.fillRect(50, 50 + i*50, 50, 30);
			g.setColor(Color.BLACK);
			g.drawString(keySet[i], 110, 70 + i*50);
		}
	}
}
