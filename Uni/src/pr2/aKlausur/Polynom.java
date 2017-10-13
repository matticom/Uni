package pr2.aKlausur;

public class Polynom implements Function {

	@Override
	public int value(int x) {
		x = x-250;
		return (int)(3*Math.pow(x, 4)+ 1*Math.pow(x, 2) + 5*x + 46);
	}

}
