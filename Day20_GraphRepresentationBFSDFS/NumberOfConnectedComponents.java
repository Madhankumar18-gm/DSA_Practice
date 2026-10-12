package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 323: Number of Connected Components in an Undirected Graph
 * 
 * Problem:
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between ai and bi in the graph.
 * Return the number of connected components in the graph.
 * 
 * Complexity:
 * - DFS / BFS Traversal: O(V + E) time, O(V + E) space.
 * - Disjoint Set Union (DSU / Union-Find): O(E * alpha(V)) time, O(V) space.
 */
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

    public static class UnionFind {
        private final int[] parent;
        private int count;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            parent[rootP] = rootQ;
            count--;
            return true;
        }

        public int getCount() {
            return count;
        }
    }

    public static int countComponentsUnionFind(int n, int[][] edges) {
        if (n <= 0) return 0;
        UnionFind uf = new UnionFind(n);
        if (edges != null) {
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        int[][] e1 = {{0, 1}, {1, 2}, {3, 4}};
        assert countComponentsDFS(5, e1) == 2 : "Test 1 Failed";
        assert countComponentsUnionFind(5, e1) == 2 : "UF Test 1 Failed";

        int[][] e2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        assert countComponentsDFS(5, e2) == 1 : "Test 2 Failed";
        assert countComponentsUnionFind(5, e2) == 1 : "UF Test 2 Failed";

        assert countComponentsUnionFind(4, new int[][]{}) == 4 : "Isolated vertices count";

        int[][] cycle = {{0, 1}, {1, 2}, {2, 0}};
        assert countComponentsUnionFind(3, cycle) == 1 : "Cycle component count";

        assert countComponentsDFS(1, new int[][]{}) == 1 : "Single node";
        assert countComponentsUnionFind(0, null) == 0 : "Zero vertices";

        System.out.println("Execution completed successfully for NumberOfConnectedComponents.");
    }
}
