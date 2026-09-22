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
            peek();
            return outStack.pop();
        }

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
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        System.out.println("Pop:   " + q.pop());   // 10
        q.push(30);
        System.out.println("Peek:  " + q.peek());  // 20
        System.out.println("Empty? " + q.empty()); // false
    }
}
