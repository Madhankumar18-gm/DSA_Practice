import java.util.Stack;

/**
 * Problem 8: Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element.
 */
public class MinStack {
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    // Naive O(N) scan for minimum element
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int val : stack) {
            min = Math.min(min, val);
        }
        return min;
    }
}
