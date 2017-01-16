package pr1.a12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public final class ColorTable implements Drawable {

	protected Map<String, Color> colorMap;
	protected String[] keys;
	
	public ColorTable(String[] fxColorNames) {
		colorMap = Colors.createMapByName(fxColorNames);
		keys = new String[colorMap.size()];
		keys = colorMap.keySet().toArray(keys);
	}

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < colorMap.size(); i++) {
			g.setColor(colorMap.get(keys[i]));
			g.fillRect(50, 50 + i*50, 50, 30);
			g.setColor(Color.BLACK);
			g.drawString(keys[i], 110, 70 + i*50);
		}
	}
}
