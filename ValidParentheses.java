import java.util.Stack;

/**
 * Problem 3: Valid Parentheses
 * 
 * Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * Time Complexity: O(N) where N is string length.
 * Space Complexity: O(N) for stack storage.
 */
public class ValidParentheses {

    /**
     * Validates parentheses matching using stack.
     * Time: O(N), Space: O(N)
     */
    public static boolean isValidStack(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        return isValidStack(s);
    }

    public static void main(String[] args) {
        String[] tests = {"()", "()[]{}", "(]", "([)]", "{[]}", ""};
        for (String test : tests) {
            System.out.println("String: \"" + test + "\" -> " + isValid(test));
        }
    }
}
