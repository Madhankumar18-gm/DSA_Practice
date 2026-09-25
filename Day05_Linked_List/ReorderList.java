/**
 * Problem 41: Reorder List (LeetCode 143)
 * 
 * Reorder list to L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...
 * 
 * Algorithm:
 * 1. Find middle of list using fast/slow pointers.
 * 2. Reverse the second half of the list.
 * 3. Merge the first half and reversed second half in an alternating pattern.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) in-place modification.
 */
public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
