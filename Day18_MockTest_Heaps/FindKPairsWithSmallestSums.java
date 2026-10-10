package Day18_MockTest_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 373: Find K Pairs with Smallest Sums
 * 
 * Problem:
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 * Define a pair (u, v) which consists of one element from nums1 and one element from nums2.
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * 
 * Complexity:
 * - Brute Force: O(M * N log(M * N)) time, O(M * N) space.
 * - Min-Heap: O(K log(min(N, K))) time, O(min(N, K)) space.
 */
public class FindKPairsWithSmallestSums {

    public static List<List<Integer>> kSmallestPairsMinHeap(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{i, 0, nums1[i] + nums2[0]});
        }

        while (!minHeap.isEmpty() && result.size() < k) {
            int[] curr = minHeap.poll();
            int i = curr[0];
            int j = curr[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1, nums1[i] + nums2[j + 1]});
            }
        }

        return result;
    }

    public static List<List<Integer>> kSmallestPairsBruteForce(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> all = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return all;
        }
        for (int x : nums1) {
            for (int y : nums2) {
                all.add(Arrays.asList(x, y));
            }
        }
        all.sort((a, b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
        return all.subList(0, Math.min(k, all.size()));
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> res = kSmallestPairsMinHeap(nums1, nums2, 3);
        assert res.size() == 3 : "Test 1 Size Failed";
        assert res.get(0).equals(Arrays.asList(1, 2)) : "Test 1 [0] Failed";
        assert res.get(1).equals(Arrays.asList(1, 4)) : "Test 1 [1] Failed";
        assert res.get(2).equals(Arrays.asList(1, 6)) : "Test 1 [2] Failed";

        List<List<Integer>> bf = kSmallestPairsBruteForce(nums1, nums2, 3);
        assert res.equals(bf) : "Brute force comparison failed";

        assert kSmallestPairsMinHeap(new int[]{1, 2}, new int[]{3}, 5).size() == 2 : "K exceeds total pairs";
        assert kSmallestPairsMinHeap(new int[]{}, new int[]{1}, 1).isEmpty() : "Empty nums1";
        assert kSmallestPairsMinHeap(null, new int[]{1}, 1).isEmpty() : "Null array";
        assert kSmallestPairsMinHeap(new int[]{1}, new int[]{1}, 0).isEmpty() : "k = 0";
    }
}
