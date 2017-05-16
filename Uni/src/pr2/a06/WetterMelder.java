package pr2.a06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import pr2.a06.util.Wetterzustand;
import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2015ss.event.weather.WeatherSymbol;

public class WetterMelder implements ActionListener {

	private WeatherSymbol recentSymbol;
	private DirtyPainter dp;
	private WeatherSymbol sonnig;
	private WeatherSymbol bedeckt;
	private WeatherSymbol wolkig;
	private WeatherSymbol regen;
	private WeatherSymbol gewitter;
	
	public WetterMelder() {
		dp = new DirtyPainter();
		sonnig = new WeatherSymbol(200, 200);
		bedeckt = new WeatherSymbol(200, 200);
		wolkig = new WeatherSymbol(200, 200);
		regen = new WeatherSymbol(200, 200);
		gewitter = new WeatherSymbol(200, 200);
		dp.add(sonnig);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dp.remove(recentSymbol);
		switch (e.getActionCommand()) {
		case Wetterzustand.SONNIG:
			changeToSonnig();
			break;
		case Wetterzustand.BEDECKT:
			changeToBedeckt();
			break;
		case Wetterzustand.WOLKIG:
			changeToWolkig();
			break;
		case Wetterzustand.REGEN:
			changeToRegen();
			break;
		case Wetterzustand.GEWITTER:
			changeToGewitter();
			break;
		default:
			break;
		}
		dp.showDrawing();
	}

	public void changeToSonnig() {
		dp.add(sonnig);
		recentSymbol = sonnig;
	}

	public void changeToBedeckt() {
		dp.add(bedeckt);
		recentSymbol = bedeckt;
	}

	public void changeToWolkig() {
		dp.add(wolkig);
		recentSymbol = wolkig;
	}

	public void changeToRegen() {
		dp.add(regen);
		recentSymbol = regen;
	}

	public void changeToGewitter() {
		dp.add(gewitter);
		recentSymbol = gewitter;
	}
}
