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

    private static void unlinkNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    /**
     * Deletes the first node with the specified key value.
     * @param head Head of doubly linked list
     * @param key Target value to delete
     * @return Head of modified doubly linked list
     */
    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;

        if (head.val == key) {
            Node newHead = head.next;
            if (newHead != null) newHead.prev = null;
            return newHead;
        }

        Node curr = head;
        while (curr != null && curr.val != key) {
            curr = curr.next;
        }

        if (curr != null) {
            unlinkNode(curr);
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println("=== RemoveNodeInDoublyLinkedList Execution Suite ===");

        // Test 1: [10, 20, 30, 40], delete 30 -> [10, 20, 40]
        Node dll1 = buildDLL(new int[]{10, 20, 30, 40});
        Node res1 = deleteNode(dll1, 30);
        System.out.println("Test 1 Result: " + toListString(res1));
        assert toListString(res1).equals("[10, 20, 40]") : "Test 1 Failed!";

        // Test 2: Delete head [10, 20, 40], delete 10 -> [20, 40]
        Node res2 = deleteNode(res1, 10);
        System.out.println("Test 2 Result: " + toListString(res2));
        assert toListString(res2).equals("[20, 40]") : "Test 2 Failed!";

        // Test 3: Delete tail [20, 40], delete 40 -> [20]
        Node res3 = deleteNode(res2, 40);
        System.out.println("Test 3 Result: " + toListString(res3));
        assert toListString(res3).equals("[20]") : "Test 3 Failed!";

        System.out.println("=== All Tests Completed Successfully ===");
    }
}
