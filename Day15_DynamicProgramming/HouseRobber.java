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

    public static int robOptimal(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev2 = 0, prev1 = 0;
        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        assert robMemo(new int[]{1, 2, 3, 1}) == 4 : "Test 1 Failed: Memo [1,2,3,1]";
        assert robMemo(new int[]{2, 7, 9, 3, 1}) == 12 : "Test 2 Failed: Memo [2,7,9,3,1]";

        assert robOptimal(new int[]{1, 2, 3, 1}) == 4 : "Test 3 Failed: Optimal [1,2,3,1]";
        assert robOptimal(new int[]{2, 7, 9, 3, 1}) == 12 : "Test 4 Failed: Optimal [2,7,9,3,1]";

        assert robOptimal(new int[]{5}) == 5 : "Refactor Test: Single house";
        assert robOptimal(new int[]{}) == 0 : "Edge Test: Empty array";
        assert robOptimal(null) == 0 : "Edge Test: Null input";
    }
}
