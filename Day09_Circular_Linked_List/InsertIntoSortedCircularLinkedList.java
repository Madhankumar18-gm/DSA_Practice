import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 708 - Insert into a Sorted Circular Linked List
 * Topic: Circular Linked List Traversal & Insertion
 */
public class InsertIntoSortedCircularLinkedList {

    public static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    /**
     * Inserts a value into a sorted circular linked list while maintaining sorted order.
     * Time Complexity: O(N) where N is number of nodes.
     * Space Complexity: O(1) auxiliary memory.
     */
    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                toInsert = true;
            } else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    toInsert = true;
                }
            }

            if (toInsert) {
                prev.next = new Node(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        prev.next = new Node(insertVal, curr);
        return head;
    }

    public static List<Integer> toList(Node head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) return list;
        Node curr = head;
        do {
            list.add(curr.val);
            curr = curr.next;
        } while (curr != head);
        return list;
    }
}
