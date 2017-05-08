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
	
	// Queue-Methode: Laufzeit in O-Notation beträgt o(1), da alle Anweisungen der Methode o(1) haben
	public void enqueue(T obj) throws QueueOverflow {
		if (queueIsFull) {
			throw new QueueOverflow("Queue ist voll");
		}
		boolean noMoreSpaceAtArrayBoundary = (firstFreeIndex == LAST_ARRAY_INDEX && firstUsedIndex == 0);
		boolean noMoreSpaceWithinArray = (firstFreeIndex == firstUsedIndex-1);
		queueIsFull = noMoreSpaceAtArrayBoundary || noMoreSpaceWithinArray;
		array[firstFreeIndex] = (T) obj;
		firstFreeIndex = ++firstFreeIndex % size;
		queueIsEmpty = false;
	}
	
	// Dequeue-Methode: Laufzeit in O-Notation beträgt o(1), da alle Anweisungen der Methode o(1) haben 
	public T dequeue() throws QueueUnderflow {
		if (queueIsEmpty) {
			throw new QueueUnderflow("Queue leer");
		}
		boolean noMoreElementAtArrayBoundary = (firstUsedIndex == LAST_ARRAY_INDEX && firstFreeIndex == 0);
		boolean noMoreElementWithinArray = (firstUsedIndex == firstFreeIndex-1);
		queueIsEmpty = noMoreElementAtArrayBoundary || noMoreElementWithinArray;
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
