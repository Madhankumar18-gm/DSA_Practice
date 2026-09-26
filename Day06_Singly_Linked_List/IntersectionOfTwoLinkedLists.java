/**
 * Problem 46: Intersection of Two Linked Lists (LeetCode 160)
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
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

    public static ListNode buildList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static String toListString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Finds the intersection node of two singly linked lists using dual pointer redirection.
     * Refactored for clear loop termination on equal references.
     * @param headA Head of first list
     * @param headB Head of second list
     * @return Intersecting ListNode or null if no intersection
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : headB;
            p2 = (p2 != null) ? p2.next : headA;
        }

        return p1;
    }
}
