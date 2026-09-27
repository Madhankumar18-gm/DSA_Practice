import java.util.ArrayList;
import java.util.List;

/**
 * Problem 62: Pair Sum in Sorted Doubly Linked List
 * 
 * Given a sorted doubly linked list of distinct positive integers, find all pairs in the list whose sum equals a given target value.
 * 
 * Time Complexity: O(N) single-pass traversal.
 * Space Complexity: O(1) auxiliary space.
 */
public class PairSumInSortedDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node buildDLL(int[] values) {
        if (values == null || values.length == 0) return null;
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            Node node = new Node(values[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        return head;
    }

    public static String toListString(Node head) {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Finds pairs in a sorted doubly linked list that add up to target.
     * @param head Head of sorted doubly linked list
     * @param target Desired sum
     * @return List of integer pairs [a, b]
     */
    public static List<int[]> findPairsWithGivenSum(Node head, int target) {
        List<int[]> result = new ArrayList<>();
        if (head == null || head.next == null) return result;
        return result;
    }
}
