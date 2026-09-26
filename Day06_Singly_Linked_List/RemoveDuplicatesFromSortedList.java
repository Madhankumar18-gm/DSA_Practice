/**
 * Problem 47: Remove Duplicates from Sorted List (LeetCode 83)
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * 
 * Time Complexity: O(N) single-pass.
 * Space Complexity: O(1) auxiliary space.
 */
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
