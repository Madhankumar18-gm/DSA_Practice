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

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 402: Remove K Digits ===");
        String n1 = "1432219";
        int k1 = 3;
        String res1 = removeKdigits(n1, k1);
        printKDigitsResult(n1, k1, res1);
        assert res1.equals("1219") : "Test 1 Failed! Expected '1219'";

        assert removeKdigits("10200", 1).equals("200") : "Test 2 Failed! Expected '200'";
        assert removeKdigits("10", 2).equals("0") : "Test 3 Failed! Expected '0'";

        assert removeKdigits("9", 1).equals("0") : "Single digit k=1 failed!";
        assert removeKdigits("112", 1).equals("11") : "Repeated digits failed!";
        System.out.println("Execution completed successfully for Remove K Digits.");
    }
}
