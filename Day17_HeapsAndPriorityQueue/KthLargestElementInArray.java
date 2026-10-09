package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static int findKthLargestSorting(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) return -1;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        return copy[copy.length - k];
    }

    public static int findKthLargestMinHeap(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        assert findKthLargestSorting(new int[]{3, 2, 1, 5, 6, 4}, 2) == 5 : "Test 1 Failed";
        assert findKthLargestSorting(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4 : "Test 2 Failed";

        assert findKthLargestMinHeap(new int[]{3, 2, 1, 5, 6, 4}, 2) == 5 : "Test 3 Failed";
        assert findKthLargestMinHeap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4 : "Test 4 Failed";

        assert findKthLargestMinHeap(new int[]{7, 7, 7, 7, 7}, 1) == 7 : "Refactor Test 1";
        assert findKthLargestMinHeap(new int[]{1}, 1) == 1 : "Edge Test: Single element";
        assert findKthLargestMinHeap(null, 1) == -1 : "Edge Test: Null input";
    }
}
