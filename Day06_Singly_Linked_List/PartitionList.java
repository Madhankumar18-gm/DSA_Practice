/**
 * Problem 49: Partition List (LeetCode 86)
 * 
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * Preserve original relative order of nodes in each of the two partitions.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space (using two dummy buckets).
 */
public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
