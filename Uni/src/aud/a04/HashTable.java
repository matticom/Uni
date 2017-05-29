package aud.a04;

import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V> {

	protected Object[] array;
	protected int arraySize;
	protected Occupancy occupancy;
	protected final double ARRAY_EXTENSION_FACTOR = 2.75;
	protected KeyValuePair<K, V> existingKVPair;
	protected List<KeyValuePair<K, V>> bucketList;
	
	public HashTable(int arraySize) {
		this.arraySize = arraySize;
		array = new Object[arraySize];
		occupancy = new Occupancy(arraySize);
	}

	@Override
	public V put(K key, V value) {
		KeyValuePair<K, V> newKVPair = new KeyValuePair<K, V>(key, value);
		int keyIdx = hashFunction(key);
		if (anyBucketListAlreadyExistsAtArrayIndex(keyIdx)) {
			if (keyIsAlreadyInBucketList(key)) {
				bucketList.remove(existingKVPair);
				bucketList.add(newKVPair);
				return existingKVPair.getValue();
			}
		} else {
			bucketList = new LinkedList<KeyValuePair<K, V>>();
		}
		bucketList.add(newKVPair);
		occupancy.addKey();
		array[keyIdx] = bucketList;
		if (occupancy.maxOccupancyExceeded()) {
			extendArray();
		}
		return null;
	}
			
	@Override
	public V get(K key) {
		int keyIdx = hashFunction(key);
		if (anyBucketListAlreadyExistsAtArrayIndex(keyIdx)) {
			if (keyIsAlreadyInBucketList(key)) {
				return existingKVPair.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int keyIdx = hashFunction(key);
		if (anyBucketListAlreadyExistsAtArrayIndex(keyIdx)) {
			if (keyIsAlreadyInBucketList(key)) {
				bucketList.remove(existingKVPair);
				occupancy.removeKey();
				return existingKVPair.getValue();
			}
		}
		return null;
	}

	private int hashFunction(K key) {
		return Math.abs(key.hashCode() % arraySize);
	}
	
	private boolean anyBucketListAlreadyExistsAtArrayIndex(int idxKey) {
		bucketList = (List<KeyValuePair<K, V>>) array[idxKey];
		return (bucketList != null) ? true  : false;
	}
	
	private boolean keyIsAlreadyInBucketList(K key) {
		existingKVPair = getListEntry(bucketList, key);
		return (existingKVPair != null) ? true : false;
	}

	private KeyValuePair<K, V> getListEntry(List<KeyValuePair<K, V>> bucketList, K key) {
		for (KeyValuePair<K, V> entry : bucketList) {
			if (entry.getKey().equals(key)) {
				return entry;
			}
		}
		return null;
	}
	
	private void extendArray() {
		int oldArraySize = arraySize;
		Object[] oldArray = array;
		arraySize = (int)(ARRAY_EXTENSION_FACTOR * oldArraySize);
		array = new Object[arraySize];
		occupancy.extendArraySizeTo(arraySize);
		
		for (int i = 0; i < oldArraySize; i++) {
			List<KeyValuePair<K, V>> bucketList = (List<KeyValuePair<K, V>>) oldArray[i];
			if (bucketList != null) {
				for (int j = 0; j < bucketList.size(); j++) {
					KeyValuePair<K, V> entry = bucketList.get(j);
					put(entry.getKey(), entry.getValue());
				}
			}
		}
	}

	public void printHashTable() {
		System.out.println("{ ");
		for (int i = 0; i < arraySize; i++) {
			List<KeyValuePair<K, V>> bucketList = (List<KeyValuePair<K, V>>) array[i];
			System.out.print(" ( ");
			if (bucketList != null) {
				for (int j = 0; j < bucketList.size(); j++) {
					KeyValuePair<K, V> entry = bucketList.get(j);
					System.out.print(entry.toString());
					System.out.print(", ");
				}
			}
			System.out.println(" )");
		}
		System.out.println("}\n\n");
	}
	
	public int getCurrentArraySize() {
		return arraySize;
	}
	
	public void printCurrentOccupancy() {
		System.out.println(occupancy.toString());
	}
}
