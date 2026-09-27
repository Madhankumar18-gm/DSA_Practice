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

    private static Node mergeIterative(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        Node dummy = new Node(0);
        Node curr = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first.prev = curr;
                first = first.next;
            } else {
                curr.next = second;
                second.prev = curr;
                second = second.next;
            }
            curr = curr.next;
        }

        if (first != null) {
            curr.next = first;
            first.prev = curr;
        }
        if (second != null) {
            curr.next = second;
            second.prev = curr;
        }

        Node result = dummy.next;
        if (result != null) result.prev = null;
        return result;
    }

    /**
     * Sorts a doubly linked list using Merge Sort with iterative merge helper.
     * @param head Head of unsorted doubly linked list
     * @return Head of sorted doubly linked list
     */
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return mergeIterative(head, second);
    }
}
