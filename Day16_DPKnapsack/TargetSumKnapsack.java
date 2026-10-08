package Day16_DPKnapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 494: Target Sum (Knapsack Transformation)
 * Day 16 - Dynamic Programming (Knapsack Variants)
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
}
