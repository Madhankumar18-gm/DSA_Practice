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

    public static void main(String[] args) {
        assert lengthOfLISDP(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) == 4 : "Test 1 Failed: DP [10,9,2,5,3,7,101,18]";
        assert lengthOfLISDP(new int[]{0, 1, 0, 3, 2, 3}) == 4 : "Test 2 Failed: DP [0,1,0,3,2,3]";
        assert lengthOfLISDP(new int[]{7, 7, 7, 7}) == 1 : "Test 3 Failed: DP [7,7,7,7]";
    }
}
