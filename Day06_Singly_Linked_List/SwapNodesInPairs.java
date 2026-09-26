/**
 * Problem 52: Swap Nodes in Pairs (LeetCode 24)
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed).
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space (iterative dummy node manipulation).
 */
public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
