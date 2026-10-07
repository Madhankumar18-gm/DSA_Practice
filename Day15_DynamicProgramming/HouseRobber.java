package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 198: House Robber
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class HouseRobber {

    public static int robMemo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, nums.length - 1, memo);
    }

    private static int robHelper(int[] nums, int i, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        int robCurrent = nums[i] + robHelper(nums, i - 2, memo);
        int skipCurrent = robHelper(nums, i - 1, memo);
        memo[i] = Math.max(robCurrent, skipCurrent);
        return memo[i];
    }
}
