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
            prev.next = curr.next; // Eliminate current node
            curr = prev.next;
        }

        return curr.val;
    }
}
