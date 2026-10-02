package Day11_Hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySumNaive(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }
    public static int subarraySumOptimal(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        assert subarraySumNaive(new int[]{1, 1, 1}, 2) == 2;
        assert subarraySumOptimal(new int[]{1, 1, 1}, 2) == 2;
    }
}
