import java.util.ArrayList;
import java.util.List;

/**
 * Problem 9: Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
 */
public class EvaluateReversePolishNotation {

    // Naive List simulation
    public static int evalRPNNaive(String[] tokens) {
        List<String> list = new ArrayList<>();
        for (String t : tokens) list.add(t);

        int i = 0;
        while (list.size() > 1) {
            String token = list.get(i);
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = Integer.parseInt(list.get(i - 2));
                int b = Integer.parseInt(list.get(i - 1));
                int res = 0;
                if (token.equals("+")) res = a + b;
                else if (token.equals("-")) res = a - b;
                else if (token.equals("*")) res = a * b;
                else if (token.equals("/")) res = a / b;

                list.remove(i);
                list.remove(i - 1);
                list.set(i - 2, String.valueOf(res));
                i = 0;
            } else {
                i++;
            }
        }
        return Integer.parseInt(list.get(0));
    }

    public static int evalRPN(String[] tokens) {
        return evalRPNNaive(tokens);
    }
}
