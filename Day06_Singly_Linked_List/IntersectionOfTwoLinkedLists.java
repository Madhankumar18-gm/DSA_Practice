/**
 * Problem 46: Intersection of Two Linked Lists (LeetCode 160)
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * 
 * Algorithm:
 * Two Pointers: pA starts at headA, pB starts at headB.
 * When pA reaches null, redirect it to headB.
 * When pB reaches null, redirect it to headA.
 * Both pointers traverse (lenA + lenB) steps and will meet at the intersection node or null.
 * 
 * Time Complexity: O(N + M)
 * Space Complexity: O(1) auxiliary space.
 */
public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
