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

    private static ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    /**
     * Reverses nodes in k-group.
     * @param head Head of linked list
     * @param k Group size
     * @return Head of modified list
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== ReverseNodesInKGroup Execution Suite ===");

        // Test 1: [1, 2, 3, 4, 5], k = 2 -> [2, 1, 4, 3, 5]
        ListNode l1 = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode res1 = reverseKGroup(l1, 2);
        System.out.println("Test 1 Result: " + toListString(res1));
        assert toListString(res1).equals("[2, 1, 4, 3, 5]") : "Test 1 Failed!";

        // Test 2: [1, 2, 3, 4, 5], k = 3 -> [3, 2, 1, 4, 5]
        ListNode l2 = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode res2 = reverseKGroup(l2, 3);
        System.out.println("Test 2 Result: " + toListString(res2));
        assert toListString(res2).equals("[3, 2, 1, 4, 5]") : "Test 2 Failed!";
    }
}
