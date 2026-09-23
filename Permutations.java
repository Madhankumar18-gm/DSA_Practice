import java.util.ArrayList;
import java.util.List;

/**
 * Problem 20: Permutations
 * 
 * Given an array `nums` of distinct integers, return all the possible permutations.
 */
public class Permutations {

    private static void backtrackVisited(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            backtrackVisited(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        backtrackVisited(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Permutations count: " + permute(nums).size());
    }
}
