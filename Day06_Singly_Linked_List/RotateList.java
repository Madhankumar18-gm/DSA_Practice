/**
 * Problem 50: Rotate List (LeetCode 61)
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Algorithm:
 * 1. Calculate the length of the list N and find tail node.
 * 2. Connect tail.next to head to form a ring.
 * 3. Compute effective rotation k = k % N.
 * 4. Find new tail at position (N - k - 1) from head.
 * 5. Set new head = newTail.next and break the ring by setting newTail.next = null.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
