package pr2.a03;

public class RekursionsTest {

	public static void main(String[] args) {
		
		int[] array = Rekursion.createArray("./listen/intArray.txt");
		Rekursion.print(array);
		int[] array2 = Rekursion.createArrayDirectFrom("2 3");
		Rekursion.print(array2);
		System.out.println(Rekursion.indexOfRecursiv(102, array));
	}

}
