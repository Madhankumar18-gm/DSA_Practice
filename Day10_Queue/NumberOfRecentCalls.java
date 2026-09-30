package Day10_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    public static class NaiveCounter {
        private List<Integer> list = new ArrayList<>();
        public int ping(int t) {
            list.add(t);
            int count = 0;
            for (int val : list) {
                if (val >= t - 3000) count++;
            }
            return count;
        }
    }
    public static class RecentCounter {
        private Queue<Integer> queue;
        public RecentCounter() {
            this.queue = new LinkedList<>();
        }
        public int ping(int t) {
            queue.offer(t);
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
    public static void main(String[] args) {
        NaiveCounter nc = new NaiveCounter();
        assert nc.ping(1) == 1;
        assert nc.ping(100) == 2;
        assert nc.ping(3001) == 3;
        assert nc.ping(3002) == 3;
    }
}
