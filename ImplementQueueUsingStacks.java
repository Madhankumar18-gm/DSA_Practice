import java.util.Stack;

/**
 * Problem 11: Implement Queue using Stacks
 * 
 * Implement a first-in first-out (FIFO) queue using two stacks.
 * 
 * Time Complexity: Amortized O(1) for push, pop, peek, empty.
 * Space Complexity: O(N) for storing queue elements.
 */
public class ImplementQueueUsingStacks {
    public static class MyQueue {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public MyQueue() { }

        /** Pushes element x to the back of queue. O(1) */
        public void push(int x) {
            inStack.push(x);
        }

        /** Removes and returns element from front of queue. Amortized O(1) */
        public int pop() {
            if (empty()) throw new IllegalStateException("Queue is empty");
            peek();
            return outStack.pop();
        }

        /** Gets the front element. Amortized O(1) */
        public int peek() {
            if (empty()) throw new IllegalStateException("Queue is empty");
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        /** Returns whether the queue is empty. O(1) */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ImplementQueueUsingStacks Execution Suite ===");
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println("Front Element: " + q.peek()); // 10
        System.out.println("Popped:        " + q.pop());  // 10
        System.out.println("New Front:     " + q.peek()); // 20
        System.out.println("Is Empty?      " + q.empty());// false
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
