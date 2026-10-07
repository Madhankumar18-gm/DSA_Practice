package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 300: Longest Increasing Subsequence
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
