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
     * Creates a deep copy of a list with random pointers.
     * @param head Head of original list
     * @return Head of deep copied list
     */
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        return null;
    }
}
