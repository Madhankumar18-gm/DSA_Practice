package Day17_HeapsAndPriorityQueue;

import java.util.PriorityQueue;

public class HeapSortAlgorithm {

    public static void heapSortUsingPQ(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) pq.offer(val);
        for (int i = 0; i < arr.length; i++) arr[i] = pq.poll();
    }
}
