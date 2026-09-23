import java.util.ArrayList;
import java.util.List;

/**
 * Problem 25: Palindrome Partitioning
 * 
 * Given a string `s`, partition `s` such that every substring of the partition is a palindrome.
 */
public class PalindromePartitioning {

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    // Optimal Backtracking O(N * 2^N) partition search
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

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) return result;
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Partitions of 'aab': " + partition("aab"));
    }
}
