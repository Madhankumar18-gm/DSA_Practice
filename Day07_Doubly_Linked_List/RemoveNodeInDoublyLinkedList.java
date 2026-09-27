/**
 * Problem 60: Remove Node in a Doubly Linked List
 * 
 * Delete a node from a Doubly Linked List given a target value or position.
 * 
 * Algorithm:
 * Sentinel dummy nodes (dummyHead and dummyTail) are used to eliminate special head/tail edge cases.
 * 
 * Time Complexity: O(N) search + O(1) pointer unlink.
 * Space Complexity: O(1) auxiliary space.
 */
public class RemoveNodeInDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}
