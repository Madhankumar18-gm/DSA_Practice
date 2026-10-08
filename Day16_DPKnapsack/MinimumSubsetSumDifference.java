package Day16_DPKnapsack;

/**
 * Minimum Subset Sum Difference (0/1 Knapsack Variant)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 *
 * Problem Description:
 * Given a set of positive integers, partition the set into two subsets S1 and S2
 * such that the absolute difference between their sums |sum(S1) - sum(S2)| is minimized.
 *
 * Complexities:
 * Top-Down Memoization: Time O(N * TotalSum), Space O(N * TotalSum)
 * Bottom-Up 1D DP: Time O(N * TotalSum), Space O(TotalSum / 2)
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

    public static int minSubsetDiffOptimal(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }

        for (int s = target; s >= 0; s--) {
            if (dp[s]) {
                return totalSum - 2 * s;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        assert minSubsetDiffMemo(new int[]{1, 6, 11, 5}) == 1 : "Test 1 Failed: Memo [1,6,11,5]";
        assert minSubsetDiffMemo(new int[]{1, 2, 7}) == 4 : "Test 2 Failed: Memo [1,2,7]";

        assert minSubsetDiffOptimal(new int[]{1, 6, 11, 5}) == 1 : "Test 3 Failed: Optimal [1,6,11,5]";
        assert minSubsetDiffOptimal(new int[]{1, 2, 7}) == 4 : "Test 4 Failed: Optimal [1,2,7]";

        assert minSubsetDiffOptimal(new int[]{3, 1, 4, 2, 2}) == 0 : "Refactor Test: Zero difference partition";
        assert minSubsetDiffOptimal(new int[]{10}) == 10 : "Edge Test: Single element array";
        assert minSubsetDiffOptimal(null) == 0 : "Edge Test: Null array";
    }
}
