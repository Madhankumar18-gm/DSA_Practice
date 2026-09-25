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
     * Merges two sorted linked lists using dummy head pointer manipulation.
     * @param list1 First sorted list
     * @param list2 Second sorted list
     * @return Head of merged sorted list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== MergeTwoSortedLists Execution Suite ===");

        // Test 1: Merging [1, 2, 4] and [1, 3, 4] -> [1, 1, 2, 3, 4, 4]
        ListNode l1 = buildList(new int[]{1, 2, 4});
        ListNode l2 = buildList(new int[]{1, 3, 4});
        ListNode merged1 = mergeTwoLists(l1, l2);
        System.out.println("Test 1 Merged: " + toListString(merged1));
    }
}
