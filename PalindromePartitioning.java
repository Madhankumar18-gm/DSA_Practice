import java.util.ArrayList;
import java.util.List;

/**
 * Problem 25: Palindrome Partitioning
 * 
 * Given a string `s`, partition `s` such that every substring of the partition is a palindrome.
 * 
 * Time Complexity: O(N * 2^N) where N is string length.
 * Space Complexity: O(N) recursion call stack depth.
 */
public class PalindromePartitioning {

    /**
     * Finds all palindromic partitions using backtracking.
     * Time: O(N * 2^N), Space: O(N)
     */
    public static List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, String s, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(end + 1, s, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Partitions of 'aab': " + partition("aab"));
    }
}
