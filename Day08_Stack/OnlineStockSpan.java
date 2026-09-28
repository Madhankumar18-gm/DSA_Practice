import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 901 - Online Stock Span
 * Topic: Dynamic Monotonic Stack
 */
public class OnlineStockSpan {

    private Deque<int[]> stack;

    /**
     * Initializes the StockSpanner object with a monotonic stack.
     * Time Complexity: O(1) amortized per next() call.
     * Space Complexity: O(N) worst case.
     */
    public OnlineStockSpan() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int currentSpan = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            currentSpan += stack.pop()[1];
        }
        stack.push(new int[]{price, currentSpan});
        return currentSpan;
    }
}
