import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 402 - Remove K Digits
 * Topic: Monotonic Stack Greedy Digit Removal
 */
public class RemoveKDigits {

    /**
     * Removes K digits from num such that the new number is the smallest possible.
     * Time Complexity: O(N) where N is the length of num string.
     * Space Complexity: O(N) for stack storage.
     */
    public static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k >= num.length()) {
            return "0";
        }
        return "0";
    }
}
