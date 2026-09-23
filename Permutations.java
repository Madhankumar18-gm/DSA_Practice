import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem 20: Permutations
 * 
 * Given an array `nums` of distinct integers, return all the possible permutations.
 * 
 * Time Complexity: O(N * N!) since there are N! permutations each of length N.
 * Space Complexity: O(N) for recursion call stack depth.
 */
public class Permutations {

    /**
     * Generates all unique permutations of distinct integers.
     * Time: O(N * N!), Space: O(N)
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        backtrackSwap(0, list, result);
        return result;
    }

    private static void backtrackSwap(int first, List<Integer> list, List<List<Integer>> result) {
        if (first == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i < list.size(); i++) {
            Collections.swap(list, first, i);
            backtrackSwap(first + 1, list, result);
            Collections.swap(list, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Permutations: " + permute(new int[]{1, 2, 3}));
    }
}
