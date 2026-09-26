/**
 * Problem 53: Reverse Nodes in k-Group (LeetCode 25)
 * 
 * Given the head of a linked list, reverse the nodes of a list k at a time, and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space (Hard difficulty linked list problem).
 */
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
