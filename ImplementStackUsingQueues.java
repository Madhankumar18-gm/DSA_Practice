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
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        System.out.println("Pop:   " + s.pop());   // 20
        System.out.println("Top:   " + s.top());   // 10
        System.out.println("Empty? " + s.empty()); // false
    }
}
