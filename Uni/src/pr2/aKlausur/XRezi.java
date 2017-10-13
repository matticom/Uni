package pr2.aKlausur;

public class XRezi implements Function {

	@Override
	public int value(int x) {
		if (x == 250) {
			return 0;
		} else {
			return (int) (1 / (x-250));
		}
	}

}
