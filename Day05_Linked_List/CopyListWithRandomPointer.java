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

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;

        while (curr != null) {
            curr.next = curr.next.next;
            copyCurr.next = (copyCurr.next != null) ? copyCurr.next.next : null;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        System.out.println("=== CopyListWithRandomPointer Execution Suite ===");

        // Test 1: Node 1 (val=7, random=null) -> Node 2 (val=13, random=Node 1)
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        n1.next = n2;
        n2.random = n1;

        Node copied1 = copyRandomList(n1);
        System.out.println("Original: " + toListString(n1));
        System.out.println("Copied:   " + toListString(copied1));
        assert copied1 != n1 : "Deep copy reference test failed!";
        assert copied1.random == null && copied1.next.random == copied1 : "Random pointer structure test failed!";

        // Test 2: Null head test
        Node copied2 = copyRandomList(null);
        assert copied2 == null : "Null test failed!";
        System.out.println("Test 2 Null list copy: " + toListString(copied2));
    }
}
