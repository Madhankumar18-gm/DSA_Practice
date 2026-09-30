package Day10_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 87: First Non-Repeating Character in a Stream
 * Stream processing using Queue and Frequency Map in O(N) time.
 */
public class FirstNonRepeatingCharacterInStream {
    public static String firstNonRepeatingNaive(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            char first = '#';
            for (int j = 0; j <= i; j++) {
                if (freq[str.charAt(j) - 'a'] == 1) {
                    first = str.charAt(j);
                    break;
                }
            }
            sb.append(first);
        }
        return sb.toString();
    }
    public static String firstNonRepeatingOptimal(String str) {
        if (str == null || str.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
            queue.offer(ch);
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            sb.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        assert firstNonRepeatingNaive("aabc").equals("a#bb");
        assert firstNonRepeatingOptimal("aabc").equals("a#bb");
        assert firstNonRepeatingOptimal("aac").equals("a#c");
        assert firstNonRepeatingOptimal("zz").equals("z#");
        assert firstNonRepeatingOptimal("").equals("");
        System.out.println("Execution completed successfully for FirstNonRepeatingCharacterInStream.");
    }
}
