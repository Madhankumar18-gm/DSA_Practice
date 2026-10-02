package Day11_Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem 94: [LeetCode 128] Longest Consecutive Sequence
 * O(N) HashSet sequence boundary expansion algorithm.
 */
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
    public static int longestConsecutiveOptimal(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        assert longestConsecutiveNaive(new int[]{100, 4, 200, 1, 3, 2}) == 4;
        assert longestConsecutiveOptimal(new int[]{100, 4, 200, 1, 3, 2}) == 4;
        assert longestConsecutiveOptimal(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) == 9;
        assert longestConsecutiveOptimal(null) == 0;
        assert longestConsecutiveOptimal(new int[0]) == 0;
    }
}
