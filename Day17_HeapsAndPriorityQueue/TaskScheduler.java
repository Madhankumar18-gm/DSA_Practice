package Day17_HeapsAndPriorityQueue;

import java.util.*;

public class TaskScheduler {

    public static int leastIntervalMaxHeap(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) if (f > 0) pq.offer(f);

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) temp.add(pq.poll());
            }
            for (int f : temp) {
                if (--f > 0) pq.offer(f);
            }
            time += pq.isEmpty() ? temp.size() : n + 1;
        }
        return time;
    }

    public static int leastIntervalFormula(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char c : tasks) {
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
        }
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) maxCount++;
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {
        assert leastIntervalMaxHeap(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) == 8 : "Test 1 Failed";
        assert leastIntervalMaxHeap(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) == 6 : "Test 2 Failed";

        assert leastIntervalFormula(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) == 8 : "Test 3 Failed";
        assert leastIntervalFormula(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) == 6 : "Test 4 Failed";

        assert leastIntervalFormula(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) == 16 : "Refactor Test";
        assert leastIntervalFormula(new char[]{}, 2) == 0 : "Edge Test: Empty array";
        assert leastIntervalFormula(null, 2) == 0 : "Edge Test: Null array";
    }
}
