import java.util.Stack;

/**
 * Problem 11: Implement Queue using Stacks
 * 
 * Implement a first-in first-out (FIFO) queue using two stacks.
 */
public class ImplementQueueUsingStacks {
    public static class MyQueue {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public MyQueue() { }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (empty()) throw new IllegalStateException("Queue is empty");
            peek();
            return outStack.pop();
        }

        public int peek() {
            if (empty()) throw new IllegalStateException("Queue is empty");
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
        MyQueue q = new MyQueue();
        System.out.println("Is Empty: " + q.empty());
    }
}
