package aud.a04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
		
	private HashTable<String, String> hTable;
	
	/**
	 * Initialisierung und Befüllung der HashTable
	 * (wird automatisch vor jedem einzelnen Test durchgeführt)
	 */
	
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
	
	/**
	 * Test, ob neues Schlüssel-Wert-Paar eingefügt wurde bei setUp()
	 * -> Methode put(...) wird getestet (Stichprobentest)
	 */
	
	@Test
	public void testPutNewKeyValuePair() {
		System.out.println("Put Aktionstest (neue Werte in HashTable):");
		hTable.printHashTable();
		Assert.assertEquals("value sechs", hTable.get("sechs"));
	}
	
	/**
	 * Test, ob Schlüssel-Wert-Paar nur löscht wird, wenn Schlüssel
	 * vorhanden ist, und sonst im anderen Fall null zurück gibt
	 */
	
	@Test
	public void testRemoveKey() {
		System.out.println("Remove Aktionstest (vorhandener / nicht vorhandener Key gelöscht):");
		String retValue = hTable.remove("sechs");
		String retValue2 = hTable.remove("sec");
		hTable.printHashTable();
		Assert.assertEquals(null, hTable.get("sechs"));
		Assert.assertEquals("value sechs", retValue);
		Assert.assertEquals(null, retValue2);
	}

	/**
	 * Test, ob Schlüssel-Wert-Paar überschrieben wird und falls, dass
	 * der alte Value des überschriebenen Schlüssel zurückgegeben wird
	 */
	
	@Test
	public void testOverrideKey() {
		System.out.println("Put überschreiben-Aktionstest (value acht wird überschrieben):");
		String retValue = hTable.put("acht", "neue acht");
		hTable.printHashTable();
		Assert.assertEquals("value acht", retValue);
		Assert.assertEquals("neue acht", hTable.get("acht"));
	}
	
	/**
	 * Test, ob maximaler Belegungsgrad, wie definiert, erreicht wird und automatisch
	 * das Array vergrößert wird um den definierten Faktor 
	 */
	
	@Test
	public void testOccupationExceed() {
		System.out.println("Erweiterung-Aktionstest (bei überschrittener Auslastung der HashTable):");
		hTable.printCurrentOccupancy();
		hTable.put("zehn", "value zehn");
		System.out.println("\nNach Einfügen eines neuen Schlüssels und der damit erzwungenen Erweiterung des Arrays: ");
		hTable.printCurrentOccupancy();
		hTable.printHashTable();
		Assert.assertEquals(55, hTable.getCurrentArraySize());
	}
}
