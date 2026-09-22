import java.util.Stack;

/**
 * Problem 9: Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
 */
public class EvaluateReversePolishNotation {

    public static int evalRPNStack(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
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
        return stack.pop();
    }

    public static int evalRPN(String[] tokens) {
        return evalRPNStack(tokens);
    }

    public static void main(String[] args) {
        String[] expr1 = {"4", "13", "5", "/", "+"};
        System.out.println("Expr 1 Result: " + evalRPN(expr1));

        String[] expr2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Expr 2 Result: " + evalRPN(expr2));
    }
}
