package pr2.a03;

import java.io.File;

public class RekursionsTest {

	public static void main(String[] args) {
		Rekursion rekursion = new Rekursion();
		rekursion.test();
		rekursion.test(new File("./listen/intArray.txt"));
		rekursion.test(new File("./listen/intArray2.txt"));
	}

}
