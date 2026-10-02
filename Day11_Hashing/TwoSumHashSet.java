package Day11_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashSet {
    public static int[] twoSumNaive(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] res = twoSumNaive(new int[]{2, 7, 11, 15}, 9);
        assert Arrays.equals(res, new int[]{0, 1});
    }
}
