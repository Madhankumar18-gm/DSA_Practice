import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 316 - Remove Duplicate Letters
 * Topic: Monotonic Stack + Character Frequency
 */
public class RemoveDuplicateLetters {

    /**
     * Removes duplicate letters so every letter appears once and result is lexicographically smallest.
     * Time Complexity: O(N) where N is string length.
     * Space Complexity: O(1) auxiliary space (26 alphabet characters).
     */
    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] visited = new boolean[26];
        // Monotonic character stack maintains lexicographical order
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            if (visited[idx]) {
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }
            
            stack.push(ch);
            visited[idx] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void printResult(String s, String res) {
        System.out.println("Input: \"" + s + "\" -> Result: \"" + res + "\"");
    }

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 316: Remove Duplicate Letters ===");
        String s1 = "bcabc";
        String res1 = removeDuplicateLetters(s1);
        printResult(s1, res1);
        assert res1.equals("abc") : "Test 1 Failed! Expected 'abc'";

        String s2 = "cbacdcbc";
        String res2 = removeDuplicateLetters(s2);
        assert res2.equals("acdb") : "Test 2 Failed! Expected 'acdb'";
    }
}
