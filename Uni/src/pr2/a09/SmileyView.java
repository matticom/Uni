package pr2.a09;

import java.awt.Color;
import java.awt.Graphics;
import schimkat.berlin.lernhilfe2017ss.graphics.Drawable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

public class SmileyView extends JPanel implements Drawable, PropertyChangeListener {

	protected int kopfRadius;
	protected int augenKopfProzent;
	protected int augenRadius;
	protected double augapfelWinkel;
	protected boolean laecheln;
	protected int x;
	protected int y;

	protected SmileyModel smileyModel;

	public SmileyView(SmileyModel smileyModel) {
		this.smileyModel = smileyModel;
		updateProperties();
	}

	@Override
	public void draw(Graphics g) {
		augenRadius = kopfRadius * augenKopfProzent / 100;
		int xPos_linkes_Auge = (int) (kopfRadius / 2);
		int xPos_rechtes_Auge = (int) (3 * kopfRadius / 2);
		int yPos_Augen = (int) (4 * kopfRadius / 5);
		Point linkes_Auge = new Point(x + xPos_linkes_Auge, y + yPos_Augen);
		Point rechtes_Auge = new Point(x + xPos_rechtes_Auge, y + yPos_Augen);
		drawKopf(g);
		drawAugen(g, linkes_Auge, rechtes_Auge);
		drawAugaepfel(g, linkes_Auge, rechtes_Auge);
		drawMund(g);
	}

	private void drawKopf(Graphics g) {
		int seitenlaenge_Kopf = 2 * kopfRadius;
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, seitenlaenge_Kopf, seitenlaenge_Kopf);
	}

	private void drawAugen(Graphics g, Point linkes_Auge, Point rechtes_Auge) {
		int augen_Durchmesser = augenRadius * 2;
		Point linkes_Auge_Ecke = Calc.kreisMitteZuObererLinkerEcke(linkes_Auge, augenRadius);
		Point rechtes_Auge_Ecke = Calc.kreisMitteZuObererLinkerEcke(rechtes_Auge, augenRadius);
		g.setColor(Color.WHITE);
		g.fillOval(linkes_Auge_Ecke.x, linkes_Auge_Ecke.y, augen_Durchmesser, augen_Durchmesser);
		g.fillOval(rechtes_Auge_Ecke.x, rechtes_Auge_Ecke.y, augen_Durchmesser, augen_Durchmesser);
	}

	private void drawAugaepfel(Graphics g, Point linkes_Auge, Point rechtes_Auge) {
		int augapfel_Durchmesser = augenRadius;
		Point linker_Augapfel_Ecke = Calc.berechneAugapfelPosition(linkes_Auge, augenRadius, augapfelWinkel);
		Point rechter_Augapfel_Ecke = Calc.berechneAugapfelPosition(rechtes_Auge, augenRadius, augapfelWinkel);
		g.setColor(Color.BLACK);
		g.fillOval(linker_Augapfel_Ecke.x, linker_Augapfel_Ecke.y, augapfel_Durchmesser, augapfel_Durchmesser);
		g.fillOval(rechter_Augapfel_Ecke.x, rechter_Augapfel_Ecke.y, augapfel_Durchmesser, augapfel_Durchmesser);
	}

	private void drawMund(Graphics g) {
		int xPos_linker_Mund = (int) (2 * kopfRadius / 5);
		int xPos_rechter_Mund = (int) (8 * kopfRadius / 5);
		if (laecheln) {
			int yPos_Mund = (int) (5 * kopfRadius / 5);
			int breite_Mund = xPos_rechter_Mund - xPos_linker_Mund;
			int hoehe_Mund = (int) (9*kopfRadius/5 - yPos_Mund);
			g.setColor(Color.RED);
			g.fillArc(x + xPos_linker_Mund, y + yPos_Mund, breite_Mund, hoehe_Mund, 180, 180);
		} else {
			int yPos_Mund = (int) (7 * kopfRadius / 5);
			g.setColor(Color.RED);
			g.drawLine(x + xPos_linker_Mund, y + yPos_Mund, x + xPos_rechter_Mund, y + yPos_Mund);
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName().equals("MODEL_UPDATE")) {
			updateProperties();
		}
	}
	
	private void updateProperties() {
		kopfRadius = smileyModel.getKopfRadius();
		augenKopfProzent = smileyModel.getAugenKopfProzent();
		augapfelWinkel = smileyModel.getAugapfelWinkel();
		laecheln = smileyModel.isLaecheln();
		x = smileyModel.getX();
		y = smileyModel.getX();
	}
			
	private static class Point {
		
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void moveAbs(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void moveRel(int dx, int dy) {
			x += dx;
			y += dy;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}
	
	public static class Calc {
		
		public static Point kreisMitteZuObererLinkerEcke(Point kreisMitte, int radius) {
			Point kreisEcke = new Point(kreisMitte.x, kreisMitte.y);
			kreisEcke.moveRel(-radius, -radius);
			return kreisEcke;
		}
		
		public static Point berechneAugapfelPosition(Point auge, int augenRadius, double augapfelWinkel) {
			int x_Rotation_Auge = (int) (auge.x + augenRadius/2 * Math.cos(augapfelWinkel));
			int y_Rotation_Auge = (int) (auge.y + augenRadius/2 * Math.sin(augapfelWinkel));
			Point augapfel = new Point(x_Rotation_Auge, y_Rotation_Auge);
			return kreisMitteZuObererLinkerEcke(augapfel, augenRadius/2);
		}
	}

}
