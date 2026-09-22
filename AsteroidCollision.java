import java.util.Arrays;

/**
 * Problem 16: Asteroid Collision
 * 
 * Find out the state of the asteroids after all collisions.
 */
public class AsteroidCollision {

    public static int[] asteroidCollisionNaive(int[] asteroids) {
        return asteroids;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        return asteroidCollisionNaive(asteroids);
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println("Result: " + Arrays.toString(asteroidCollision(asteroids)));
    }
}
