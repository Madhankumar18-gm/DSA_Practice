/**
 * Problem 57: Reverse a Doubly Linked List
 * 
 * Given the head of a doubly linked list, reverse the list in-place such that head becomes tail and vice versa.
 * 
 * Algorithm:
 * Traverse through the list, swapping prev and next pointers for each node.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) in-place modification.
 */
public class ReverseDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}
