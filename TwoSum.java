import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1: Two Sum
 * 
 * Given an array of integers `nums` and an integer `target`, return indices of 
 * the two numbers such that they add up to target.
 * 
 * Time Complexity: O(N) where N is the length of array
 * Space Complexity: O(N) for hash map storing elements
 */
public class TwoSum {

    /**
     * Finds indices using Brute Force approach.
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Finds indices using One-pass HashMap lookup.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int[] twoSumOptimized(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
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
        System.out.println("--- Running TwoSum Tests ---");
        
        int[] test1 = {2, 7, 11, 15};
        System.out.println("Test 1 Result: " + Arrays.toString(twoSum(test1, 9)));

        int[] test2 = {3, 2, 4};
        System.out.println("Test 2 Result: " + Arrays.toString(twoSum(test2, 6)));

        int[] test3 = {3, 3};
        System.out.println("Test 3 Result: " + Arrays.toString(twoSum(test3, 6)));

        System.out.println("Test 4 (null): " + Arrays.toString(twoSum(null, 5)));
        System.out.println("Test 5 (empty): " + Arrays.toString(twoSum(new int[]{}, 5)));
    }
}
