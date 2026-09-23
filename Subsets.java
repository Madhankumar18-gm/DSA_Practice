import java.util.ArrayList;
import java.util.List;

/**
 * Problem 22: Subsets
 * 
 * Given an integer array `nums` of unique elements, return all possible subsets (the power set).
 */
public class Subsets {

    // Include / Exclude binary tree recursion
    private static void backtrackIncludeExclude(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Exclude nums[index]
        backtrackIncludeExclude(index + 1, nums, current, result);
        // Include nums[index]
        current.add(nums[index]);
        backtrackIncludeExclude(index + 1, nums, current, result);
        current.remove(current.size() - 1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        backtrackIncludeExclude(0, nums, new ArrayList<>(), result);
        return result;
    }
}
