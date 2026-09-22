import java.util.HashSet;
import java.util.Set;

/**
 * Problem 5: Longest Substring Without Repeating Characters
 * 
 * Given a string `s`, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstringBruteForce(String s) {
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringBruteForce(s);
    }
}
