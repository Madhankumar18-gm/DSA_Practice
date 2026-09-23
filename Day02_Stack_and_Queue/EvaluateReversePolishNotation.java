import java.util.Stack;

/**
 * Problem 9: Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
 * 
 * Time Complexity: O(N) scanning tokens once.
 * Space Complexity: O(N) for stack storage of operands.
 */
public class EvaluateReversePolishNotation {

    /**
     * Evaluates RPN expressions using Stack.
     * Time: O(N), Space: O(N)
     */
    public static int evalRPNStack(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token == null) continue;
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    public static int evalRPN(String[] tokens) {
        return evalRPNStack(tokens);
    }

    public static void main(String[] args) {
        System.out.println("=== EvaluateReversePolishNotation Execution Suite ===");
        String[] expr1 = {"2", "1", "+", "3", "*"};
        System.out.println("[\"2\", \"1\", \"+\", \"3\", \"*\"] -> " + evalRPN(expr1));

        String[] expr2 = {"4", "13", "5", "/", "+"};
        System.out.println("[\"4\", \"13\", \"5\", \"/\", \"+\"] -> " + evalRPN(expr2));

        String[] expr3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Complex Expression -> " + evalRPN(expr3));
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
