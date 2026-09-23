import java.util.Arrays;

/**
 * Problem 7: Coin Change
 * 
 * Given an integer array `coins` representing coins of different denominations and an integer `amount`,
 * return the fewest number of coins that you need to make up that amount.
 * 
 * Time Complexity: O(amount * N) where N is the number of coins.
 * Space Complexity: O(amount) for DP table.
 */
public class CoinChange {

    /**
     * Calculates minimum coins needed using 1D DP array.
     * Time: O(amount * N), Space: O(amount)
     */
    public static int coinChangeDP(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;

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

    public static int coinChange(int[] coins, int amount) {
        return coinChangeDP(coins, amount);
    }

    public static void main(String[] args) {
        System.out.println("=== CoinChange Execution Suite ===");
        
        int[] coins1 = {1, 2, 5};
        System.out.println("Coins [1, 2, 5], Amount 11 -> Fewest Coins: " + coinChange(coins1, 11));

        int[] coins2 = {2};
        System.out.println("Coins [2],       Amount 3  -> Fewest Coins: " + coinChange(coins2, 3));

        int[] coins3 = {1};
        System.out.println("Coins [1],       Amount 0  -> Fewest Coins: " + coinChange(coins3, 0));

        System.out.println("Null Guard Check           -> Fewest Coins: " + coinChange(null, 5));
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
