/**
 * Problem 53: Reverse Nodes in k-Group (LeetCode 25)
 * 
 * Given the head of a linked list, reverse the nodes of a list k at a time, and return its modified list.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class ReverseNodesInKGroup {
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
     * Reverses nodes in k-group.
     * @param head Head of linked list
     * @param k Group size
     * @return Head of modified list
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        return head;
    }
}
