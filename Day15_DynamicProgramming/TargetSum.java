package Day15_DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 494: Target Sum
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class TargetSum {

    public static int findTargetSumWaysMemo(int[] nums, int target) {
        if (nums == null) return 0;
        Map<String, Integer> memo = new HashMap<>();
        return targetHelper(nums, 0, 0, target, memo);
    }

    private static int targetHelper(int[] nums, int i, int currentSum, int target, Map<String, Integer> memo) {
        if (i == nums.length) {
            return currentSum == target ? 1 : 0;
        }
        String key = i + "," + currentSum;
        if (memo.containsKey(key)) return memo.get(key);
        int add = targetHelper(nums, i + 1, currentSum + nums[i], target, memo);
        int subtract = targetHelper(nums, i + 1, currentSum - nums[i], target, memo);
        memo.put(key, add + subtract);
        return add + subtract;
    }

    public static void main(String[] args) {
        assert findTargetSumWaysMemo(new int[]{1, 1, 1, 1, 1}, 3) == 5 : "Test 1 Failed: Memo [1,1,1,1,1] t=3";
        assert findTargetSumWaysMemo(new int[]{1}, 1) == 1 : "Test 2 Failed: Memo [1] t=1";
    }
}
