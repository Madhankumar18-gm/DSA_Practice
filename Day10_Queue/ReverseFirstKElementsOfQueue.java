package Day10_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {
    public static Queue<Integer> reverseKNaive(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) return queue;
        List<Integer> list = new ArrayList<>(queue);
        Collections.reverse(list.subList(0, k));
        Queue<Integer> res = new LinkedList<>();
        for (int val : list) res.offer(val);
        return res;
    }
    public static Queue<Integer> reverseKOptimal(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) return queue;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.offer(queue.poll());
        }
        return queue;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); q.offer(2); q.offer(3); q.offer(4); q.offer(5);
        Queue<Integer> rev = reverseKNaive(q, 3);
        assert rev.poll() == 3;
        assert rev.poll() == 2;
        assert rev.poll() == 1;
        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(1); q2.offer(2); q2.offer(3); q2.offer(4); q2.offer(5);
        Queue<Integer> revOpt = reverseKOptimal(q2, 3);
        assert revOpt.poll() == 3;
        assert revOpt.poll() == 2;
        assert revOpt.poll() == 1;
        assert revOpt.poll() == 4;
        assert revOpt.poll() == 5;
        Queue<Integer> q3 = new LinkedList<>();
        q3.offer(10);
        assert reverseKOptimal(q3, 1).poll() == 10;
        assert reverseKOptimal(null, 5) == null;
    }
}
