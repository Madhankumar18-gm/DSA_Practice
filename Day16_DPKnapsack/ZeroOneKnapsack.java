package Day16_DPKnapsack;

import java.util.Arrays;

/**
 * Standard 0/1 Knapsack Problem
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class ZeroOneKnapsack {

    public static int knapsackMemo(int[] wt, int[] val, int W) {
        if (wt == null || val == null || W <= 0 || wt.length != val.length) return 0;
        int n = wt.length;
        int[][] memo = new int[n + 1][W + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return knapsackHelper(wt, val, n, W, memo);
    }

    private static int knapsackHelper(int[] wt, int[] val, int n, int W, int[][] memo) {
        if (n == 0 || W == 0) return 0;
        if (memo[n][W] != -1) return memo[n][W];
        if (wt[n - 1] <= W) {
            int include = val[n - 1] + knapsackHelper(wt, val, n - 1, W - wt[n - 1], memo);
            int exclude = knapsackHelper(wt, val, n - 1, W, memo);
            memo[n][W] = Math.max(include, exclude);
        } else {
            memo[n][W] = knapsackHelper(wt, val, n - 1, W, memo);
        }
        return memo[n][W];
    }

    public static void main(String[] args) {
        assert knapsackMemo(new int[]{1, 2, 3}, new int[]{10, 15, 40}, 6) == 65 : "Test 1 Failed: Memo W=6";
        assert knapsackMemo(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50) == 220 : "Test 2 Failed: Memo W=50";
    }
}
