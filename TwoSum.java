import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    // Optimized Approach: O(N) time complexity using HashMap
    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] nums, int target) {
        return twoSumOptimized(nums, target);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Two Sum Result: " + Arrays.toString(result));
    }
}
