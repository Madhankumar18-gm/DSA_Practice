package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Depth First Search (DFS) for Graph Traversal & Cycle Detection
 * 
 * Mechanics:
 * - Explores deep into each branch before backtracking using recursive call stack or explicit LIFO Stack.
 * - Detects cycles in undirected graphs when encountering a visited neighbor that is not the parent.
 * 
 * Complexity:
 * - Time Complexity: O(V + E) where V is vertices, E is edges.
 * - Space Complexity: O(V) for recursion depth / stack and visited tracking.
 */
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

    public static List<Integer> dfsIterative(int vertices, List<List<Integer>> adj, int start) {
        List<Integer> order = new ArrayList<>();
        if (vertices <= 0 || adj == null || start < 0 || start >= vertices) return order;

        boolean[] visited = new boolean[vertices];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                order.add(u);

                List<Integer> neighbors = adj.get(u);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int v = neighbors.get(i);
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }

        return order;
    }

    public static boolean hasCycleUndirected(int vertices, List<List<Integer>> adj) {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (cycleDfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cycleDfs(int u, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (cycleDfs(v, u, adj, visited)) return true;
            } else if (v != parent) {
                return true;
            }
        }
        return false;
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

        List<Integer> iter = dfsIterative(4, adj, 2);
        assert iter.get(0) == 2 : "Iterative starts at 2";

        List<List<Integer>> undir = new ArrayList<>();
        for (int i = 0; i < 3; i++) undir.add(new ArrayList<>());
        undir.get(0).add(1); undir.get(1).add(0);
        undir.get(1).add(2); undir.get(2).add(1);
        undir.get(2).add(0); undir.get(0).add(2);
        assert hasCycleUndirected(3, undir) : "Triangle has cycle";

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < 3; i++) tree.add(new ArrayList<>());
        tree.get(0).add(1); tree.get(1).add(0);
        tree.get(1).add(2); tree.get(2).add(1);
        assert !hasCycleUndirected(3, tree) : "Tree has no cycle";

        assert dfsRecursive(0, null, 0).isEmpty() : "Empty vertices";
        assert !hasCycleUndirected(1, Collections.singletonList(Collections.emptyList())) : "Single vertex no cycle";

        System.out.println("Execution completed successfully for DepthFirstSearchGraph.");
    }
}
