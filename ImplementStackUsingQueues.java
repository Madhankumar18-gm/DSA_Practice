import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 12: Implement Stack using Queues
 * 
 * Implement a last-in-first-out (LIFO) stack using a single queue.
 */
public class ImplementStackUsingQueues {
    public static class MyStack {
        private Queue<Integer> queue = new LinkedList<>();

        public MyStack() { }

        // Single Queue Push by rotating elements
        public void push(int x) {
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.poll());
                sz--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top());
    }
}
