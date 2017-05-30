package pr1.a09;

import pr1.a08.ChangingWithTime;
import pr1.a08.Point;
import schimkat.berlin.lernhilfe2017ss.graphics.Drawable;

public abstract class Pflanze extends Point implements Drawable, ChangingWithTime {

	protected double height;
	protected double MAX_HEIGHT;
	protected double GROW_FACTOR;

	public Pflanze(double MAX_HEIGHT, double GROW_FACTOR) {
		super(0, 0);
		this.MAX_HEIGHT = MAX_HEIGHT;
		this.GROW_FACTOR = GROW_FACTOR;
		height = 0;
	}

	protected void waechst() {
		if (height < MAX_HEIGHT) {
			if (height + GROW_FACTOR >= MAX_HEIGHT) {
				height = MAX_HEIGHT;
			} else {
				height += GROW_FACTOR;
			}
		}
	}

	protected void gehtEin() {
		if (height > 0) {
			if (height - GROW_FACTOR <= 0) {
				height = 0;
			} else {
				height -= GROW_FACTOR;
			}
		}
	}
}
