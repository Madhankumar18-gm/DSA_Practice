/**
 * Problem 48: Remove Duplicates from Sorted List II (LeetCode 82)
 * 
 * Given the head of a sorted linked list, delete ALL nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Time Complexity: O(N) single-pass.
 * Space Complexity: O(1) auxiliary space (using dummy head & predecessor pointer).
 */
public class RemoveDuplicatesFromSortedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
