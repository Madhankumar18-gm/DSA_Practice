import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 141 Var / GFG - Detect and Disconnect Cycle in Circular Linked List
 * Topic: Floyd's Cycle Finding & Disconnection
 */
public class DetectAndDisconnectCircularList {

    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Detects cycle in a circular/cyclic linked list and disconnects it into a standard linear list.
     * Time Complexity: O(N) using Floyd's Tortoise and Hare algorithm.
     * Space Complexity: O(1) auxiliary memory.
     */
    public static Node removeCycle(Node head) {
        if (head == null || head.next == null) return head;

        // Phase 1: Detect cycle with fast and slow pointers
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return head;

        // Phase 2: Locate cycle start and set trailing pointer to null
        slow = head;
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Break circular ring at head
            return head;
        }

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null; // Disconnect cycle
        return head;
    }

    public static List<Integer> toList(Node head) {
        List<Integer> list = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Detect and Disconnect Circular List ===");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3; n3.next = n1;

        Node linearHead = removeCycle(n1);
        System.out.println("Disconnected Linear List: " + toList(linearHead));
        assert toList(linearHead).toString().equals("[1, 2, 3]") : "CLL disconnect test failed!";

        Node l1 = new Node(10); Node l2 = new Node(20);
        l1.next = l2; // linear list
        assert toList(removeCycle(l1)).toString().equals("[10, 20]") : "Linear list no-op test failed!";
        System.out.println("Execution completed successfully for Detect and Disconnect Circular List.");
    }
}
