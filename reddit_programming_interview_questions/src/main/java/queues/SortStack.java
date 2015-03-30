package queues;

import java.util.Stack;

// http://stackoverflow.com/questions/24768011/write-a-program-to-sort-a-stack-in-ascending-order
public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> s) {
		if (s.isEmpty()) {
			return s;
		}
		int pivot = s.pop();

		// partition
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		while (!s.isEmpty()) {
			int y = s.pop();
			if (y < pivot) {
				left.push(y);
			} else {
				right.push(y);
			}
		}
		sort(left);
		sort(right);

		// merge
		Stack<Integer> tmp = new Stack<Integer>();
		while (!right.isEmpty()) {
			tmp.push(right.pop());
		}
		tmp.push(pivot);
		while (!left.isEmpty()) {
			tmp.push(left.pop());
		}
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}

		return s;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		
		for (int i = 0; i < stack.size(); i ++) {
			System.out.println(stack.get(i));
		}
		System.out.println();
		
		Stack<Integer> sortedStack = sort(stack);
		for (int i = 0; i < sortedStack.size(); i ++) {
			System.out.println(sortedStack.get(i));
		}
		System.out.println();
	}
}
