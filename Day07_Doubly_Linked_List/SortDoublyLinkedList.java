/**
 * Problem 61: Sort a Doubly Linked List (Merge Sort on DLL)
 * 
 * Given the head of an unsorted doubly linked list, sort it in ascending order using Merge Sort.
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(log N) recursion stack space.
 */
public class SortDoublyLinkedList {
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

    private static Node split(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        if (temp != null) temp.prev = null;
        return temp;
    }

    private static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        if (first.val < second.val) {
            first.next = merge(first.next, second);
            if (first.next != null) first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null) second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    /**
     * Sorts a doubly linked list using Merge Sort.
     * @param head Head of unsorted doubly linked list
     * @return Head of sorted doubly linked list
     */
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }
}
