package Day10_Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 89: [LeetCode 950] Reveal Cards In Increasing Order
 * Simulates card deck ordering using a Queue of index positions.
 */
public class RevealCardsInIncreasingOrder {
    public static int[] deckRevealedIncreasingNaive(int[] deck) {
        if (deck == null || deck.length == 0) return new int[0];
        Arrays.sort(deck);
        int n = deck.length;
        int[] res = new int[n];
        boolean[] filled = new boolean[n];
        boolean skip = false;
        int i = 0, j = 0;
        while (i < n) {
            if (!filled[j]) {
                if (!skip) {
                    res[j] = deck[i++];
                    filled[j] = true;
                }
                skip = !skip;
            }
            j = (j + 1) % n;
        }
        return res;
    }
    public static int[] deckRevealedIncreasingOptimal(int[] deck) {
        if (deck == null || deck.length == 0) return new int[0];
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indexQueue.offer(i);
        }
        int[] result = new int[n];
        for (int card : deck) {
            result[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.offer(indexQueue.poll());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] res = deckRevealedIncreasingNaive(deck);
        assert Arrays.equals(res, new int[]{2, 13, 3, 11, 5, 17, 7});
        int[] resOpt = deckRevealedIncreasingOptimal(deck);
        assert Arrays.equals(resOpt, new int[]{2, 13, 3, 11, 5, 17, 7});
        int[] single = {1, 100};
        assert Arrays.equals(deckRevealedIncreasingOptimal(single), new int[]{1, 100});
        assert deckRevealedIncreasingOptimal(new int[0]).length == 0;
        System.out.println("Execution completed successfully for RevealCardsInIncreasingOrder.");
    }
}
