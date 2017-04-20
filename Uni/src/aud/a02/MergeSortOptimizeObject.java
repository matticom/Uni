package aud.a02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import aud.a01.SelectSort;
import java.time.Instant;

public class MergeSortOptimizeObject<T> {
	private List<T> auxArray;
	private List<T> array;
	private Comparator<? super T> comparator;
	
		
	private MergeSortOptimizeObject(List<T> array, Comparator<? super T> comparator) {
		this.array = array;
		this.comparator = comparator;
		auxArray = new ArrayList<T>(array.size());
		int r = array.size()-1;
		mergeSort(0, r);
	}

	public static <T> void sort(List<T> list, Comparator<? super T> comparator){
		MergeSortOptimizeObject<T> mergeSortOptimizeObject = new MergeSortOptimizeObject<T>(list, comparator);
		
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
			if ((comparator.compare(auxArray.get(l), auxArray.get(r))) >= 0){//auxArray[l] >= auxArray[r]) {
				array.set(arrayIdx++, auxArray.get(r--));
			} else {
				array.set(arrayIdx++, auxArray.get(l++));
			}
		}
		array.set(arrayIdx, auxArray.get(r));
	}
	
	private void copyToAuxArray(int l, int m, int r) {
		System.out.println(array.get(0));
//		auxArray.set(0, );
		for(int i = l; i <= m; i++) {
			auxArray.set(i, array.get(i));
		}
		int j = m+1;
		for(int i = r; i > m; i--) {
			auxArray.set(i, array.get(j++));
		}
	}
	
	public static void main(String[] args) {
		Instant start, end;
		Long startLong, endLong;
		Random random = new Random();
		int[] testArray = new int[100];
		for(int i=0; i<100; i++) {
			testArray[i] = random.nextInt(100)-50;
		}
		
		List<Integer> list = Arrays.stream(testArray).boxed().collect(Collectors.toList());
				
		
		
		MergeSortOptimize mergeSortOptimize = new MergeSortOptimize();
		SelectSort selectSort = new SelectSort();
		
//		start = Instant.now();
//		startLong = start.toEpochMilli();
//		System.out.println(Arrays.toString(selectSort.sortArray(testArray)));
//		end = Instant.now();
//		endLong = end.toEpochMilli();
//		System.out.println("Verbrauchte Zeit für Sortieren und darstellen mit SelectSort [ms]: " + (endLong-startLong));
//		System.out.println();
//		
//		start = Instant.now();
//		startLong = start.toEpochMilli();
//		System.out.println(Arrays.toString(mergeSortOptimize.sortArrayWithMergeSort(testArray)));
//		end = Instant.now();
//		endLong = end.toEpochMilli();
//		System.out.println("Verbrauchte Zeit für Sortieren und darstellen mit optimierten MergeSort [ms]: " + (endLong-startLong));
		
		start = Instant.now();
		startLong = start.toEpochMilli();
		MergeSortOptimizeObject.sort(list, new IntegerComparator());
		System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(", ")));
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println("Verbrauchte Zeit für Sortieren und darstellen mit optimierten MergeSort mit Objekten [ms]: " + (endLong-startLong));
	}
}
