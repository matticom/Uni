package aud.a01;

import java.util.Arrays;

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
		SelectSort selectSort = new SelectSort();
		int[] testArray = {-1, 1, 2, 3, -4, 8, 100};//{3, 4, 1, 34, 48, 2, 1};
		System.out.println(Arrays.toString(selectSort.sortArray(testArray)));
	}
	
}
