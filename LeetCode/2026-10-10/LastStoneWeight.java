package Day18_MockTest_Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 1046: Last Stone Weight
 * 
 * Problem:
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * In each turn, choose the two heaviest stones and smash them together:
 * - If x == y, both stones are destroyed.
 * - If x != y, stone of weight x is destroyed, and stone of weight y has new weight (y - x).
 * Return the weight of the last remaining stone, or 0 if none remain.
 * 
 * Complexity:
 * - Naive Sorting: O(N^2 log N) time, O(N) space.
 * - Max-Heap: O(N log N) time to build and smash, O(N) space.
 */
public class LastStoneWeight {

    public static int lastStoneWeightNaive(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        int n = stones.length;
        int[] arr = stones.clone();
        while (n > 1) {
            Arrays.sort(arr, 0, n);
            int y = arr[n - 1];
            int x = arr[n - 2];
            if (x == y) {
                n -= 2;
            } else {
                arr[n - 2] = y - x;
                n -= 1;
            }
        }
        return n == 1 ? arr[0] : 0;
    }

    public static int lastStoneWeightMaxHeap(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        assert lastStoneWeightNaive(new int[]{2, 7, 4, 1, 8, 1}) == 1 : "Test 1 Failed";
        assert lastStoneWeightNaive(new int[]{1}) == 1 : "Test 2 Failed";
        assert lastStoneWeightMaxHeap(new int[]{2, 7, 4, 1, 8, 1}) == 1 : "Heap Test 1 Failed";
        assert lastStoneWeightMaxHeap(new int[]{1}) == 1 : "Heap Test 2 Failed";

        int[] identical = {2, 2, 2, 2};
        assert lastStoneWeightMaxHeap(identical) == 0 : "Identical Stones Test Failed";

        int[] oddSame = {3, 3, 3};
        assert lastStoneWeightMaxHeap(oddSame) == 3 : "Odd Same Test Failed";

        assert lastStoneWeightMaxHeap(new int[]{}) == 0 : "Empty array test";
        assert lastStoneWeightMaxHeap(null) == 0 : "Null array test";

        System.out.println("Execution completed successfully for LastStoneWeight.");
    }
}
