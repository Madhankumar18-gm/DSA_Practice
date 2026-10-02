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
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] res = twoSumNaive(new int[]{2, 7, 11, 15}, 9);
        assert Arrays.equals(res, new int[]{0, 1});
        int[] opt = twoSumOptimal(new int[]{2, 7, 11, 15}, 9);
        assert Arrays.equals(opt, new int[]{0, 1});
    }
}
