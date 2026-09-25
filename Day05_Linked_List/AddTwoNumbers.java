/**
 * Problem 43: Add Two Numbers (LeetCode 2)
 * 
 * Add two numbers represented as reverse linked lists.
 * 
 * Time Complexity: O(max(N, M)) where N and M are lengths of l1 and l2.
 * Space Complexity: O(max(N, M)) for the output list.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
