package pr2.aKlausur;

public class Linear implements Function {

	@Override
	public int value(int x) {
		return (int)(0.2*(x-250)-10);
	}

}
