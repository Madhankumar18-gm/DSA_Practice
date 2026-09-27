/**
 * Problem 56: Flatten a Multilevel Doubly Linked List (LeetCode 430)
 * 
 * Given a doubly linked list where in addition to next and prev pointers, each node has a child pointer,
 * flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * 
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(1) auxiliary space.
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
                Node childTail = curr.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                childTail.next = nextTemp;
                if (nextTemp != null) {
                    nextTemp.prev = childTail;
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("=== FlattenMultilevelDoublyLinkedList Execution Suite ===");

        // Test 1: 1 <-> 2 <-> 3 with child at 2 pointing to 7 <-> 8
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n7.next = n8; n8.prev = n7;
        n2.child = n7;

        Node res1 = flatten(n1);
        System.out.println("Test 1 Result: " + toListString(res1));
    }
}
