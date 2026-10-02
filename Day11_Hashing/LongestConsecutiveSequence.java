package Day11_Hashing;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveNaive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen = 1, currentLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentLen++;
                } else {
                    maxLen = Math.max(maxLen, currentLen);
                    currentLen = 1;
                }
            }
        }
        return Math.max(maxLen, currentLen);
    }
    public static void main(String[] args) {
        assert longestConsecutiveNaive(new int[]{100, 4, 200, 1, 3, 2}) == 4;
    }
}
