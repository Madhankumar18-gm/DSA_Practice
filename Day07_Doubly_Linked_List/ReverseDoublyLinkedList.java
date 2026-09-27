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
     * Reverses a doubly linked list in-place by swapping prev and next pointers.
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

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }
}
