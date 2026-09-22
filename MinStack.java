import java.util.Stack;

/**
 * Problem 8: Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Time Complexity: O(1) for all operations (push, pop, top, getMin).
 * Space Complexity: O(N) where N is number of elements pushed.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /** Pushes element onto stack. O(1) time */
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    /** Removes element on top. O(1) time */
    public void pop() {
        if (stack.isEmpty()) return;
        int popped = stack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }
    
    /** Gets top element. O(1) time */
    public int top() {
        if (stack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack.peek();
    }
    
    /** Retrieves minimum element. O(1) time */
    public int getMin() {
        if (minStack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Get Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top:     " + minStack.top());
        System.out.println("Get Min: " + minStack.getMin());
    }
}
