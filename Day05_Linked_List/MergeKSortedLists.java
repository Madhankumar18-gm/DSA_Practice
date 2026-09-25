import java.util.PriorityQueue;

/**
 * Problem 44: Merge k Sorted Lists (LeetCode 23)
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 * Time Complexity: O(N log K) where N is total nodes and K is number of linked lists.
 * Space Complexity: O(K) for PriorityQueue min-heap storage.
 */
public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
