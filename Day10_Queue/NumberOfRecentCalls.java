package Day10_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    public static class RecentCounter {
        private Queue<Integer> queue;
        public RecentCounter() {
            this.queue = new LinkedList<>();
        }
    }
}
