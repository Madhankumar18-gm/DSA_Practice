import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 21: Permutations II
 * 
 * Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations.
 * 
 * Time Complexity: O(N * N!) sorted array pruning avoids duplicate branches.
 * Space Complexity: O(N) for used boolean array and recursion stack.
 */
public class PermutationsII {

    /**
     * Generates all unique permutations avoiding duplicate outputs.
     * Time: O(N * N!), Space: O(N)
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== PermutationsII Execution Suite ===");
        int[] input = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(input);
        System.out.println("Input [1, 1, 2] -> Unique Permutations Count: " + res.size());
        System.out.println("All Permutations: " + res);
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
