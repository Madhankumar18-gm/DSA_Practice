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
        // Accumulate span for prices <= current price
        int currentSpan = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            currentSpan += stack.pop()[1];
        }
        stack.push(new int[]{price, currentSpan});
        return currentSpan;
    }

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 901: Online Stock Span ===");
        OnlineStockSpan stockSpanner = new OnlineStockSpan();
        
        assert stockSpanner.next(100) == 1;
        assert stockSpanner.next(80) == 1;
        assert stockSpanner.next(60) == 1;
        assert stockSpanner.next(70) == 2;
        assert stockSpanner.next(60) == 1;
        assert stockSpanner.next(75) == 4;
        assert stockSpanner.next(85) == 6;

        OnlineStockSpan spanner2 = new OnlineStockSpan();
        assert spanner2.next(30) == 1;
        assert spanner2.next(30) == 2;
        assert spanner2.next(30) == 3;
        System.out.println("Execution completed successfully for Online Stock Span.");
    }
}
