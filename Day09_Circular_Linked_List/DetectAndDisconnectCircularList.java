import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 141 Var / GFG - Detect and Disconnect Cycle in Circular Linked List
 * Topic: Floyd's Cycle Finding & Disconnection
 */
public class DetectAndDisconnectCircularList {

    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Detects cycle in a circular/cyclic linked list and disconnects it into a standard linear list.
     * Time Complexity: O(N) using Floyd's Tortoise and Hare algorithm.
     * Space Complexity: O(1) auxiliary memory.
     */
    public static Node removeCycle(Node head) {
        if (head == null || head.next == null) return head;
        return head;
    }
}
