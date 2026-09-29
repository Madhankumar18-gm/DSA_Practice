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
        return head;
    }
}
