import java.util.Stack;

/**
 * Problem 9: Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
 */
public class EvaluateReversePolishNotation {

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
        System.out.println("Null tokens guard:  " + evalRPN(null));
        System.out.println("Empty tokens guard: " + evalRPN(new String[]{}));
    }
}
