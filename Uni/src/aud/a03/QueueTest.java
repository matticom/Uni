package aud.a03;

public class QueueTest {

	public static void main(String[] args) throws QueueOverflow, QueueUnderflow {
//		Queue<Integer> queue = new Queue<Integer>(3);
//		queue.enqueue(new Integer(1));
//		queue.printQueue();
//		queue.enqueue(new Integer(2));
//		queue.printQueue();
//		queue.dequeue();
//		queue.printQueue();
//		queue.dequeue();
//		queue.printQueue();
//		queue.enqueue(new Integer(3));
//		queue.printQueue();
//		queue.enqueue(new Integer(4));
//		queue.printQueue();
//		queue.dequeue();
//		queue.printQueue();
//		queue.enqueue(new Integer(5));
//		queue.printQueue();
//		queue.enqueue(new Integer(6));
//		queue.printQueue();
//		queue.dequeue();
//		queue.printQueue();
//		queue.dequeue();
//		queue.printQueue();
//		queue.dequeue();
//		queue.printQueue();
		Queue<Integer> queue = new Queue<Integer>(1);
		queue.enqueue(new Integer(1));
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
	}

}
