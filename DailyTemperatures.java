import java.util.Arrays;
import java.util.Stack;

/**
 * Problem 10: Daily Temperatures
 * 
 * Given an array of integers `temperatures`, return an array `answer` such that answer[i] is the number of days to wait.
 */
public class DailyTemperatures {

    public static int[] dailyTemperaturesStack(int[] temperatures) {
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
        int[] test1 = {30, 40, 50, 60};
        System.out.println("Strictly Increasing: " + Arrays.toString(dailyTemperatures(test1)));

        int[] test2 = {30, 20, 10};
        System.out.println("Strictly Decreasing: " + Arrays.toString(dailyTemperatures(test2)));
    }
}
