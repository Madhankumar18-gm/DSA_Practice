package Day17_HeapsAndPriorityQueue;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequentSorting(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) count.put(n, count.getOrDefault(n, 0) + 1);
        List<Integer> list = new ArrayList<>(count.keySet());
        list.sort((a, b) -> count.get(b) - count.get(a));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = list.get(i);
        return res;
    }
}
