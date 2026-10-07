package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 322: Coin Change
 * Day 15 - Dynamic Programming (1D & 2D)
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
}
