import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 12: Implement Stack using Queues
 * 
 * Implement a last-in-first-out (LIFO) stack using two queues.
 */
public class ImplementStackUsingQueues {
    public static class MyStack {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        public MyStack() { }

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
