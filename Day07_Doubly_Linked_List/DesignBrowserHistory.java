public class DesignBrowserHistory {
    public static class Node {
        String url;
        Node prev;
        Node next;
        Node(String url) {
            this.url = url;
        }
    }
}
