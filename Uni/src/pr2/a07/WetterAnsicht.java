package pr2.a07;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import schimkat.berlin.lernhilfe2017ss.event.weather.WeatherSymbol;
import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class WetterAnsicht implements PropertyChangeListener {
	private DirtyPainter dp;
	private WeatherSymbol weatherSymbol;
	private WetterModel wetterModel;

	public WetterAnsicht(WetterModel wetterModel) {
		dp = new DirtyPainter();
		weatherSymbol = new WeatherSymbol(200, 200);
		dp.add(weatherSymbol);
		this.wetterModel = wetterModel;
		dp.showDrawing();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		pr2.a07e.Wetterzustand wetterZustand = wetterModel.getWetterzustand();
		if (wetterZustand != null) {
			switch (wetterZustand) {
			case SONNIG:
				weatherSymbol.changeToSunny();
				break;
			case BEDECKT:
				weatherSymbol.changeToOvercast();
				break;
			case WOLKIG:
				weatherSymbol.changeToCloudy();
				break;
			case REGEN:
				weatherSymbol.changeToRain();
				break;
			case GEWITTER:
				weatherSymbol.changeToTempest();
				break;
			default:
				break;
			}
			dp.showDrawing();
		}
	}

}
