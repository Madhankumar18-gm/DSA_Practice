package Day11_Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 98: [LeetCode 454] 4Sum II
 * Pairwise HashMap Sum Counter algorithm in O(N^2) time and O(N^2) space.
 */
public class FourSumII {
    public static int fourSumCountNaive(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                for (int c : nums3) {
                    for (int d : nums4) {
                        if (a + b + c + d == 0) count++;
                    }
                }
            }
        }
        return count;
    }
    public static int fourSumCountOptimal(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                count += map.getOrDefault(-(c + d), 0);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a = {1, 2}, b = {-2, -1}, c = {-1, 2}, d = {0, 2};
        assert fourSumCountNaive(a, b, c, d) == 2;
        assert fourSumCountOptimal(a, b, c, d) == 2;
        assert fourSumCountOptimal(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}) == 1;
        System.out.println("Execution completed successfully for FourSumII.");
    }
}
