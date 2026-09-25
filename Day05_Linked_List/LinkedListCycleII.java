/**
 * Problem 38: Linked List Cycle II (LeetCode 142)
 * 
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * 
 * Mathematical Proof:
 * Distance traveled by slow = L1 + L2
 * Distance traveled by fast = L1 + L2 + n*C = 2 * (L1 + L2)
 * => L1 = n*C - L2
 * Thus, resetting slow to head and moving both slow and fast by 1 step meets at the cycle start.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
