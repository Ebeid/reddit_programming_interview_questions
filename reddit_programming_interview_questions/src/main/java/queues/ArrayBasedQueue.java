package queues;

// https://gist.github.com/mycodeschool/7331785
public class ArrayBasedQueue {
	private int front, rear;
	private int[] storage;

	ArrayBasedQueue(int capacity) {
		storage = new int[capacity];
		front = -1;
		rear = -1;
	}

	// To check wheter Queue is empty or not
	boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	// To check whether Queue is full or not
	boolean isFull() {
		return (rear + 1) % storage.length == front ? true : false;
	}

	// Inserts an element in queue at rear end
	void enqueue(int x) {
		if (isFull()) {
			System.out.println("Error: Queue is Full");
			return;
		}
		if (isEmpty()) {
			front = rear = 0;
		} else {
			rear = (rear + 1) % storage.length;
		}

		storage[rear] = x;
	}

	// Removes an element in Queue from front end.
	void dequeue() {
		if (isEmpty()) {
			System.out.println("Error: Queue is Empty");
			return;
		} else if (front == rear) {
			rear = front = -1;
		} else {
			front = (front + 1) % storage.length;
		}
	}

	// Returns element at front of queue.
	int front() {
		if (front == -1) {
			System.out.println("Error: cannot return front from empty queue");
			return -1;
		}
		
		return storage[front];
	}

	/*
	 * Printing the elements in queue from front to rear. This function is only
	 * to test the code. This is not a standard function for Queue
	 * implementation.
	 */
	void print()
	{
		// Finding number of elements in queue  
		int count = (rear + storage.length - front) % storage.length + 1;
		for(int i = 0; i <count; i++)
		{
			int index = (front+i) % storage.length; // Index of element while travesing circularly from front
			System.out.println(storage[index] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayBasedQueue arrayBasedQueue = new ArrayBasedQueue(5);
		arrayBasedQueue.enqueue(1);
		arrayBasedQueue.enqueue(2);
		arrayBasedQueue.enqueue(3);
		
		arrayBasedQueue.print();
		
		arrayBasedQueue.dequeue();
		
		arrayBasedQueue.print();
		
		System.out.println(arrayBasedQueue.front());
	}
}