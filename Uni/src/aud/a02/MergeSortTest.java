package aud.a02;

import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static aud.a02.testArrays.FileIntArray.FileToIntArray;

@RunWith(Parameterized.class)
public class MergeSortTest {

	private Comparator<Integer> comparator;
	private Instant start, end;
	private String testArrayFile;

	public MergeSortTest(String testArrayFile) {
		this.testArrayFile = testArrayFile;
	}

	@Before
	public void setUp() {
		comparator = new IntegerComparator();
	}

	@Parameters
	public static List<Object> data() {
		return generateTestArrayList();
	}

	@Test
	public void testMergeSort() {
		Integer[] array = convertIntToInteger(FileToIntArray(testArrayFile));
		long leadtime = 0;
		for (int i = 0; i < 100; i++) {
			start = Instant.now();
			MergeSortOptimizeObject.sort(array, comparator);
			end = Instant.now();
			leadtime = leadtime + neededTime();
		}
		leadtime = leadtime / 100;

		// System.out.println(Arrays.toString(array));
		System.out.println("Aktuelles Testarray: " + testArrayFile);
		System.out.println("Verbrauchte Zeit für Sortieren mit optimiertem MergeSort [ms]: " + leadtime + "\n");
		Assert.assertEquals(true, isSorted(array));
	}

	private boolean isSorted(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			if (comparator.compare(array[i - 1], array[i]) > 0) {
				return false;
			}
		}
		return true;
	}

	private Integer[] convertIntToInteger(int[] array) {
		Integer[] objArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			objArray[i] = new Integer(array[i]);
		}
		return objArray;
	}

	private long neededTime() {
		return end.toEpochMilli() - start.toEpochMilli();
	}

	private static List<Object> generateTestArrayList() {
		return Arrays.asList(new Object[] { "./src/aud/a02/testArrays/Rand10_2", "./src/aud/a02/testArrays/Rand10_2",
				"./src/aud/a02/testArrays/Rand100_1", "./src/aud/a02/testArrays/Rand100_2",
				"./src/aud/a02/testArrays/Rand1000_1", "./src/aud/a02/testArrays/Rand1000_2",
				"./src/aud/a02/testArrays/Rand10000_1", "./src/aud/a02/testArrays/Rand10000_2",
				"./src/aud/a02/testArrays/Rand100000_1", "./src/aud/a02/testArrays/Rand100000_2",
				"./src/aud/a02/testArrays/Rand20_1", "./src/aud/a02/testArrays/Rand20_2",
				"./src/aud/a02/testArrays/Rand200_1", "./src/aud/a02/testArrays/Rand200_2",
				"./src/aud/a02/testArrays/Rand50_1", "./src/aud/a02/testArrays/Rand50_2",
				"./src/aud/a02/testArrays/Rand500_1", "./src/aud/a02/testArrays/Rand500_2",
				"./src/aud/a02/testArrays/Sort10_1", "./src/aud/a02/testArrays/Sort100_1",
				"./src/aud/a02/testArrays/Sort1000_1", "./src/aud/a02/testArrays/Sort10000_1",
				"./src/aud/a02/testArrays/Sort100000_1", "./src/aud/a02/testArrays/Sort20_1",
				"./src/aud/a02/testArrays/Sort200_1", "./src/aud/a02/testArrays/Sort50_1",
				"./src/aud/a02/testArrays/Sort500_1", });
	}
}
