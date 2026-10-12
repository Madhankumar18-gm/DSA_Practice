package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 261: Graph Valid Tree
 * 
 * Problem:
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 * A tree is an undirected graph in which any two vertices are connected by exactly one path:
 * 1. Must have exactly n - 1 edges.
 * 2. Must be fully connected.
 * 3. Must be acyclic.
 * 
 * Complexity:
 * - DFS: O(V + E) time, O(V + E) space.
 * - Union-Find: O(E * alpha(V)) time, O(V) space.
 */
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

    public static boolean validTreeUnionFind(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e : edges) {
            int rootU = find(parent, e[0]);
            int rootV = find(parent, e[1]);
            if (rootU == rootV) return false;
            parent[rootU] = rootV;
        }

        return true;
    }

    private static int find(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        int[][] e1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        assert validTreeDFS(5, e1) : "Test 1 Valid Tree Failed";
        assert validTreeUnionFind(5, e1) : "UF Test 1 Valid Tree Failed";

        int[][] e2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        assert !validTreeDFS(5, e2) : "Test 2 Invalid Cycle Tree Failed";
        assert !validTreeUnionFind(5, e2) : "UF Test 2 Invalid Cycle Tree Failed";

        int[][] dis = {{0, 1}, {1, 2}, {2, 0}};
        assert !validTreeDFS(4, dis) : "Disconnected component cycle";
        assert !validTreeUnionFind(4, dis) : "UF Disconnected component cycle";

        assert validTreeUnionFind(1, new int[][]{}) : "Single node 0 edges is valid tree";
        assert !validTreeUnionFind(2, new int[][]{}) : "2 nodes 0 edges invalid";
        assert !validTreeUnionFind(2, null) : "Null edges invalid";

        System.out.println("Execution completed successfully for GraphValidTree.");
    }
}
