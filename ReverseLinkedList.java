/**
 * Problem 2: Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseListIterative(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedSubproblem = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reversedSubproblem;
    }

    public static ListNode reverseList(ListNode head) {
        return reverseListIterative(head);
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("EMPTY_LIST");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Iterative Reversal ---");
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        printList(reverseListIterative(list1));

        System.out.println("--- Testing Single Node & Null ---");
        printList(reverseListIterative(new ListNode(99)));
        printList(reverseListIterative(null));
    }
}
