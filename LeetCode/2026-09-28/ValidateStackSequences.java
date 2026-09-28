import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 946 - Validate Stack Sequences
 * Topic: Stack Simulation
 */
public class ValidateStackSequences {

    /**
     * Validates if popped sequence could be the result of a sequence of push & pop operations.
     * Time Complexity: O(N) where N is array length.
     * Space Complexity: O(N) for stack size.
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        
        // Stack to simulate push and pop operations
        Deque<Integer> stack = new ArrayDeque<>();
        int popIdx = 0;
        
        for (int val : pushed) {
            stack.push(val);
            while (!stack.isEmpty() && popIdx < popped.length && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }
        
        return stack.isEmpty();
    }

    public static void printValidation(int[] pushed, int[] popped, boolean valid) {
        System.out.println("Pushed: " + java.util.Arrays.toString(pushed) + ", Popped: " + java.util.Arrays.toString(popped) + " -> Valid: " + valid);
    }

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 946: Validate Stack Sequences ===");
        int[] pu1 = {1, 2, 3, 4, 5};
        int[] po1 = {4, 5, 3, 2, 1};
        boolean v1 = validateStackSequences(pu1, po1);
        printValidation(pu1, po1, v1);
        assert v1 : "Test 1 Failed! Expected true";

        int[] pu2 = {1, 2, 3, 4, 5};
        int[] po2 = {4, 3, 5, 1, 2};
        assert !validateStackSequences(pu2, po2) : "Test 2 Failed! Expected false";

        assert validateStackSequences(new int[]{}, new int[]{}) : "Empty arrays failed!";
        System.out.println("Execution completed successfully for Validate Stack Sequences.");
    }
}
