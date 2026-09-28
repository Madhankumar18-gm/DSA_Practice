import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 224 - Basic Calculator
 * Topic: Stack Expression Evaluation
 */
public class BasicCalculator {

    /**
     * Evaluates a mathematical expression string containing +, -, (, ), and non-negative integers.
     * Time Complexity: O(N) where N is string length.
     * Space Complexity: O(N) for recursion/stack depth.
     */
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result += sign * val;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
        }
        
        return result;
    }

    public static void printExpr(String expr, int ans) {
        System.out.println("Expr: \"" + expr + "\" = " + ans);
    }
}
