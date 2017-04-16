package aud.a02;

import java.util.Arrays;
import java.util.Random;
import aud.a01.SelectSort;
import java.time.Instant;

public class MergeSortOptimize {
	private int[] auxArray;
	private int[] array;
	
	public int[] sortArrayWithMergeSort(int[] array) {
		this.array = array;
		int r = array.length-1;
		auxArray = new int[r+1];
		mergeSort(0, r);
		return this.array;
	}
	
	private void mergeSort(int l, int r) {
		int m;
		if (l < r) {
			m = (l+r) / 2;
			mergeSort(l, m);
			mergeSort(m+1, r);
			merge(l, m, r);
		}
	}
	
	private void merge(int l, int m, int r) {
		copyToAuxArray(l, m, r);
		int arrayIdx = l;
		while( l != r ) {
			if (auxArray[l] >= auxArray[r]) {
				array[arrayIdx++] = auxArray[r--];
			} else {
				array[arrayIdx++] = auxArray[l++];
			}
		}
		array[arrayIdx] = auxArray[r];
	}
	
	private void copyToAuxArray(int l, int m, int r) {
		for(int i = l; i <= m; i++) {
			auxArray[i] = array[i];
		}
		int j = m+1;
		for(int i = r; i > m; i--) {
			auxArray[i] = array[j++];
		}
	}
	
	public static void main(String[] args) {
		Instant start, end;
		Long startLong, endLong;
		Random random = new Random();
		int[] testArray = new int[100000];
		for(int i=0; i<100000; i++) {
			testArray[i] = random.nextInt(1000000)-500000;
		}
		
		MergeSortOptimize mergeSortOptimize = new MergeSortOptimize();
		SelectSort selectSort = new SelectSort();
	
		start = Instant.now();
		startLong = start.toEpochMilli();
		System.out.println(Arrays.toString(mergeSortOptimize.sortArrayWithMergeSort(testArray)));
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println("Verbrauchte Zeit für Sortieren und darstellen mit optimierten MergeSort [ms]: " + (endLong-startLong));
		System.out.println();
		
		start = Instant.now();
		startLong = start.toEpochMilli();
		System.out.println(Arrays.toString(selectSort.sortArray(testArray)));
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println("Verbrauchte Zeit für Sortieren und darstellen mit SelectSort [ms]: " + (endLong-startLong));
	}
}
