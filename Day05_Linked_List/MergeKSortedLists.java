import java.util.PriorityQueue;

/**
 * Problem 44: Merge k Sorted Lists (LeetCode 23)
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 * Time Complexity: O(N log K) where N is total nodes and K is number of linked lists.
 * Space Complexity: O(K) for PriorityQueue min-heap storage.
 */
public class MergeKSortedLists {
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
     * Merges K sorted linked lists.
     * @param lists Array of sorted linked list heads
     * @return Head of merged sorted linked list
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== MergeKSortedLists Execution Suite ===");

        // Test 1: [[1,4,5], [1,3,4], [2,6]] -> [1,1,2,3,4,4,5,6]
        ListNode[] lists = new ListNode[]{
            buildList(new int[]{1, 4, 5}),
            buildList(new int[]{1, 3, 4}),
            buildList(new int[]{2, 6})
        };
        ListNode merged1 = mergeKLists(lists);
        System.out.println("Test 1 Merged K Lists: " + toListString(merged1));
    }
}
