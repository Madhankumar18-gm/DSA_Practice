package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Standard Heap Sort Algorithm Implementation
 * Day 17 - Heaps & Priority Queue
 *
 * Complexities:
 * PriorityQueue Sort: Time O(N log N), Space O(N)
 * In-Place Heap Sort: Time O(N log N), Space O(1)
 */
public class HeapSortAlgorithm {

    public static void heapSortUsingPQ(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) pq.offer(val);
        for (int i = 0; i < arr.length; i++) arr[i] = pq.poll();
    }

    public static void heapSortInPlace(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        heapSortUsingPQ(arr1);
        assert Arrays.equals(arr1, new int[]{5, 6, 7, 11, 12, 13}) : "Test 1 Failed";

        int[] arr2 = {12, 11, 13, 5, 6, 7};
        heapSortInPlace(arr2);
        assert Arrays.equals(arr2, new int[]{5, 6, 7, 11, 12, 13}) : "Test 2 Failed";

        int[] rev = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSortInPlace(rev);
        assert Arrays.equals(rev, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) : "Refactor Test Failed";

        int[] single = {42};
        heapSortInPlace(single);
        assert single[0] == 42 : "Edge Test: Single element";
        heapSortInPlace(null);

        System.out.println("Execution completed successfully for HeapSortAlgorithm.");
    }
}
