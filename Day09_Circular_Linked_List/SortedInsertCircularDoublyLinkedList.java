package Day09_Circular_Linked_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedInsertCircularDoublyLinkedList {
    public static class Node {
        public int val;
        public Node next;
        public Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node sortedInsertNaive(Node head, int data) {
        List<Integer> list = new ArrayList<>();
        if (head != null) {
            Node curr = head;
            do {
                list.add(curr.val);
                curr = curr.next;
            } while (curr != head);
        }
        list.add(data);
        Collections.sort(list);

        Node newHead = new Node(list.get(0));
        Node prev = newHead;
        for (int i = 1; i < list.size(); i++) {
            Node node = new Node(list.get(i));
            prev.next = node;
            node.prev = prev;
            prev = node;
        }
        prev.next = newHead;
        newHead.prev = prev;
        return newHead;
    }
}
