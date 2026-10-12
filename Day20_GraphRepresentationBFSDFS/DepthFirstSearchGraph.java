package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchGraph {

    public static List<Integer> dfsRecursive(int vertices, List<List<Integer>> adj, int start) {
        List<Integer> order = new ArrayList<>();
        if (vertices <= 0 || adj == null || start < 0 || start >= vertices) return order;

        boolean[] visited = new boolean[vertices];
        dfsHelper(start, adj, visited, order);
        return order;
    }

    private static void dfsHelper(int u, List<List<Integer>> adj, boolean[] visited, List<Integer> order) {
        visited[u] = true;
        order.add(u);

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsHelper(v, adj, visited, order);
            }
        }
    }
}
