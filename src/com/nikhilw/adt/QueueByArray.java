package com.nikhilw.adt;

/**
 * @author nikhil
 */
public class QueueByArray {
	private final int INITIAL_CAPACITY = 5;
	private final int[] container;
	private final int size;

	private int front = -1;
	private int rear = -1;

	public QueueByArray() {
		size = INITIAL_CAPACITY;
		container = new int[INITIAL_CAPACITY];
	}

	public QueueByArray(int initSize) {
		size = initSize;
		container = new int[initSize];
	}

	private boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	private int getNextIndex() {
		return (rear + 1) % size;
	}

	private int getPrevIndex() {
		return (front + 1) % size;
	}

	public void offer(int num) {
		if (getNextIndex() == front) {
			throw new IllegalStateException("Full..");
		} else if (isEmpty()) {
			front++;
			rear++;
			container[rear] = num;
		} else {
			rear = getNextIndex();
			container[rear] = num;
		}
	}

	public int poll() {
		int polled;

		if (isEmpty()) {
			throw new IllegalStateException("Queue empty..");
		} else if (front == rear) {
			polled = container[front];
			container[front] = 0; // Effective java! although these are ints, best to remember it anyway.
			front = -1;
			rear = -1;
		} else {
			polled = container[front];
			container[front] = 0; // Effective java! although these are ints, best to remember it anyway.
			front = getPrevIndex();
		}

		return polled;
	}

	public static void main(String[] args) {
		QueueByArray queue = new QueueByArray();

		queue.offer(3);
		queue.offer(1);
		queue.offer(4);
		queue.offer(1);
		queue.offer(5);

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

		queue.offer(3);
		queue.offer(1);
		queue.offer(4);
		queue.offer(1);
		queue.offer(5);
		queue.offer(9);
	}
}
