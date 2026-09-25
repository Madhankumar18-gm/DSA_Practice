/**
 * Problem 40: Remove Nth Node From End of List (LeetCode 19)
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Time Complexity: O(N) single-pass.
 * Space Complexity: O(1) using two pointers with an n-node gap.
 */
public class RemoveNthNodeFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
