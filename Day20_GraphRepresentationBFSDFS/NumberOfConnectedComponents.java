package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {

    public static int countComponentsDFS(int n, int[][] edges) {
        if (n <= 0) return 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        if (edges != null) {
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    private static void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}
