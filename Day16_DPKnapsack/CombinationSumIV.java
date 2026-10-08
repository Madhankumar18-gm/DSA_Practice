package Day16_DPKnapsack;

import java.util.Arrays;

/**
 * LeetCode 377: Combination Sum IV (Unbounded Permutation Knapsack)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class CombinationSumIV {

    public static int combinationSum4Memo(int[] nums, int target) {
        if (nums == null || target < 0) return 0;
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return helper(nums, target, memo);
    }

    private static int helper(int[] nums, int rem, int[] memo) {
        if (rem == 0) return 1;
        if (rem < 0) return 0;
        if (memo[rem] != -1) return memo[rem];
        int count = 0;
        for (int num : nums) {
            count += helper(nums, rem - num, memo);
        }
        memo[rem] = count;
        return memo[rem];
    }

    public static int combinationSum4Optimal(int[] nums, int target) {
        if (nums == null || target < 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            for (int num : nums) {
                if (t >= num) {
                    dp[t] += dp[t - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        assert combinationSum4Memo(new int[]{1, 2, 3}, 4) == 7 : "Test 1 Failed: Memo target=4";
        assert combinationSum4Memo(new int[]{9}, 3) == 0 : "Test 2 Failed: Memo target=3";

        assert combinationSum4Optimal(new int[]{1, 2, 3}, 4) == 7 : "Test 3 Failed: Optimal target=4";
        assert combinationSum4Optimal(new int[]{9}, 3) == 0 : "Test 4 Failed: Optimal target=3";

        assert combinationSum4Optimal(new int[]{1, 2}, 3) == 3 : "Refactor Test: Target 3";
        assert combinationSum4Optimal(new int[]{1}, 0) == 1 : "Edge Test: Target 0";
        assert combinationSum4Optimal(null, 5) == 0 : "Edge Test: Null input";
    }
}
