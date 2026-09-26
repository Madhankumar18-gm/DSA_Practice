/**
 * Problem 51: Reverse Linked List II (LeetCode 92)
 * 
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Algorithm:
 * 1. Create a dummy head pointing to head.
 * 2. Advance prev pointer to node right before 'left' index.
 * 3. Use head-insertion loop to reverse (right - left) nodes in-place in a single pass.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
