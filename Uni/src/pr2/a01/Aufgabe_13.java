package pr2.a01;

public class Aufgabe_13 {
	public static void main(String[] sonja) {
		for(int n = 1; n <= 3; n++) {
			
			try {
				met01(n);
			} catch (NullPointerException exa) { // Subklassen werden auch abgefangen
				System.out.println("NP Ex");
			} catch (Exa exa) { // Subklassen werden auch abgefangen
				System.out.println("R ex:A");
			
			} finally {
				System.out.println("S ----");
			}
		}
	}
	
	private static void met01(int n) throws Exa {
		try {
			met02(n);
			System.out.println("T ----");
		} catch (Exc exc) {
			System.out.println("U ex:C");
		} catch (Exb exb) {
			System.out.println("V ex:B");
			throw exb;
		}
	}
	
	protected static void met02(int n) throws Exa {
		
		try {
			switch (n) {
			case 1:
				throw new Exa();
			case 2:
				throw new Exb();
			case 3:
				throw new Exc();
			}
		} catch (Exc exc) {
			System.out.println("W ex:C");
			throw exc;
		}
	}
}
