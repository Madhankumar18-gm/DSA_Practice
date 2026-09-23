import java.util.ArrayList;
import java.util.List;

/**
 * Problem 23: Combination Sum
 * 
 * Given an array of distinct integers `candidates` and a `target`, return all unique combinations.
 */
public class CombinationSum {

    private static void backtrackBasic(int start, int[] candidates, int remain, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remain < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrackBasic(i, candidates, remain - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        backtrackBasic(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
}
