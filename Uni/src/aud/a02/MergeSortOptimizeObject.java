package aud.a02;

import java.util.Comparator;

public class MergeSortOptimizeObject<T> {
	private Object[] auxArray;
	private T[] array;
	private Comparator<T> comparator;
	
		
	private MergeSortOptimizeObject(T[] array, Comparator<T> comparator) {
		this.array = array;
		this.comparator = comparator;
		int r = array.length-1;
		auxArray = new Object[array.length];
		
		mergeSort(0, r);
	}
	
	public static <T> void sort(T[] array, Comparator<T> comparator){
		new MergeSortOptimizeObject<T>(array, comparator);
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
			if ((comparator.compare((T)auxArray[l], (T)auxArray[r])) >= 0) {
				array[arrayIdx++] = (T)auxArray[r--];
			} else {
				array[arrayIdx++] = (T)auxArray[l++];
			}
		}
		array[arrayIdx] = (T)auxArray[r];
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
}
