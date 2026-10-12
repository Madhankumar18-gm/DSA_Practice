package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    public static boolean validTreeDFS(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        if (hasCycle(0, -1, adj, visited)) return false;

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private static boolean hasCycle(int curr, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, curr, adj, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
