package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import pr1.a08.ChangingWithTime;
import schimkat.berlin.lernhilfe2017ss.graphics.Drawable;

public class Park implements Drawable, ChangingWithTime {
	
	private Collection<Pflanze> pflanzenList;
	private int[][] pflanzenPosition;
	private Schnee schnee;
	private Sonne sonne;
		
	public Park() {
		pflanzenList = plantingPflanzen();
		pflanzenPosition = createPflanzenPositions(pflanzenList.size());
		this.schnee = new Schnee();
		this.sonne = new Sonne();
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
			x = pflanzenPosition[i][0];
			y = pflanzenPosition[i][1];
			currentPflanze = ((ArrayList<Pflanze>)(pflanzenList)).get(i);
			currentPflanze.moveAbs(x, y);
			currentPflanze.draw(g);
		}
	}
	
	private void drawMeadow(Graphics g) {
		g.setColor(new Color(0,255,127));
		g.fillOval(-700, 300, 5000, 1500);
	}
	
	private void drawSky(Graphics g) {
		g.setColor(new Color(135,206,255));
		g.fillRect(0, 0, 2000, 800);
	}
	
	private int[][] createPflanzenPositions(int numbersOfPflanzen) {
		int[][] positionArray = new int[numbersOfPflanzen][2];
		for (int i = 0; i < positionArray.length; i++) {
			positionArray[i][0] = (int) (Math.random() * 1000 + 150);
			positionArray[i][1] = (int) (Math.random() * 700 + 300);
		}
		return positionArray;
	}
	
	private Collection<Pflanze> plantingPflanzen() {
		Collection<Pflanze> pflanzenList = new ArrayList<Pflanze>();
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Baum(110, 5));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		pflanzenList.add(new Blume(40, 3));
		return pflanzenList;
	}
	
}
