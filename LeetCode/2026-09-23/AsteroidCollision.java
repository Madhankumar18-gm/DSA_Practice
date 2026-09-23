import java.util.Arrays;
import java.util.Stack;

/**
 * Problem 16: Asteroid Collision
 * 
 * Find out the state of the asteroids after all collisions.
 * 
 * Time Complexity: O(N) each asteroid pushed/popped at most once.
 * Space Complexity: O(N) for stack storing surviving asteroids.
 */
public class AsteroidCollision {

    /**
     * Simulates asteroid collision using Stack.
     * Time: O(N), Space: O(N)
     */
    public static int[] asteroidCollisionStack(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            boolean exploded = false;
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -a) {
                    stack.pop();
                }
                exploded = true;
                break;
            }
            if (!exploded) {
                stack.push(a);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        return asteroidCollisionStack(asteroids);
    }

    public static void main(String[] args) {
        System.out.println("=== AsteroidCollision Execution Suite ===");
        System.out.println("Input [5, 10, -5]:    " + Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println("Input [8, -8]:        " + Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println("Input [10, 2, -5]:    " + Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
        System.out.println("Input [-2, -1, 1, 2]: " + Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println("=== All Tests Completed Successfully ===");
    }
}
