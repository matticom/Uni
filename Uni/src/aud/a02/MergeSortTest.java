package aud.a02;

import java.time.Instant;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

	private Integer[] array;
	private Comparator<Integer> comparator;
	private Instant start, end;
	private Long startLong, endLong;
	
	@Before
	public void setUp() {
		array = new Integer[]{new Integer(3),new Integer(6),new Integer(1),new Integer(2),new Integer(4),new Integer(3),new Integer(6)};
		comparator = new IntegerComparator();
	}
	
	@Test
	public void testMergeSort() {
		start = Instant.now();
		MergeSortOptimizeObject.sort(array, comparator);
		end = Instant.now();
		
		startLong = start.toEpochMilli();
		endLong = end.toEpochMilli();
		System.out.println("Verbrauchte Zeit für Sortieren mit optimierten MergeSort mit Objekten [ms]: " + (endLong-startLong) + "\n");
		Assert.assertEquals(true, isSorted());
	}
	
	private boolean isSorted() {
		for(int i = 1; i < array.length; i++) {
			if (comparator.compare(array[i-1], array[i]) > 0) {
				return false;
			}
		}
		return true;
	}
}
