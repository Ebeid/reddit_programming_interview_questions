package stacks;

// http://www.algolist.net/Data_structures/Stack/Array-based_implementation
public class ArrayBasedStack {
	private int top;
	private int[] storage;

	ArrayBasedStack(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException(
					"Stack's capacity must be positive");
		storage = new int[capacity];
		top = -1;
	}

	void push(int value) {
		if (top == storage.length)
			throw new StackException("Stack's underlying storage is overflow");
		top++;
		storage[top] = value;
	}

	int peek() {
		if (top == -1)
			throw new StackException("Stack is empty");
		return storage[top];
	}

	void pop() {
		if (top == -1)
			throw new StackException("Stack is empty");
		top--;
	}

	boolean isEmpty() {
		return (top == -1);
	}

	public class StackException extends RuntimeException {
		public StackException(String message) {
			super(message);
		}
	}
	
	public void print() {
		for (int i = 0; i <= top; i ++) {
			System.out.println(storage[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayBasedStack stack = new ArrayBasedStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.print();
		
		stack.pop();
		stack.pop();
		
		stack.print();
		
		System.out.println(stack.peek());
	}
}