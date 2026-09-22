/**
 * Problem 3: Valid Parentheses
 * 
 * Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 */
public class ValidParentheses {
    public static boolean isValidNaive(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.isEmpty();
    }

    public static boolean isValid(String s) {
        return isValidNaive(s);
    }

    public static void main(String[] args) {
        String test1 = "()[]{}";
        System.out.println("Is '" + test1 + "' valid? " + isValid(test1));
    }
}
