package aud.a02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import aud.a01.SelectSort;
import java.time.Instant;

public class MergeSortOptimizeObject<T> {
	private Object[] auxArray;
	private T[] array;
	private Comparator<T> comparator;
	
		
	private MergeSortOptimizeObject(T[] array, Comparator<T> comparator) {
		// Initialisierung der Objektproperties
		this.array = array;
		this.comparator = comparator;
		int r = array.length-1;
		auxArray = new Object[r+1];
		
		// Algorithmusstart
		mergeSort(0, r);
	}
	
	// Statische Aufrufmethode zum Sortieren mit typisierten Array und typisierten Komparator 
	public static <T> void sort(T[] array, Comparator<T> comparator){
		new MergeSortOptimizeObject<T>(array, comparator);
	}
		
	// rekursive Methode zum Zerlegen und zusammen mischen des Arrays 
	private void mergeSort(int l, int r) {
		int m;
		// Abbruchbedingung: solange rechter und linker Index nicht gleich
		if (l < r) {
			m = (l+r) / 2; 		// Mitte des Arrays
			mergeSort(l, m);	// rekursiver Aufruf 1. Hälfte des Arrays
			mergeSort(m+1, r);	// rekursiver Aufruf 2. Hälfte des Arrays
			merge(l, m, r);		// beide Hälften zusammen mischen
		}
	}
	
	private void merge(int l, int m, int r) {
		// 	beide Arrayhälften in Hilfsarray kopieren
		//  Optimierte Variante: rechte Hälfte wird in umgedrehter Reihenfolge
		// 	ins Hilfsarray kopiert
		copyToAuxArray(l, m, r);
		//	Zeiger auf das zu sortierende Array auf linke Index setzen
		int arrayIdx = l;
		//  Optimierte Variante: linker und rechter Indexzeiger bewegen sich
		//	aufeinander zu bis l und r den gleichen Index haben 
		while( l != r ) {
			//	mit Komparator vergleichen, ob rechter oder linker Wert kleiner ist
			//	downcast Object zu T, da compare Parametertyp T verlangt
			if ((comparator.compare((T)auxArray[l], (T)auxArray[r])) >= 0) {
				//	Wenn rechter Wert kleiner ist: rechte Werte ins Hauptarray
				//	kopieren, arrayIndex 1 erhöhen und rechten auxArrayIndex 
				//	um 1 verringern
				array[arrayIdx++] = (T)auxArray[r--];
			} else {
				//	Wenn linker Wert kleiner ist: linke Werte ins Hauptarray
				//	kopieren, arrayIndex 1 erhöhen und linken auxArrayIndex 
				//	um 1 erhöhen
				array[arrayIdx++] = (T)auxArray[l++];
			}
		}
		//	am Ende den Wert beim r=l Index ins Hauptarray kopieren
		array[arrayIdx] = (T)auxArray[r];
	}
	
	private void copyToAuxArray(int l, int m, int r) {
		//	linke Hälfte vom Hauptarray 1:1 ins Hilfsarray kopieren
		for(int i = l; i <= m; i++) {
			auxArray[i] = array[i];
		}
		int j = m+1;
		//	rechte Hälfte vom Hauptarray in umgedrehter Reihenfolge
		//	ins Hilfsarray kopieren
		for(int i = r; i > m; i--) {
			auxArray[i] = array[j++];
		}
	}
	
	public static void main(String[] args) {
		
		final int ELEMENTS = 100000;
		
		Instant start, end;
		Long startLong, endLong;
		Random random = new Random();
		int[] testArraySelectSort = new int[ELEMENTS];
		int[] testArrayMergeSort = new int[ELEMENTS];
		Integer[] objectTestArrayMergeSort = new Integer[ELEMENTS];
		
		for(int i=0; i<ELEMENTS; i++) {
			int randomNumber = random.nextInt(ELEMENTS) - ELEMENTS/2;
			testArraySelectSort[i] = randomNumber;
			testArrayMergeSort[i] = randomNumber;
			objectTestArrayMergeSort[i] = new Integer(randomNumber);
		}
						
		MergeSortOptimize mergeSortOptimize = new MergeSortOptimize();
		SelectSort selectSort = new SelectSort();
		
		start = Instant.now();
		startLong = start.toEpochMilli();
		MergeSortOptimizeObject.sort(objectTestArrayMergeSort, new IntegerComparator());
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println(Arrays.toString(objectTestArrayMergeSort));
		System.out.println("Verbrauchte Zeit für Sortieren mit optimierten MergeSort mit Objekten [ms]: " + (endLong-startLong) + "\n");
			
		start = Instant.now();
		startLong = start.toEpochMilli();
		mergeSortOptimize.sortArrayWithMergeSort(testArrayMergeSort);
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println(Arrays.toString(testArrayMergeSort));
		System.out.println("Verbrauchte Zeit für Sortieren mit optimierten MergeSort [ms]: " + (endLong-startLong) + "\n");
				
		start = Instant.now();
		startLong = start.toEpochMilli();
		selectSort.sortArray(testArraySelectSort);
		end = Instant.now();
		endLong = end.toEpochMilli();
		System.out.println(Arrays.toString(testArraySelectSort));
		System.out.println("Verbrauchte Zeit für Sortieren mit SelectSort [ms]: " + (endLong-startLong) + "\n");
	}
}
