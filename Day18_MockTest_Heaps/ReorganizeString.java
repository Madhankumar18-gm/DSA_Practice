package Day18_MockTest_Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static String reorganizeStringMaxHeap(String s) {
        if (s == null || s.length() == 0) return "";
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] > (s.length() + 1) / 2) return "";
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) ('a' + curr[0]));
            curr[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }
            prev = curr;
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
