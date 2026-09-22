import java.util.Stack;

/**
 * Problem 15: Decode String
 * 
 * Given an encoded string, return its decoded string.
 */
public class DecodeString {

    public static String decodeStringStack(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static String decodeString(String s) {
        return decodeStringStack(s);
    }

    public static void main(String[] args) {
        System.out.println("3[a2[c]]: " + decodeString("3[a2[c]]")); // accaccacc
        System.out.println("2[abc]3[cd]ef: " + decodeString("2[abc]3[cd]ef"));
    }
}
