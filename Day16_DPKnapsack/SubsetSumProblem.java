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

    public static boolean isSubsetSumOptimal(int[] nums, int target) {
        if (nums == null || target < 0) return false;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                dp[t] = dp[t] || dp[t - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        assert isSubsetSumMemo(new int[]{3, 34, 4, 12, 5, 2}, 9) == true : "Test 1 Failed: Memo target=9";
        assert isSubsetSumMemo(new int[]{3, 34, 4, 12, 5, 2}, 30) == false : "Test 2 Failed: Memo target=30";

        assert isSubsetSumOptimal(new int[]{3, 34, 4, 12, 5, 2}, 9) == true : "Test 3 Failed: Optimal target=9";
        assert isSubsetSumOptimal(new int[]{3, 34, 4, 12, 5, 2}, 30) == false : "Test 4 Failed: Optimal target=30";
    }
}
