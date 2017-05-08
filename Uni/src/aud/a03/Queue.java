package aud.a03;

import java.util.Arrays;

public class Queue <T> {

	protected int firstFreeIndex;
	protected int firstUsedIndex;
	protected Object[] array;
	protected int size;
	protected final int LAST_ARRAY_INDEX;
	protected boolean queueIsFull;
	protected boolean queueIsEmpty;
	
	public Queue(int size) {
		this.size = size;
		array = new Object[size];
		firstFreeIndex = 0;
		firstUsedIndex = 0;
		LAST_ARRAY_INDEX = size-1;
		queueIsFull = false;
		queueIsEmpty = true;
	}
	
	public Queue() {
		this(10);
	}
	
	// Enqueue-Methode: Laufzeit in O-Notation beträgt o(1), da alle Anweisungen der Methode o(1) haben
	public void enqueue(T obj) throws QueueOverflow {
		if (queueIsFull) {
			throw new QueueOverflow("Queue ist voll");
		}
		// Queue voll, wenn beide Zeiger nach enqueue auf gleichen Index zeigen 
		// (Modulo-Funktion um Array als Ringspeicher zu betrachten)
		queueIsFull = (firstUsedIndex == (firstFreeIndex+1) % size);
		array[firstFreeIndex] = (T) obj;
		firstFreeIndex = ++firstFreeIndex % size;
		queueIsEmpty = false;
	}
	
	// Dequeue-Methode: Laufzeit in O-Notation beträgt o(1), da alle Anweisungen der Methode o(1) haben 
	public T dequeue() throws QueueUnderflow {
		if (queueIsEmpty) {
			throw new QueueUnderflow("Queue leer");
		}
		// Queue leer, wenn beide Zeiger nach dequeue auf gleichen Index zeigen 
		// (Modulo-Funktion um Array als Ringspeicher zu betrachten)
		queueIsEmpty = (firstFreeIndex == (firstUsedIndex+1) % size);
		T dequeuedObject = (T) array[firstUsedIndex];
		array[firstUsedIndex] = null;
		firstUsedIndex = ++firstUsedIndex % size;
		queueIsFull = false;
		return dequeuedObject;
	}
	
	public void printQueue() {
		System.out.println(Arrays.toString(array));
	}
}
