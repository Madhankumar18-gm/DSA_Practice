/**
 * Problem 58: Design Browser History (LeetCode 1472)
 * 
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * move back in history number of steps, or move forward in history number of steps.
 * 
 * Time Complexity: O(1) visit, O(min(steps, N)) back & forward.
 * Space Complexity: O(N) where N is number of visited pages.
 */
public class DesignBrowserHistory {
    public static class Node {
        String url;
        Node prev;
        Node next;
        Node(String url) {
            this.url = url;
        }
    }

    private Node curr;

    public DesignBrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}
