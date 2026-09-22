import java.util.Stack;

/**
 * Problem 11: Implement Queue using Stacks
 * 
 * Implement a first-in first-out (FIFO) queue using two stacks.
 */
public class ImplementQueueUsingStacks {
    public static class MyQueue {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();

        public MyQueue() { }

        public void push(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek()); // 1
    }
}
