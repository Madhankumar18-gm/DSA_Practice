package Day18_MockTest_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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

        int[] a = {1, 1, 2};
        int[] b = {1, 2, 3};
        List<List<Integer>> res2 = kSmallestPairsMinHeap(a, b, 2);
        assert res2.size() == 2 : "Test 2 Size";
        assert res2.get(0).equals(Arrays.asList(1, 1));
        assert res2.get(1).equals(Arrays.asList(1, 1));
    }
}
