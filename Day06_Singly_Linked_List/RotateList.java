/**
 * Problem 50: Rotate List (LeetCode 61)
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class RotateList {
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
     * Rotates a linked list right by k places.
     * @param head Head of linked list
     * @param k Number of rotation positions
     * @return Head of rotated list
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        int effectiveK = k % length;
        if (effectiveK == 0) return head;

        oldTail.next = head;

        int stepsToNewTail = length - effectiveK - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("=== RotateList Execution Suite ===");

        // Test 1: [1, 2, 3, 4, 5], k = 2 -> [4, 5, 1, 2, 3]
        ListNode l1 = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode res1 = rotateRight(l1, 2);
        System.out.println("Test 1 Result: " + toListString(res1));
    }
}
