package aud.a04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
	private HashTable<String, String> hTable;
	
	@Before
	public void setUp() {
		hTable = new HashTable<String, String>(20);
		hTable.put("eins", "value eins");
		hTable.put("zwei", "value zwei");
		hTable.put("drei", "value drei");
		hTable.put("vier", "value vier");
		hTable.put("fünf", "value fünf");
		hTable.put("sechs", "value sechs");
		hTable.put("sieben", "value sieben");
		hTable.put("acht", "value acht");
		hTable.put("neun", "value neun");
	}
	
	@Test
	public void testPutInNewKeyValuePair() {
		hTable.printHashTable();
		Assert.assertEquals("value sechs", hTable.get("sechs"));
	}
	
	@Test
	public void testRemoveKey() {
		String retValue = hTable.remove("sechs");
		String retValue2 = hTable.remove("sec");
		hTable.printHashTable();
		Assert.assertEquals(null, hTable.get("sechs"));
		Assert.assertEquals("value sechs", retValue);
		Assert.assertEquals(null, retValue2);
	}

	@Test
	public void testOverrideKey() {
		String retValue = hTable.put("acht", "neue acht");
		hTable.printHashTable();
		Assert.assertEquals("value acht", retValue);
	}
	
	@Test
	public void testOccupationExceed() {
		hTable.printCurrentOccupancy();
		hTable.put("zehn", "value zehn");
		System.out.println("\nNach Einfügen eines neuen Schlüssels und der damit erzwungenen Erweiterung des Arrays: ");
		hTable.printCurrentOccupancy();
		hTable.printHashTable();
		Assert.assertEquals(55, hTable.getCurrentArraySize());
	}
}
