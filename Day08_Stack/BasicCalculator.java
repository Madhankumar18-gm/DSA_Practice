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

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 224: Basic Calculator ===");
        String e1 = "1 + 1";
        int ans1 = calculate(e1);
        printExpr(e1, ans1);
        assert ans1 == 2 : "Test 1 Failed!";

        assert calculate(" 2-1 + 2 ") == 3 : "Test 2 Failed!";
        assert calculate("(1+(4+5+2)-3)+(6+8)") == 23 : "Test 3 Failed!";
        assert calculate("- (3 + (4 + 5))") == -12 : "Negative parenthetical test failed!";
    }
}
