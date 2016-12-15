package pr1.a09;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import pr1.a08.ChangingWithTime;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Park implements Drawable, ChangingWithTime {
	
	Collection<Pflanze> pflanzenList = new ArrayList<Pflanze>();
	int[][] positionArray;
	Schnee schnee;
	Sonne sonne;
		
	public Park(Collection<Pflanze> pflanzenList, int[][] positionArray, Schnee schnee, Sonne sonne) {
		this.pflanzenList = pflanzenList;
		this.positionArray = positionArray;
		this.schnee = schnee;
		this.sonne = sonne;
	}
	
	@Override
	public void draw(Graphics g) {
	
		for(int i = 0; i < pflanzenList.size(); i++) {
			int x = positionArray[i][0];
			int y = positionArray[i][1];
			g.translate(x, y);
			((ArrayList<Pflanze>)(pflanzenList)).get(i).draw(g);
			g.translate(-x, -y);
		}
		schnee.draw(g);
		sonne.draw(g);
	}

	@Override
	public void changeTimeTo(double timeValue) {
		for(Pflanze pflanze: pflanzenList) {
			pflanze.changeTimeTo(timeValue);
		}
		schnee.changeTimeTo(timeValue);
		sonne.changeTimeTo(timeValue);
	}
}
