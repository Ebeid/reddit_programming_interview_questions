package queues;

import java.util.Stack;

// http://stackoverflow.com/questions/7134129/stack-with-find-min-find-max-more-efficient-than-on
public class StackWithMinMax extends Stack<Integer> {
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public StackWithMinMax() {
        minStack = new Stack<Integer>();    
        maxStack = new Stack<Integer>();    
    }

    public void push(int value){
        if (value <= min()) { // Note the '=' sign here
            minStack.push(value);
        }

        if (value >= max()) {
            maxStack.push(value);
        }

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            minStack.pop();         
        }

        if (value == max()) {
            maxStack.pop();         
        }

        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }

    public int max() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxStack.peek();
        }
    }
    
    public void printStack() {
    	for (int i = 0; i < super.size(); i ++) {
    		System.out.print(super.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public void printMinStack() {
    	for (int i = 0; i < minStack.size(); i ++) {
    		System.out.print(minStack.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public void printMaxStack() {
    	for (int i = 0; i < maxStack.size(); i ++) {
    		System.out.print(maxStack.get(i) + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	StackWithMinMax stackWithMinMax = new StackWithMinMax();
    	stackWithMinMax.push(3);
    	stackWithMinMax.push(2);
    	stackWithMinMax.push(1);
    	stackWithMinMax.push(4);
    	stackWithMinMax.push(5);
    	
    	stackWithMinMax.printStack();
    	stackWithMinMax.printMinStack();
    	stackWithMinMax.printMaxStack();
    	
    	System.out.println(stackWithMinMax.min());
    }
}