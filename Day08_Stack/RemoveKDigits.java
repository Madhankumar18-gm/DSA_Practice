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
        
        // Monotonic increasing stack to keep smaller digits upfront
        Deque<Character> stack = new ArrayDeque<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void printKDigitsResult(String num, int k, String res) {
        System.out.println("Num: \"" + num + "\", K: " + k + " -> Smallest Num: \"" + res + "\"");
    }
}
