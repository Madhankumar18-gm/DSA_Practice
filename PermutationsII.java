import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 21: Permutations II
 * 
 * Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {

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

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Null Guard:  " + permuteUnique(null));
        System.out.println("Empty Guard: " + permuteUnique(new int[]{}));
    }
}
