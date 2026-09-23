import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 23: Combination Sum
 * 
 * Given an array of distinct integers `candidates` and a `target`, return all unique combinations.
 */
public class CombinationSum {

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

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || target <= 0) return result;
        Arrays.sort(candidates);
        backtrackPruned(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Impossible Target Test: " + combinationSum(new int[]{2}, 1));
    }
}
