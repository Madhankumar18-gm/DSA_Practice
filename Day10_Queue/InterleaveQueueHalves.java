package Day10_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem 91: Interleave First Half of Queue with Second Half
 * Interleaves first half of even-sized queue with second half.
 */
public class InterleaveQueueHalves {
    public static Queue<Integer> interleaveNaive(Queue<Integer> q) {
        if (q == null || q.size() % 2 != 0) return q;
        List<Integer> list = new ArrayList<>(q);
        int half = list.size() / 2;
        Queue<Integer> res = new LinkedList<>();
        for (int i = 0; i < half; i++) {
            res.offer(list.get(i));
            res.offer(list.get(i + half));
        }
        return res;
    }
    public static Queue<Integer> interleaveOptimal(Queue<Integer> q) {
        if (q == null || q.size() % 2 != 0) return q;
        int half = q.size() / 2;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < half; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        for (int i = 0; i < half; i++) {
            q.offer(q.poll());
        }
        for (int i = 0; i < half; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
            q.offer(q.poll());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 6; i++) q.offer(i);
        Queue<Integer> res = interleaveNaive(q);
        assert res.poll() == 1;
        assert res.poll() == 4;
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 1; i <= 6; i++) q2.offer(i);
        Queue<Integer> resOpt = interleaveOptimal(q2);
        assert resOpt.poll() == 1;
        assert resOpt.poll() == 4;
        assert resOpt.poll() == 2;
        assert resOpt.poll() == 5;
        assert resOpt.poll() == 3;
        assert resOpt.poll() == 6;
        assert interleaveOptimal(null) == null;
    }
}
