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
}
