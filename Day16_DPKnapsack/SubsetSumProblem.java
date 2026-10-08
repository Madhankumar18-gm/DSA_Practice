package Day16_DPKnapsack;

/**
 * Subset Sum Problem (0/1 Knapsack Variant)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class SubsetSumProblem {

    public static boolean isSubsetSumMemo(int[] nums, int target) {
        if (nums == null || target < 0) return false;
        Boolean[][] memo = new Boolean[nums.length + 1][target + 1];
        return subsetHelper(nums, nums.length, target, memo);
    }

    private static boolean subsetHelper(int[] nums, int n, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (n == 0 || target < 0) return false;
        if (memo[n][target] != null) return memo[n][target];
        if (nums[n - 1] <= target) {
            memo[n][target] = subsetHelper(nums, n - 1, target - nums[n - 1], memo) || subsetHelper(nums, n - 1, target, memo);
        } else {
            memo[n][target] = subsetHelper(nums, n - 1, target, memo);
        }
        return memo[n][target];
    }
}
