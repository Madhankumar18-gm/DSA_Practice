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
}
