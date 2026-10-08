package Day16_DPKnapsack;

/**
 * LeetCode 416: Partition Equal Subset Sum
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartitionMemo(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return partitionHelper(nums, 0, target, memo);
    }

    private static boolean partitionHelper(int[] nums, int idx, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (idx >= nums.length || target < 0) return false;
        if (memo[idx][target] != null) return memo[idx][target];
        boolean include = partitionHelper(nums, idx + 1, target - nums[idx], memo);
        boolean exclude = partitionHelper(nums, idx + 1, target, memo);
        memo[idx][target] = include || exclude;
        return memo[idx][target];
    }

    public static void main(String[] args) {
        assert canPartitionMemo(new int[]{1, 5, 11, 5}) == true : "Test 1 Failed: Memo [1,5,11,5]";
        assert canPartitionMemo(new int[]{1, 2, 3, 5}) == false : "Test 2 Failed: Memo [1,2,3,5]";
    }
}
