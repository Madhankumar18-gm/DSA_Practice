/**
 * Problem 43: Add Two Numbers (LeetCode 2)
 * 
 * Add two numbers represented as reverse linked lists.
 * 
 * Time Complexity: O(max(N, M)) where N and M are lengths of l1 and l2.
 * Space Complexity: O(max(N, M)) for the output list.
 */
public class AddTwoNumbers {
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
     * Adds two numbers stored in reverse order.
     * @param l1 First number list
     * @param l2 Second number list
     * @return Head of sum linked list
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== AddTwoNumbers Execution Suite ===");

        // Test 1: [2, 4, 3] + [5, 6, 4] -> [7, 0, 8] (342 + 465 = 807)
        ListNode l1 = buildList(new int[]{2, 4, 3});
        ListNode l2 = buildList(new int[]{5, 6, 4});
        ListNode sum1 = addTwoNumbers(l1, l2);
        System.out.println("Test 1 Result: " + toListString(sum1));
        assert toListString(sum1).equals("[7, 0, 8]") : "Test 1 Failed!";

        // Test 2: [0] + [0] -> [0]
        ListNode l3 = buildList(new int[]{0});
        ListNode l4 = buildList(new int[]{0});
        ListNode sum2 = addTwoNumbers(l3, l4);
        System.out.println("Test 2 Result: " + toListString(sum2));
        assert toListString(sum2).equals("[0]") : "Test 2 Failed!";

        // Test 3: [9, 9, 9, 9, 9, 9, 9] + [9, 9, 9, 9] -> [8, 9, 9, 9, 0, 0, 0, 1]
        ListNode l5 = buildList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l6 = buildList(new int[]{9, 9, 9, 9});
        ListNode sum3 = addTwoNumbers(l5, l6);
        System.out.println("Test 3 Result: " + toListString(sum3));
        assert toListString(sum3).equals("[8, 9, 9, 9, 0, 0, 0, 1]") : "Test 3 Failed!";
    }
}
