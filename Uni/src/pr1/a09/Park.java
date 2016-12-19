package pr1.a09;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import pr1.a08.ChangingWithTime;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Park implements Drawable, ChangingWithTime {
	
	private Collection<Pflanze> pflanzenList = new ArrayList<Pflanze>();
	private int[][] positionArray;
	private Schnee schnee;
	private Sonne sonne;
		
	public Park(Collection<Pflanze> pflanzenList, int[][] positionArray, Schnee schnee, Sonne sonne) {
		this.pflanzenList = pflanzenList;
		this.positionArray = positionArray;
		this.schnee = schnee;
		this.sonne = sonne;
	}
	
	@Override
	public void draw(Graphics g) {
		drawSky(g);
		drawMeadow(g);
		sonne.draw(g);
		drawPflanzen(g);
		schnee.draw(g);
	}

	@Override
	public void changeTimeTo(double timeValue) {
		for(Pflanze pflanze: pflanzenList) {
			pflanze.changeTimeTo(timeValue);
		}
		schnee.changeTimeTo(timeValue);
		sonne.changeTimeTo(timeValue);
	}
	
	private void drawPflanzen(Graphics g) {
		Pflanze currentPflanze;
		int x;
		int y;
		for(int i = 0; i < pflanzenList.size(); i++) {
			x = positionArray[i][0];
			y = positionArray[i][1];
			currentPflanze = ((ArrayList<Pflanze>)(pflanzenList)).get(i);
			currentPflanze.moveAbs(x, y);
			currentPflanze.draw(g);
	
		}
	}
	
	private void drawMeadow(Graphics g) {
		g.setColor(ColorCreator.createColor(0,255,127));
		g.fillOval(-700, 300, 5000, 1500);
	}
	
	private void drawSky(Graphics g) {
		g.setColor(ColorCreator.createColor(135,206,255));
		g.fillRect(0, 0, 2000, 800);
	}
	
}
