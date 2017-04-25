package pr2.a03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rekursion {
	public static int[] createArray(Scanner in) {
		List<Integer> arrayList = new ArrayList<Integer>();
		while (in.hasNextInt()) {
			arrayList.add(new Integer(in.nextInt()));
		}
		
		int[] array = new int[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++){
			array[i] = arrayList.get(i);
		}
		return array;
	}

	public static int[] createArray(String file) {
		
		try (FileReader reader = new FileReader(file)){
			Scanner in = new Scanner(reader);
			int[] array = createArray(in);
			in.close();
			return array;
		} catch (IOException e) {
			System.out.println("Datei " +  file + "nicht gefunden");
		}
		return null;
	}

	public static int[] createArrayDirectFrom(String stringWithNumbers) {
		Scanner in = new Scanner(stringWithNumbers);
		int[] array = createArray(in);
		in.close();
		return array;
	}

	public static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static int indexOfStandard(int number, int[] array) {
		int retValue = -1;
		for(int i = 0; i < array.length; i++){
			if (array[i] == number) {
				return i;
			}
		}
		return retValue;
	}

	public static int indexOfRecursiv(int number, int[] array) {
		return indexOfRecursiv(number, array, 0, array.length-1);
	}

	public static int indexOfRecursiv(int number, int[] array, int startIndex, int endIndex) {
		
		if (startIndex != endIndex) {
			if (array[(startIndex+endIndex) / 2] == number) {
				return (startIndex+endIndex) / 2;
			}
			if (array[(startIndex+endIndex) / 2] > number) {
				return indexOfRecursiv(number, array, startIndex, endIndex/2 - 1);
			} else {
				return indexOfRecursiv(number, array, ((endIndex+startIndex) / 2) + 1, endIndex);
			}
		} else {
			if (array[startIndex] == number) {
				return startIndex;
			} else {
				return -1;
			}
		}
	}

	public void test() {

	}

	public void test(File dir) {

	}
	
	public static int numbersOfIntValues(Scanner in) {
		int num = 0;
		while (in.hasNextInt()) {
			in.nextInt();
			num++;
		}
		return num;
	}
}
