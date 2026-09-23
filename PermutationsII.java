import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem 21: Permutations II
 * 
 * Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {

    // Naive HashSet deduplication
    public static List<List<Integer>> permuteUniqueNaive(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        // Deduplication container
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUniqueNaive(nums);
    }
}
