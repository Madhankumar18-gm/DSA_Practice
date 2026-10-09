package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSortAlgorithm {

    public static void heapSortUsingPQ(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) pq.offer(val);
        for (int i = 0; i < arr.length; i++) arr[i] = pq.poll();
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        heapSortUsingPQ(arr1);
        assert Arrays.equals(arr1, new int[]{5, 6, 7, 11, 12, 13}) : "Test 1 Failed";
    }
}
