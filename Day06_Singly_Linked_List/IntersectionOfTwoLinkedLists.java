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
     * Finds the intersection node of two singly linked lists.
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

    public static void main(String[] args) {
        System.out.println("=== IntersectionOfTwoLinkedLists Execution Suite ===");

        // Test 1: Intersecting lists at node val 8
        ListNode common = buildList(new int[]{8, 4, 5});
        ListNode headA = buildList(new int[]{4, 1});
        ListNode headB = buildList(new int[]{5, 6, 1});

        headA.next.next = common;
        headB.next.next.next = common;

        ListNode intersect1 = getIntersectionNode(headA, headB);
        System.out.println("Test 1 Intersection Node Val: " + (intersect1 != null ? intersect1.val : "null"));
        assert intersect1 != null && intersect1.val == 8 : "Test 1 Failed!";

        // Test 2: Non-intersecting lists [2, 6, 4] and [1, 5]
        ListNode list1 = buildList(new int[]{2, 6, 4});
        ListNode list2 = buildList(new int[]{1, 5});
        ListNode intersect2 = getIntersectionNode(list1, list2);
        System.out.println("Test 2 Intersection Node Val: " + (intersect2 != null ? intersect2.val : "null"));
        assert intersect2 == null : "Test 2 Failed!";
    }
}
