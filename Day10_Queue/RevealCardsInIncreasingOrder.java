package Day10_Queue;

import java.util.Arrays;

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
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] res = deckRevealedIncreasingNaive(deck);
        assert Arrays.equals(res, new int[]{2, 13, 3, 11, 5, 17, 7});
    }
}
