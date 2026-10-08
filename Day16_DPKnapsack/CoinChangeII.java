package Day16_DPKnapsack;

import java.util.Arrays;

/**
 * LeetCode 518: Coin Change II (Unbounded Knapsack Variant)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class CoinChangeII {

    public static int changeMemo(int amount, int[] coins) {
        if (coins == null || amount < 0) return 0;
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return changeHelper(amount, coins, coins.length, memo);
    }

    private static int changeHelper(int rem, int[] coins, int n, int[][] memo) {
        if (rem == 0) return 1;
        if (n == 0 || rem < 0) return 0;
        if (memo[n][rem] != -1) return memo[n][rem];
        int include = changeHelper(rem - coins[n - 1], coins, n, memo);
        int exclude = changeHelper(rem, coins, n - 1, memo);
        memo[n][rem] = include + exclude;
        return memo[n][rem];
    }
}
