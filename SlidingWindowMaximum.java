import java.util.Arrays;

/**
 * Problem 13: Sliding Window Maximum
 * 
 * You are given an array of integers `nums`, there is a sliding window of size `k`.
 */
public class SlidingWindowMaximum {

    // Brute Force O(N * k) solution
    public static int[] maxSlidingWindowBrute(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowBrute(nums, k);
    }
}
