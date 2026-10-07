package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 322: Coin Change
 * Day 15 - Dynamic Programming (1D & 2D)
 *
 * Problem Description:
 * You are given an integer array coins representing coins of different denominations and an integer amount.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Complexities:
 * Top-Down Memoization: Time O(Amount * N), Space O(Amount)
 * Bottom-Up 1D DP: Time O(Amount * N), Space O(Amount)
 */
public class CoinChange {

    public static int coinChangeMemo(int[] coins, int amount) {
        if (coins == null || amount < 0) return -1;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return coinHelper(coins, amount, memo);
    }

    private static int coinHelper(int[] coins, int rem, int[] memo) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (memo[rem] != -2) return memo[rem];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinHelper(coins, rem - coin, memo);
            if (res >= 0 && res < minCoins) {
                minCoins = 1 + res;
            }
        }
        memo[rem] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[rem];
    }

    public static int coinChangeOptimal(int[] coins, int amount) {
        if (coins == null || amount < 0) return -1;
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        assert coinChangeMemo(new int[]{1, 2, 5}, 11) == 3 : "Test 1 Failed: Memo 11";
        assert coinChangeMemo(new int[]{2}, 3) == -1 : "Test 2 Failed: Memo 3";
        assert coinChangeMemo(new int[]{1}, 0) == 0 : "Test 3 Failed: Memo 0";

        assert coinChangeOptimal(new int[]{1, 2, 5}, 11) == 3 : "Test 4 Failed: Optimal 11";
        assert coinChangeOptimal(new int[]{2}, 3) == -1 : "Test 5 Failed: Optimal 3";
        assert coinChangeOptimal(new int[]{1}, 0) == 0 : "Test 6 Failed: Optimal 0";

        assert coinChangeOptimal(new int[]{186, 419, 83, 408}, 6249) == 20 : "Refactor Test: Large Amount";
        assert coinChangeOptimal(new int[]{1}, -5) == -1 : "Edge Test: Negative amount";
        assert coinChangeOptimal(null, 10) == -1 : "Edge Test: Null coins";

        System.out.println("Execution completed successfully for CoinChange.");
    }
}
