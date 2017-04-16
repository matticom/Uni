package aud.a01;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SelectSort {
	
	private int smallestValue = 0;
	private int smallestValueIndex = 0;
	private int[] array;
		
	public SelectSort() {
		smallestValue = 0;
		smallestValueIndex = 0;
	}

	public int[] sortArray(int[] unsortedArray) {
		array = unsortedArray;
		for(int currentIndex = 0; currentIndex < array.length-1; currentIndex++) {
			smallestValue = array[currentIndex];
			smallestValueIndex = currentIndex;
			determineSmallestValue(currentIndex);
			if (!smallestValueAlreadyAtFirstPosition(currentIndex)) {
				moveSmallestToFirstPosition(currentIndex);
			}
		}
		return array;
	}
	
	private void determineSmallestValue(int currentIndex) {
		for(int i = currentIndex+1; i < array.length; i++) {
			if (smallestValue > array[i]) {
				smallestValue = array[i];
				smallestValueIndex = i;
			}
		}
	}
	
	private void moveSmallestToFirstPosition(int currentIndex) {
		int temp = array[currentIndex];
		array[currentIndex] = array[smallestValueIndex];
		array[smallestValueIndex] = temp;
	}
	
	private boolean smallestValueAlreadyAtFirstPosition(int currentIndex){
		return currentIndex == smallestValueIndex;
	}
	
	public static void main(String[] args) {
		Instant start, end;
		Long startLong, endLong;
		Random random = new Random();
		int[] testArray = new int[100000];
		for(int i=0; i<100000; i++) {
			testArray[i] = random.nextInt(1000000)-500000;
		}
		
		start = Instant.now();
		startLong = start.toEpochMilli();
		SelectSort selectSort = new SelectSort();
		
		System.out.println(Arrays.toString(selectSort.sortArray(testArray)));
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println("Verbrauchte Zeit für Sortieren und darstellen [ms]: " + (endLong-startLong));
	}
	
}
