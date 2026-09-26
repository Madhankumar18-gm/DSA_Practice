/**
 * Problem 49: Partition List (LeetCode 86)
 * 
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class PartitionList {
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
     * Partitions a linked list around value x.
     * @param head Head of linked list
     * @param x Partition pivot value
     * @return Head of partitioned list
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                before.next = curr;
                before = before.next;
            } else {
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public static void main(String[] args) {
        System.out.println("=== PartitionList Execution Suite ===");

        // Test 1: [1, 4, 3, 2, 5, 2], x = 3 -> [1, 2, 2, 4, 3, 5]
        ListNode l1 = buildList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode res1 = partition(l1, 3);
        System.out.println("Test 1 Result: " + toListString(res1));
        assert toListString(res1).equals("[1, 2, 2, 4, 3, 5]") : "Test 1 Failed!";

        // Test 2: [2, 1], x = 2 -> [1, 2]
        ListNode l2 = buildList(new int[]{2, 1});
        ListNode res2 = partition(l2, 2);
        System.out.println("Test 2 Result: " + toListString(res2));
        assert toListString(res2).equals("[1, 2]") : "Test 2 Failed!";
    }
}
