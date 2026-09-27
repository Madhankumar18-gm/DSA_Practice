/**
 * Problem 57: Reverse a Doubly Linked List
 * 
 * Given the head of a doubly linked list, reverse the list in-place.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) in-place modification.
 */
public class ReverseDoublyLinkedList {
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
     * Reverses a doubly linked list in-place.
     * @param head Head of doubly linked list
     * @return New head of reversed doubly linked list
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = null;
        Node curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        return temp.prev;
    }

    public static void main(String[] args) {
        System.out.println("=== ReverseDoublyLinkedList Execution Suite ===");

        // Test 1: [1, 2, 3, 4] -> [4, 3, 2, 1]
        Node dll1 = buildDLL(new int[]{1, 2, 3, 4});
        Node rev1 = reverse(dll1);
        System.out.println("Test 1 Result: " + toListString(rev1));
        assert toListString(rev1).equals("[4, 3, 2, 1]") : "Test 1 Failed!";

        // Test 2: [1] -> [1]
        Node dll2 = buildDLL(new int[]{1});
        Node rev2 = reverse(dll2);
        System.out.println("Test 2 Result: " + toListString(rev2));
        assert toListString(rev2).equals("[1]") : "Test 2 Failed!";
    }
}
