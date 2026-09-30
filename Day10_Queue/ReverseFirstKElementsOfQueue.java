package Day10_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseFirstKElementsOfQueue {
    public static Queue<Integer> reverseKNaive(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) return queue;
        List<Integer> list = new ArrayList<>(queue);
        Collections.reverse(list.subList(0, k));
        Queue<Integer> res = new LinkedList<>();
        for (int val : list) res.offer(val);
        return res;
    }
}
