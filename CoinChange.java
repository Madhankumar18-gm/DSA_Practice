/**
 * Problem 7: Coin Change
 * 
 * Given an integer array `coins` representing coins of different denominations and an integer `amount`,
 * return the fewest number of coins that you need to make up that amount.
 */
public class CoinChange {

    // Recursive Backtracking solution (Brute Force)
    public static int coinChangeRecursive(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = coinChangeRecursive(coins, amount - coin);
            if (subRes >= 0 && subRes < minCoins) {
                minCoins = subRes + 1;
            }
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static int coinChange(int[] coins, int amount) {
        return coinChangeRecursive(coins, amount);
    }
}
