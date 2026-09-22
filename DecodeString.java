/**
 * Problem 15: Decode String
 * 
 * Given an encoded string, return its decoded string: k[encoded_string] repeated k times.
 */
public class DecodeString {

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

    public static void main(String[] args) {
        String test = "3[a]2[bc]";
        System.out.println("Decoded: " + decodeString(test));
    }
}
