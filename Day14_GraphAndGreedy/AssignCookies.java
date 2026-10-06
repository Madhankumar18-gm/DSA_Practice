package Day14_GraphAndGreedy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildrenSorting(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
    public static int findContentChildrenOptimal(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int cookieIdx = 0;
        while (content < g.length && cookieIdx < s.length) {
            if (s[cookieIdx] >= g[content]) {
                content++;
            }
            cookieIdx++;
        }
        return content;
    }
    public static void main(String[] args) {
        assert findContentChildrenSorting(new int[]{1, 2, 3}, new int[]{1, 1}) == 1;
    }
}
