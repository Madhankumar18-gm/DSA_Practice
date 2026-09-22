/**
 * Problem 1: Two Sum
 * 
 * Given an array of integers `nums` and an integer `target`, return indices of 
 * the two numbers such that they add up to target.
 */
public class TwoSum {

    // Brute Force Approach: O(N^2) time complexity
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] nums, int target) {
        return twoSumBruteForce(nums, target);
    }
}
