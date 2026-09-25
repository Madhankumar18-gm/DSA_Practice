/**
 * Problem 42: Copy List with Random Pointer (LeetCode 138)
 * 
 * Construct a deep copy of a linked list where each node contains an extra random pointer.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static String toListString(Node head) {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append("[").append(curr.val).append(",")
              .append(curr.random != null ? curr.random.val : "null").append("]");
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Creates a deep copy of a list with random pointers using 3-Pass Interleaving.
     * @param head Head of original list
     * @return Head of deep copied list
     */
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Pass 1: Clone nodes and interleave
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Pass 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Pass 3: Decouple original and copied lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;
            Node nextOriginal = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr.next = nextOriginal;
            curr = nextOriginal;
        }

        return dummy.next;
    }
}
