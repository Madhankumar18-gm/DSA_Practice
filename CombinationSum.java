import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 23: Combination Sum
 * 
 * Given an array of distinct integers `candidates` and a `target`, return all unique combinations.
 * 
 * Time Complexity: O(N^(T/M)) where T is target and M is min candidate value.
 * Space Complexity: O(T/M) for recursion stack depth.
 */
public class CombinationSum {

    /**
     * Finds unique combinations that sum to target.
     * Time: O(N^(T/M)), Space: O(T/M)
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackPruned(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackPruned(int start, int[] candidates, int remain, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (remain - candidates[i] < 0) break;

            current.add(candidates[i]);
            backtrackPruned(i, candidates, remain - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Combinations: " + combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
