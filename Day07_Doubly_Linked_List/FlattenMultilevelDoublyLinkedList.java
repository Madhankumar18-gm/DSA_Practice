/**
 * Problem 56: Flatten a Multilevel Doubly Linked List (LeetCode 430)
 * 
 * Given a doubly linked list where in addition to next and prev pointers, each node has a child pointer,
 * flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * 
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(N) recursion stack space in worst case.
 */
public class FlattenMultilevelDoublyLinkedList {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int val) {
            this.val = val;
        }
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
     * Flattens a multilevel doubly linked list into a single-level doubly linked list.
     * @param head Head of multilevel doubly linked list
     * @return Head of flattened doubly linked list
     */
    public static Node flatten(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node nextTemp = curr.next;
                Node childHead = flatten(curr.child);

                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                Node tail = childHead;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = nextTemp;
                if (nextTemp != null) {
                    nextTemp.prev = tail;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
