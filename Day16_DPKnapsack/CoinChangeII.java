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

    public static int changeOptimal(int amount, int[] coins) {
        if (coins == null || amount < 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] += dp[a - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        assert changeMemo(5, new int[]{1, 2, 5}) == 4 : "Test 1 Failed: Memo 5";
        assert changeMemo(3, new int[]{2}) == 0 : "Test 2 Failed: Memo 3";
        assert changeMemo(10, new int[]{10}) == 1 : "Test 3 Failed: Memo 10";

        assert changeOptimal(5, new int[]{1, 2, 5}) == 4 : "Test 4 Failed: Optimal 5";
        assert changeOptimal(3, new int[]{2}) == 0 : "Test 5 Failed: Optimal 3";
        assert changeOptimal(10, new int[]{10}) == 1 : "Test 6 Failed: Optimal 10";

        assert changeOptimal(500, new int[]{3, 5, 7, 8, 9, 10, 11}) == 355028 : "Refactor Test: Large amount";
    }
}
