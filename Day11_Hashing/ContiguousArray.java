package Day11_Hashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLengthNaive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0, ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zeros++;
                else ones++;
                if (zeros == ones) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
    public static int findMaxLengthOptimal(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        assert findMaxLengthNaive(new int[]{0, 1}) == 2;
        assert findMaxLengthOptimal(new int[]{0, 1}) == 2;
        assert findMaxLengthOptimal(new int[]{0, 1, 0, 0, 1, 1, 0}) == 6;
    }
}
