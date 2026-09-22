import java.util.Stack;

/**
 * Problem 11: Implement Queue using Stacks
 * 
 * Implement a first-in first-out (FIFO) queue using two stacks (inStack & outStack).
 */
public class ImplementQueueUsingStacks {
    public static class MyQueue {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public MyQueue() { }

        // Amortized O(1) Push
        public void push(int x) {
            inStack.push(x);
        }

        // Amortized O(1) Pop
        public int pop() {
            peek();
            return outStack.pop();
        }

        // Amortized O(1) Peek
        public int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek());
    }
}
