import java.util.HashSet;
import java.util.Set;

/**
 * Problem 5: Longest Substring Without Repeating Characters
 * 
 * Given a string `s`, find the length of the longest substring without repeating characters.
 * 
 * Time Complexity: O(N) where N is string length.
 * Space Complexity: O(min(N, M)) where M is alphabet size.
 */
public class LongestSubstring {

    /**
     * Sliding Window approach using HashSet.
     * Time: O(N), Space: O(min(N, M))
     */
    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringSlidingWindow(s);
    }

    public static void main(String[] args) {
        System.out.println("=== LongestSubstring Execution Suite ===");
        String[] samples = {"abcabcbb", "bbbbb", "pwwkew", "au", "", " "};
        for (String str : samples) {
            System.out.println("  Input: \"" + str + "\" -> Longest Substring Length: " + lengthOfLongestSubstring(str));
        }
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
