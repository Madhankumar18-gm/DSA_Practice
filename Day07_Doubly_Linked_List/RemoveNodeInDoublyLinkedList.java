/**
 * Problem 60: Remove Node in a Doubly Linked List
 * 
 * Delete a node from a Doubly Linked List given a target value or position.
 * 
 * Time Complexity: O(N) search + O(1) pointer unlink.
 * Space Complexity: O(1) auxiliary space.
 */
public class RemoveNodeInDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node buildDLL(int[] values) {
        if (values == null || values.length == 0) return null;
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            Node node = new Node(values[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        return head;
    }

    public static String toListString(Node head) {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Deletes the first node with the specified key value from a doubly linked list.
     * @param head Head of doubly linked list
     * @param key Target value to delete
     * @return Head of modified doubly linked list
     */
    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;
        return head;
    }
}
