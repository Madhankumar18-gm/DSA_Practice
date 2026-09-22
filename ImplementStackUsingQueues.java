import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 12: Implement Stack using Queues
 * 
 * Implement a last-in-first-out (LIFO) stack using a single queue.
 * 
 * Time Complexity: O(N) for push, O(1) for pop, top, empty.
 * Space Complexity: O(N) for queue storage.
 */
public class ImplementStackUsingQueues {
    public static class MyStack {
        private Queue<Integer> queue = new LinkedList<>();

        public MyStack() { }

        /** Pushes element x to top of stack. O(N) time */
        public void push(int x) {
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.poll());
                sz--;
            }
        }

        /** Removes top element. O(1) time */
        public int pop() {
            if (empty()) throw new IllegalStateException("Stack is empty");
            return queue.poll();
        }

        /** Returns top element. O(1) time */
        public int top() {
            if (empty()) throw new IllegalStateException("Stack is empty");
            return queue.peek();
        }

        /** Returns whether stack is empty. O(1) time */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        System.out.println("Top: " + s.top());
    }
}
