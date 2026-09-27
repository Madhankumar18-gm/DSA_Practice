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
}
