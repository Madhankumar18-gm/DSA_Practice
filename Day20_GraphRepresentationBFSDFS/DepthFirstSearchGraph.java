package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(2));
        adj.get(2).addAll(Arrays.asList(0, 3));
        adj.get(3).addAll(Arrays.asList(3));

        List<Integer> res = dfsRecursive(4, adj, 2);
        assert res.get(0) == 2 : "Starts at 2";
        assert res.size() == 4 : "Visits all reachable nodes";
    }
}
