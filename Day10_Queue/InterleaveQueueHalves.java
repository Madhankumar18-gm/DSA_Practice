package Day10_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
