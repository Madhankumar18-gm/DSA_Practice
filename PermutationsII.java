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

    public static List<List<Integer>> permuteUniqueNaive(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUniqueNaive(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println("Unique Permutations: " + permuteUnique(nums).size());
    }
}
