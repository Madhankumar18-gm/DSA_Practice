import java.util.ArrayList;
import java.util.List;

/**
 * Problem 22: Subsets
 * 
 * Given an integer array `nums` of unique elements, return all possible subsets (the power set).
 */
public class Subsets {

    // Optimal Cascading Backtracking Loop O(N * 2^N)
    private static void backtrackLoop(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackLoop(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        backtrackLoop(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Subsets: " + subsets(nums));
    }
}
