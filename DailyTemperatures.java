import java.util.Arrays;
import java.util.Stack;

/**
 * Problem 10: Daily Temperatures
 * 
 * Given an array of integers `temperatures`, return an array `answer` such that answer[i] is the number of days to wait.
 * 
 * Time Complexity: O(N) where N is array length.
 * Space Complexity: O(N) for stack storing indices.
 */
public class DailyTemperatures {

    /**
     * Calculates wait days using Monotonic Stack.
     * Time: O(N), Space: O(N)
     */
    public static int[] dailyTemperaturesStack(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }

        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return answer;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        return dailyTemperaturesStack(temperatures);
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Result: " + Arrays.toString(dailyTemperatures(temps)));
    }
}
