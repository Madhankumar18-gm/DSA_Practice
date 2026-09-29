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

    public static Node sortedInsertOptimal(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        if (data < head.val) {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head && curr.next.val < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node head = sortedInsertNaive(null, 5);
        assert head.val == 5;
        assert head.next == head;
        assert head.prev == head;

        Node opt = sortedInsertOptimal(null, 10);
        opt = sortedInsertOptimal(opt, 20);
        opt = sortedInsertOptimal(opt, 15);
        opt = sortedInsertOptimal(opt, 5);

        assert opt.val == 5;
        assert opt.next.val == 10;
        assert opt.next.next.val == 15;
        assert opt.next.next.next.val == 20;
        assert opt.next.next.next.next == opt;
        assert opt.prev.val == 20;

        Node curr = opt;
        do {
            assert curr.next.prev == curr;
            assert curr.prev.next == curr;
            curr = curr.next;
        } while (curr != opt);
    }
}
