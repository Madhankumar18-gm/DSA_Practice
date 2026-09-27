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
        curr = curr.next;
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

    public static void main(String[] args) {
        System.out.println("=== DesignBrowserHistory Execution Suite ===");

        DesignBrowserHistory browser = new DesignBrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");

        String b1 = browser.back(1);
        System.out.println("back(1): " + b1);
        assert b1.equals("facebook.com") : "Test 1 Failed!";

        String b2 = browser.back(1);
        System.out.println("back(1): " + b2);
        assert b2.equals("google.com") : "Test 2 Failed!";

        String f1 = browser.forward(1);
        System.out.println("forward(1): " + f1);
        assert f1.equals("facebook.com") : "Test 3 Failed!";

        browser.visit("linkedin.com"); // clears forward history (youtube.com)
        String f2 = browser.forward(2); // stays at linkedin.com
        System.out.println("forward(2): " + f2);
        assert f2.equals("linkedin.com") : "Test 4 Failed!";

        System.out.println("=== All Tests Completed Successfully ===");
    }
}
