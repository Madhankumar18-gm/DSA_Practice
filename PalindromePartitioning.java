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

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        return result;
    }
}
