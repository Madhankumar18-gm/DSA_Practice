import java.util.Arrays;
import java.util.Stack;

/**
 * Problem 16: Asteroid Collision
 * 
 * Find out the state of the asteroids after all collisions.
 */
public class AsteroidCollision {

    // Optimal Stack O(N) simulation
    public static int[] asteroidCollisionStack(int[] asteroids) {
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
        int[] asteroids = {5, 10, -5};
        System.out.println("Result: " + Arrays.toString(asteroidCollision(asteroids)));
    }
}
