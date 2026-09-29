/**
 * LeetCode 1823 - Find the Winner of the Circular Game (Josephus Problem)
 * Topic: Circular Linked List Elimination Simulation
 */
public class FindWinnerOfCircularGame {

    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Simulates Josephus circular ring elimination to find the last remaining player.
     * Time Complexity: O(N * K) using explicit CLL ring.
     * Space Complexity: O(N) for N ring nodes.
     */
    public static int findTheWinner(int n, int k) {
        if (n <= 0) return 0;

        // Build circular linked list ring of players 1 to n
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            Node curr = new Node(i);
            prev.next = curr;
            prev = curr;
        }
        prev.next = head; // Close the circular ring

        Node curr = head;
        while (curr.next != curr) {
            for (int count = 1; count < k; count++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next; // Eliminate current node from ring
            curr = prev.next;
        }

        return curr.val;
    }

    public static void printGameWinner(int n, int k, int winner) {
        System.out.println("N=" + n + ", K=" + k + " -> Winner: " + winner);
    }

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 1823: Find Winner of Circular Game ===");
        int w1 = findTheWinner(5, 2);
        printGameWinner(5, 2, w1);
        assert w1 == 3 : "Test 1 Failed! Expected 3";

        int w2 = findTheWinner(6, 5);
        assert w2 == 1 : "Test 2 Failed! Expected 1";

        assert findTheWinner(1, 1) == 1 : "Single player test failed!";
        System.out.println("Execution completed successfully for Find Winner of Circular Game.");
    }
}
