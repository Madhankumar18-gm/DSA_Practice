package Day16_DPKnapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 494: Target Sum (Knapsack Transformation)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 *
 * Problem Description:
 * You are given an integer array nums and an integer target.
 * Assign '+' or '-' signs to each element to reach target.
 * Mathematically transforms to: sum(S1) = (totalSum + target) / 2 (0/1 Subset Sum Count).
 *
 * Complexities:
 * Top-Down Memoization: Time O(N * TotalSum), Space O(N * TotalSum)
 * Bottom-Up 1D DP: Time O(N * S1), Space O(S1)
 */
public class TargetSumKnapsack {

    public static int findTargetSumWaysMemo(int[] nums, int target) {
        if (nums == null) return 0;
        Map<String, Integer> memo = new HashMap<>();
        return targetHelper(nums, 0, 0, target, memo);
    }

    private static int targetHelper(int[] nums, int idx, int currentSum, int target, Map<String, Integer> memo) {
        if (idx == nums.length) {
            return currentSum == target ? 1 : 0;
        }
        String key = idx + "," + currentSum;
        if (memo.containsKey(key)) return memo.get(key);
        int add = targetHelper(nums, idx + 1, currentSum + nums[idx], target, memo);
        int sub = targetHelper(nums, idx + 1, currentSum - nums[idx], target, memo);
        memo.put(key, add + sub);
        return add + sub;
    }

    public static int findTargetSumWaysOptimal(int[] nums, int target) {
        if (nums == null) return 0;
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;
        int s1 = (sum + target) / 2;
        if (s1 < 0) return 0;
        int[] dp = new int[s1 + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int s = s1; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        return dp[s1];
    }

    public static void main(String[] args) {
        assert findTargetSumWaysMemo(new int[]{1, 1, 1, 1, 1}, 3) == 5 : "Test 1 Failed: Memo [1,1,1,1,1] t=3";
        assert findTargetSumWaysMemo(new int[]{1}, 1) == 1 : "Test 2 Failed: Memo [1] t=1";

        assert findTargetSumWaysOptimal(new int[]{1, 1, 1, 1, 1}, 3) == 5 : "Test 3 Failed: Optimal [1,1,1,1,1] t=3";
        assert findTargetSumWaysOptimal(new int[]{1}, 1) == 1 : "Test 4 Failed: Optimal [1] t=1";

        assert findTargetSumWaysOptimal(new int[]{2, 107, 109, 113, 127}, 1000) == 0 : "Refactor Test: Out of bounds target";
        assert findTargetSumWaysOptimal(new int[]{0, 0, 1}, 1) == 4 : "Edge Test: Zeros handling";
        assert findTargetSumWaysOptimal(null, 1) == 0 : "Edge Test: Null input";

        System.out.println("Execution completed successfully for TargetSumKnapsack.");
    }
}
