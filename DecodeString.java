/**
 * Problem 15: Decode String
 * 
 * Given an encoded string, return its decoded string: k[encoded_string] repeated k times.
 */
public class DecodeString {

    // Simple single-bracket expansion placeholder
    public static String decodeSimple(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) sb.append(ch);
        }
        return sb.toString();
    }

    public static String decodeString(String s) {
        return decodeSimple(s);
    }
}
