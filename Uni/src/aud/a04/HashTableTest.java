package aud.a04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
		
	private HashTable<String, String> hTable;
	
	/**
	 * Initialisierung und Bef�llung der HashTable
	 * (wird automatisch vor jedem einzelnen Test durchgef�hrt)
	 */
	
	@Before
	public void setUp() {
		hTable = new HashTable<String, String>(20);
		hTable.put("eins", "value eins");
		hTable.put("zwei", "value zwei");
		hTable.put("drei", "value drei");
		hTable.put("vier", "value vier");
		hTable.put("f�nf", "value f�nf");
		hTable.put("sechs", "value sechs");
		hTable.put("sieben", "value sieben");
		hTable.put("acht", "value acht");
		hTable.put("neun", "value neun");
	}
	
	/**
	 * Test, ob neues Schl�ssel-Wert-Paar eingef�gt wurde bei setUp()
	 * -> Methode put(...) wird getestet (Stichprobentest)
	 */
	
	@Test
	public void testPutNewKeyValuePair() {
		System.out.println("Put Aktionstest (neue Werte in HashTable):");
		hTable.printHashTable();
		Assert.assertEquals("value sechs", hTable.get("sechs"));
	}
	
	/**
	 * Test, ob Schl�ssel-Wert-Paar nur l�scht wird, wenn Schl�ssel
	 * vorhanden ist, und sonst im anderen Fall null zur�ck gibt
	 */
	
	@Test
	public void testRemoveKey() {
		System.out.println("Remove Aktionstest (vorhandener / nicht vorhandener Key gel�scht):");
		String retValue = hTable.remove("sechs");
		String retValue2 = hTable.remove("sec");
		hTable.printHashTable();
		Assert.assertEquals(null, hTable.get("sechs"));
		Assert.assertEquals("value sechs", retValue);
		Assert.assertEquals(null, retValue2);
	}

	/**
	 * Test, ob Schl�ssel-Wert-Paar �berschrieben wird und falls, dass
	 * der alte Value des �berschriebenen Schl�ssel zur�ckgegeben wird
	 */
	
	@Test
	public void testOverrideKey() {
		System.out.println("Put �berschreiben-Aktionstest (value acht wird �berschrieben):");
		String retValue = hTable.put("acht", "neue acht");
		hTable.printHashTable();
		Assert.assertEquals("value acht", retValue);
		Assert.assertEquals("neue acht", hTable.get("acht"));
	}
	
	/**
	 * Test, ob maximaler Belegungsgrad, wie definiert, erreicht wird und automatisch
	 * das Array vergr��ert wird um den definierten Faktor 
	 */
	
	@Test
	public void testOccupationExceed() {
		System.out.println("Erweiterung-Aktionstest (bei �berschrittener Auslastung der HashTable):");
		hTable.printCurrentOccupancy();
		hTable.put("zehn", "value zehn");
		System.out.println("\nNach Einf�gen eines neuen Schl�ssels und der damit erzwungenen Erweiterung des Arrays: ");
		hTable.printCurrentOccupancy();
		hTable.printHashTable();
		Assert.assertEquals(55, hTable.getCurrentArraySize());
	}
}
