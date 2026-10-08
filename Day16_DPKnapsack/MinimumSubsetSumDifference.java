package Day16_DPKnapsack;

/**
 * Minimum Subset Sum Difference (0/1 Knapsack Variant)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class MinimumSubsetSumDifference {

    public static int minSubsetDiffMemo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        Integer[][] memo = new Integer[nums.length + 1][totalSum + 1];
        return diffHelper(nums, nums.length, 0, totalSum, memo);
    }

    private static int diffHelper(int[] nums, int idx, int currentSum, int totalSum, Integer[][] memo) {
        if (idx == 0) {
            return Math.abs((totalSum - currentSum) - currentSum);
        }
        if (memo[idx][currentSum] != null) return memo[idx][currentSum];
        int include = diffHelper(nums, idx - 1, currentSum + nums[idx - 1], totalSum, memo);
        int exclude = diffHelper(nums, idx - 1, currentSum, totalSum, memo);
        memo[idx][currentSum] = Math.min(include, exclude);
        return memo[idx][currentSum];
    }
}
