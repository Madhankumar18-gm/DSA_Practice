/**
 * Problem 36: Middle of the Linked List (LeetCode 876)
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * Time Complexity: O(N) where N is the number of nodes.
 * Space Complexity: O(1) auxiliary space.
 */
public class MiddleOfLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
