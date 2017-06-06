package aud.a03;

import java.util.Arrays;

public class Queue <T> {

	protected int firstFreeIndex;
	protected int firstUsedIndex;
	protected Object[] array;
	protected int queueSize;
	protected boolean queueIsFull;
	protected boolean queueIsEmpty;
	
	public Queue(int queueSize) {
		this.queueSize = queueSize;
		array = new Object[queueSize];
		firstFreeIndex = 0;
		firstUsedIndex = 0;
		queueIsFull = false;
		queueIsEmpty = true;
	}
	
	// Enqueue-Methode: Laufzeit in O-Notation beträgt o(1), 
	// da alle Anweisungen der Methode o(1) haben
	public void enqueue(T obj) throws QueueOverflow {
		if (queueIsFull) {
			throw new QueueOverflow("Queue ist voll");
		}
		// Queue ist voll, wenn beide Zeiger nach enqueue auf gleichen Index zeigen 
		// (Modulo-Funktion um Array als Ringspeicher zu verwenden)
		queueIsFull = (firstUsedIndex == (firstFreeIndex+1) % queueSize);
		array[firstFreeIndex] = (T) obj;
		firstFreeIndex = ++firstFreeIndex % queueSize;
		queueIsEmpty = false;
	}
	
	// Dequeue-Methode: Laufzeit in O-Notation beträgt o(1), 
	// da alle Anweisungen der Methode o(1) haben 
	public T dequeue() throws QueueUnderflow {
		if (queueIsEmpty) {
			throw new QueueUnderflow("Queue ist leer");
		}
		// Queue ist leer, wenn beide Zeiger nach dequeue auf gleichen Index zeigen 
		// (Modulo-Funktion um Array als Ringspeicher zu verwenden)
		queueIsEmpty = (firstFreeIndex == (firstUsedIndex+1) % queueSize);
		T dequeuedObject = (T) array[firstUsedIndex];
		array[firstUsedIndex] = null;
		firstUsedIndex = ++firstUsedIndex % queueSize;
		queueIsFull = false;
		return dequeuedObject;
	}
	
	public boolean isNotEmpty() {
		return !queueIsEmpty;
	}
	
	
	public void printQueue() {
		System.out.println(Arrays.toString(array));
	}
}
