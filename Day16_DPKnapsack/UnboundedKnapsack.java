package Day16_DPKnapsack;

import java.util.Arrays;

/**
 * Unbounded Knapsack / Rod Cutting Problem
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class UnboundedKnapsack {

    public static int unboundedKnapsackMemo(int[] wt, int[] val, int W) {
        if (wt == null || val == null || W <= 0 || wt.length != val.length) return 0;
        int n = wt.length;
        int[][] memo = new int[n + 1][W + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return helper(wt, val, n, W, memo);
    }

    private static int helper(int[] wt, int[] val, int n, int W, int[][] memo) {
        if (n == 0 || W == 0) return 0;
        if (memo[n][W] != -1) return memo[n][W];
        if (wt[n - 1] <= W) {
            int include = val[n - 1] + helper(wt, val, n, W - wt[n - 1], memo);
            int exclude = helper(wt, val, n - 1, W, memo);
            memo[n][W] = Math.max(include, exclude);
        } else {
            memo[n][W] = helper(wt, val, n - 1, W, memo);
        }
        return memo[n][W];
    }

    public static int unboundedKnapsackOptimal(int[] wt, int[] val, int W) {
        if (wt == null || val == null || W <= 0 || wt.length != val.length) return 0;
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int w = wt[i]; w <= W; w++) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        assert unboundedKnapsackMemo(new int[]{2, 4, 6}, new int[]{5, 11, 13}, 10) == 27 : "Test 1 Failed: Memo W=10";
        assert unboundedKnapsackMemo(new int[]{1, 3, 4, 5}, new int[]{10, 40, 50, 70}, 8) == 110 : "Test 2 Failed: Memo W=8";

        assert unboundedKnapsackOptimal(new int[]{2, 4, 6}, new int[]{5, 11, 13}, 10) == 27 : "Test 3 Failed: Optimal W=10";
        assert unboundedKnapsackOptimal(new int[]{1, 3, 4, 5}, new int[]{10, 40, 50, 70}, 8) == 110 : "Test 4 Failed: Optimal W=8";

        assert unboundedKnapsackOptimal(new int[]{1, 2, 3}, new int[]{1, 5, 8}, 5) == 13 : "Refactor Test: Multiple repeats";
    }
}
