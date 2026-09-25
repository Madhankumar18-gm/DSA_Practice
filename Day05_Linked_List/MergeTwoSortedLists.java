/**
 * Problem 39: Merge Two Sorted Lists (LeetCode 21)
 * 
 * Merge two sorted linked lists and return it as a sorted list.
 * 
 * Time Complexity: O(N + M) where N and M are the lengths of list1 and list2.
 * Space Complexity: O(1) auxiliary space (iterative splicing).
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
