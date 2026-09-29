package Day09_Circular_Linked_List;

import java.util.ArrayList;
import java.util.List;

public class ReverseCircularLinkedList {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseNaive(Node head) {
        if (head == null || head.next == head) return head;
        List<Integer> list = new ArrayList<>();
        Node curr = head;
        do {
            list.add(curr.val);
            curr = curr.next;
        } while (curr != head);

        Node newHead = new Node(list.get(list.size() - 1));
        Node tail = newHead;
        for (int i = list.size() - 2; i >= 0; i--) {
            tail.next = new Node(list.get(i));
            tail = tail.next;
        }
        tail.next = newHead;
        return newHead;
    }
}
