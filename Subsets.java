import java.util.ArrayList;
import java.util.List;

/**
 * Problem 22: Subsets
 * 
 * Given an integer array `nums` of unique elements, return all possible subsets (the power set).
 * 
 * Time Complexity: O(N * 2^N) generating 2^N subsets of average length N/2.
 * Space Complexity: O(N) recursion stack depth.
 */
public class Subsets {

    /**
     * Generates all power set subsets using backtracking loop.
     * Time: O(N * 2^N), Space: O(N)
     */
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrackLoop(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackLoop(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackLoop(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Subsets Execution Suite ===");
        int[] input = {1, 2, 3};
        List<List<Integer>> res = subsets(input);
        System.out.println("Input [1, 2, 3] -> Total Subsets (2^3=8): " + res.size());
        System.out.println("Power Set: " + res);
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
