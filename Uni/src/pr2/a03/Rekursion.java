package pr2.a03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rekursion {
	public static int[] createArray(Scanner in) {
		// int integ = in.nextInt();
		// int[] numbers = IntStream.range(0, integ).map(i ->
		// in.nextInt()).toArray();

		// List<Integer> list = new ArrayList<>();
		//
		// list = IntStream.range(0,in.nextInt()).map(i ->
		// in.nextInt()).boxed().collect(Collectors.toList());
		// System.out.println(list);
		// return convertListToArray(list);

		return convertListToArray(scanIntValuesToList(in));
	}

	private static List<Integer> scanIntValuesToList(Scanner in) {
		List<Integer> arrayList = new ArrayList<Integer>();
		while (in.hasNextInt()) {
			arrayList.add(new Integer(in.nextInt()));
		}
		return arrayList;
	}

	private static int[] convertListToArray(List<Integer> arrayList) {
		// int[] array = new int[arrayList.size()];
		// for(int i = 0; i < arrayList.size(); i++){
		// array[i] = arrayList.get(i);
		// }
		// return array;
		return arrayList.stream().mapToInt(i -> i).toArray();
	}

	public static int[] createArray(String file) {
		try (FileReader reader = new FileReader(file); Scanner in = new Scanner(reader)) {
			return createArray(in);
		} catch (IOException e) {
			System.out.println("Datei " + file + " nicht gefunden");
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
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				return i;
			}
		}
		return retValue;
	}

	public static int indexOfRecursiv(int number, int[] array) {
		if (array.length == 0) {
			return -1;
		} else {
			return indexOfRecursiv(number, array, 0, array.length - 1);
		}
	}

	public static int indexOfRecursiv(int number, int[] array, int startIndex, int endIndex) {
		int midPosition = (endIndex + startIndex + 1) / 2;
		if (array[midPosition] == number) {
			return midPosition;
		}
		
		if (startIndex != endIndex) {
			if (array[midPosition] > number) {
				return indexOfRecursiv(number, array, startIndex, midPosition - 1);
			} else {
				return indexOfRecursiv(number, array, midPosition + 1, endIndex);
			}
		} else {
			return -1;
		}
	}

	public void test() {
		String str1 = "-3 19 23 28 40 56 84 102 111 130 144";
		String str2 = "-3002 -34 0 9 13 38 43 1311 12330, 14487";
		int[] str1Arr = createArrayDirectFrom(str1);
		int[] str2Arr = createArrayDirectFrom(str2);
		System.out.println("Test der Strings:\n\nString1 mit Standardalgorithmus:");
		print(str1Arr);
		for (int i = 0; i < str1Arr.length; i++) {
			System.out.print(Rekursion.indexOfStandard(str1Arr[i], str1Arr) + " ");
		}
		System.out.println("\n\nString2 mit Standardalgorithmus:");
		print(str2Arr);
		for (int i = 0; i < str2Arr.length; i++) {
			System.out.print(Rekursion.indexOfStandard(str2Arr[i], str2Arr) + " ");
		}
		System.out.println("\n\nString1 mit binärem Suchalgorithmus:");
		print(str1Arr);
		for (int i = 0; i < str1Arr.length; i++) {
			System.out.print(Rekursion.indexOfRecursiv(str1Arr[i], str1Arr) + " ");
		}
		System.out.println("\n\nString2 mit binärem Suchalgorithmus:");
		print(str2Arr);
		for (int i = 0; i < str2Arr.length; i++) {
			System.out.print(Rekursion.indexOfRecursiv(str2Arr[i], str2Arr) + " ");
		}
	}

	public void test(File dir) {
		int[] strArr = createArray(dir.getPath());
		System.out.println("\n\n\nTest der Datei:\n");
		print(strArr);
		System.out.println("\nDatei mit Standardalgorithmus:");
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(Rekursion.indexOfStandard(strArr[i], strArr) + " ");
		}
		System.out.println("\n\nDatei mit binärem Suchalgorithmus:");
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(Rekursion.indexOfRecursiv(strArr[i], strArr) + " ");
		}
	}
}
