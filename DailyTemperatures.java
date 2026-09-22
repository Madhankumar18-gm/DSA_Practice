import java.util.Arrays;

/**
 * Problem 10: Daily Temperatures
 * 
 * Given an array of integers `temperatures`, return an array `answer` such that answer[i] is the number of days to wait.
 */
public class DailyTemperatures {

    // Brute Force O(N^2) time complexity
    public static int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        return dailyTemperaturesBruteForce(temperatures);
    }
}
