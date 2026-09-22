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

        public void push(int x) {
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.poll());
                sz--;
            }
        }

        public int pop() {
            if (empty()) throw new IllegalStateException("Stack is empty");
            return queue.poll();
        }

        public int top() {
            if (empty()) throw new IllegalStateException("Stack is empty");
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        System.out.println("Is Empty: " + s.empty());
    }
}
