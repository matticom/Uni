package pr2.a06;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pr2.a06.util.Wetterzustand;
import schimkat.berlin.lernhilfe2017ss.event.weather.WeatherSymbol;
import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class WetterMelder implements ActionListener {

	private DirtyPainter dp;
	private WeatherSymbol weatherSymbol;
	
	public WetterMelder() {
		dp = new DirtyPainter();
		weatherSymbol = new WeatherSymbol(200, 200);
		dp.add(weatherSymbol);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Wetterzustand.SONNIG:
			weatherSymbol.changeToSunny();
			break;
		case Wetterzustand.BEDECKT:
			weatherSymbol.changeToOvercast();
			break;
		case Wetterzustand.WOLKIG:
			weatherSymbol.changeToCloudy();
			break;
		case Wetterzustand.REGEN:
			weatherSymbol.changeToRain();
			break;
		case Wetterzustand.GEWITTER:
			weatherSymbol.changeToTempest();
			break;
		default:
			break;
		}
		dp.showDrawing();
	}
}
